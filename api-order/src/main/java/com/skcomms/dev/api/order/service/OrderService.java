package com.skcomms.dev.api.order.service;

import com.skcomms.dev.api.order.model.OrderDto;

import java.util.List;

public interface OrderService {

    public List<OrderDto> findOrders();
    public OrderDto findOne(String orderId);
    public List<OrderDto> findByUserId(String userId);


}
