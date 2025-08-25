package com.shahed.productservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.shahed.productservice.messaging.KafkaTopics;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic orderCreatedTopic() {
        return new NewTopic(KafkaTopics.ORDER_CREATED, 1, (short) 1);
    }

    @Bean
    public NewTopic inventoryReservedTopic() {
        return new NewTopic(KafkaTopics.INVENTORY_RESERVED, 1, (short) 1);
    }

    @Bean
    public NewTopic inventoryReservationFailedTopic() {
        return new NewTopic(KafkaTopics.INVENTORY_RESERVATION_FAILED, 1, (short) 1);
    }
}
