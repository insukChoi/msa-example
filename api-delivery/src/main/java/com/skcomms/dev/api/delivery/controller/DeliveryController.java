package com.skcomms.dev.api.delivery.controller;


import com.skcomms.dev.api.delivery.model.DeliveryDto;
import com.skcomms.dev.api.delivery.service.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1/delivery", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class DeliveryController {

    private final DeliveryService deliveryService;
    @Autowired
    DeliveryController(DeliveryService deliveryService)
    {
        this.deliveryService=deliveryService;
    }

    @GetMapping("")
    public ResponseEntity<List<DeliveryDto>> findAll()
    {
        return ResponseEntity.ok(deliveryService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDto> findOne(@PathVariable String id)
    {
        return ResponseEntity.ok(deliveryService.findById(id));
    }

}
