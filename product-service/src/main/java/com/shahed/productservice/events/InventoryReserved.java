package com.shahed.productservice.events;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InventoryReserved extends BaseEvent {
    private Long orderId;
    private String sku;
    private Integer quantity;
}
