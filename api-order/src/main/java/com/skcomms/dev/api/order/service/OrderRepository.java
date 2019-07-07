package com.skcomms.dev.api.order.service;

import com.skcomms.dev.api.common.exception.DataNotFoundException;
import com.skcomms.dev.api.order.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderRepository {

    private static List<Order> orders=new ArrayList<>();

    @PostConstruct
    void init()
    {
        orders.add(Order.builder().orderId("0001").productId("0001").userId("u001").created(LocalDateTime.now()).build());
        orders.add(Order.builder().orderId("0002").productId("0002").userId("u001").created(LocalDateTime.now()).build());
        orders.add(Order.builder().orderId("0003").productId("0003").userId("u002").created(LocalDateTime.now()).build());
        orders.add(Order.builder().orderId("0004").productId("0004").userId("u002").created(LocalDateTime.now()).build());
        orders.add(Order.builder().orderId("0005").productId("0005").userId("u003").created(LocalDateTime.now()).build());
        orders.add(Order.builder().orderId("0006").productId("0001").userId("u003").created(LocalDateTime.now()).build());
        orders.add(Order.builder().orderId("0007").productId("0002").userId("u005").created(LocalDateTime.now()).build());

    }

    public Order findOne(String orderId)
    {
        return orders.stream().filter(order -> orderId.equalsIgnoreCase(order.getOrderId())).findFirst().orElseThrow(()->new DataNotFoundException("주문 내역이 없습니다."));
    }

    public List<Order> findByUserId(String userId)
    {
        return orders.stream().filter(order -> userId.equalsIgnoreCase(order.getUserId())).collect(Collectors.toList());
    }

    public List<Order> findAll(){
        return orders;
    }

}
