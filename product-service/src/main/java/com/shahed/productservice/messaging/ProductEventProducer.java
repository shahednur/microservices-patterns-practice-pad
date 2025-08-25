package com.shahed.productservice.messaging;

import com.shahed.productservice.events.InventoryReserved;
import com.shahed.productservice.events.InventoryReservationFailed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendInventoryReserved(InventoryReserved event) {
        log.info("Publishing InventoryReserved event: {}", event);
        kafkaTemplate.send(KafkaTopics.INVENTORY_RESERVED, event);
    }

    public void sendInventoryReservationFailed(InventoryReservationFailed event) {
        log.info("Publishing InventoryReservationFailed event: {}", event);
        kafkaTemplate.send(KafkaTopics.INVENTORY_RESERVATION_FAILED, event);
    }
}
