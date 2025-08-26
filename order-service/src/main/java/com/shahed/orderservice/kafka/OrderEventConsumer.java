package com.shahed.orderservice.kafka;

import com.shahed.orderservice.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventConsumer {

    @KafkaListener(topics = "order-events", groupId = "order-service-group")
    public void consumeOrderEvents(Order order) {
        log.info("✅ Consumed Order Event: {}", order);
    }
}
