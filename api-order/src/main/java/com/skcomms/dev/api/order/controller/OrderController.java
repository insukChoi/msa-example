package com.skcomms.dev.api.order.controller;

import com.skcomms.dev.api.order.model.OrderDto;
import com.skcomms.dev.api.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1/order", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class OrderController {

    private final OrderService orderService;

    @Autowired
    OrderController(OrderService service)
    {
        this.orderService=service;
    }

    @GetMapping("")
    public ResponseEntity<List<OrderDto>> findAll(@RequestParam(required = false) String userId)
    {
        if(userId!=null && userId.startsWith("u"))
            return ResponseEntity.ok(orderService.findByUserId(userId));

        return ResponseEntity.ok(orderService.findOrders());
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findOne(@PathVariable String id)
    {
        return ResponseEntity.ok(orderService.findOne(id));
    }



}
