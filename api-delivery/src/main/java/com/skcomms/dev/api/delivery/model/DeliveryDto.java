package com.skcomms.dev.api.delivery.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryDto {
    private String deliveryId;
    private Order order;
    private LocalDateTime shippingDate;
    private String shippingAddress;
}
