package com.skcomms.dev.api.delivery.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.skcomms.dev.api.delivery.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderAdapter {

    private final RestTemplate restTemplate;

    @Autowired
    OrderAdapter(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getOrderByIdFallback")
    public Order getOrderById(String orderId)
    {
        return restTemplate.getForObject("http://API-ORDER-DEV/v1/order/"+orderId, Order.class);
    }

    Order getOrderByIdFallback(String orderId)
    {
        Order dto=new Order();
        dto.setOrderId(orderId);

        return dto;
    }
}
