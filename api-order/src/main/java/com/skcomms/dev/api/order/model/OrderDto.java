package com.skcomms.dev.api.order.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private String orderId;
    private User user;
    private Product product;
    private LocalDateTime created;
}
