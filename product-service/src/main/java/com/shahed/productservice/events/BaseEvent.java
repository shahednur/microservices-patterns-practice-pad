package com.shahed.productservice.events;

import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEvent {
    private String eventId = UUID.randomUUID().toString();
    private Instant occurredAt = Instant.now();
}
