package com.shahed.productservice.messaging;

import com.shahed.productservice.entity.Product;
import com.shahed.productservice.events.InventoryReserved;
import com.shahed.productservice.events.InventoryReservationFailed;
import com.shahed.productservice.events.OrderCreated;
import com.shahed.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductEventConsumer {

    private final ProductService productService;
    private final ProductEventProducer producer;

    @KafkaListener(topics = KafkaTopics.ORDER_CREATED, groupId = "product-service")
    public void handleOrderCreated(OrderCreated event) {
        log.info("Received OrderCreated event: {}", event);

        // Step 1: Find product
        Product product = productService.getProductById(Long.parseLong(event.getSku()))
                .orElse(null);

        if (product == null) {
            log.warn("Product not found: {}", event.getSku());
            producer.sendInventoryReservationFailed(
                    new InventoryReservationFailed(event.getOrderId(), "Product not found"));
            return;
        }

        // Step 2: Check stock
        if (product.getStockQuantity() < event.getQuantity()) {
            log.warn("Insufficient stock for product {}. Available: {}, Required: {}",
                    product.getName(), product.getStockQuantity(), event.getQuantity());
            producer.sendInventoryReservationFailed(
                    new InventoryReservationFailed(event.getOrderId(), "Insufficient stock"));
            return;
        }

        // Step 3: Reserve stock
        product.setStockQuantity(product.getStockQuantity() - event.getQuantity());
        productService.createProduct(product); // save updated stock

        // Step 4: Publish InventoryReserved
        producer.sendInventoryReserved(
                new InventoryReserved(event.getOrderId(), event.getSku(), event.getQuantity()));
    }
}
