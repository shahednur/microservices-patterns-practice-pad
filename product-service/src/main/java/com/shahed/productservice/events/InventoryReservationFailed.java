package com.shahed.productservice.events;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InventoryReservationFailed extends BaseEvent {
    private Long orderId;
    private String reason;
}
