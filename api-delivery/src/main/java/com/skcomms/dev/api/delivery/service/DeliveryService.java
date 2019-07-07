package com.skcomms.dev.api.delivery.service;

import com.skcomms.dev.api.delivery.model.Delivery;
import com.skcomms.dev.api.delivery.model.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    public DeliveryDto findById(String deliveryId);
    public List<DeliveryDto> findAll();
}
