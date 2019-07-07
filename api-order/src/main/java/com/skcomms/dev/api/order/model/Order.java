package com.skcomms.dev.api.order.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Order {
    private String orderId;
    private String productId;
    private String userId;
    private LocalDateTime created;

}
