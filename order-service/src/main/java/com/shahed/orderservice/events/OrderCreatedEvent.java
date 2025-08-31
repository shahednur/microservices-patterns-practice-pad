package com.shahed.orderservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {
    private String orderNumber;
    private String productCode;
    private Integer quantity;
    private Double totalPrice;
}
