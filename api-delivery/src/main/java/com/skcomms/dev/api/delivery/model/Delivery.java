package com.skcomms.dev.api.delivery.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Delivery {
    private String deliveryId;
    private String orderId;
    private LocalDateTime shippingDate;
    private String shippingAddress;
}
