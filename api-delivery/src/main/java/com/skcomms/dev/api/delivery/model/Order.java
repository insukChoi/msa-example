package com.skcomms.dev.api.delivery.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {
    private String orderId;
    private User user;
    private Product product;
    private LocalDateTime created;
}
