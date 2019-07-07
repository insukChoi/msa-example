package com.skcomms.dev.api.delivery.service;

import com.skcomms.dev.api.delivery.model.Delivery;
import com.skcomms.dev.api.delivery.model.DeliveryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final OrderAdapter orderAdapter;

    @Autowired
    DeliveryServiceImpl(DeliveryRepository deliveryRepository, OrderAdapter orderAdapter)
    {
        this.deliveryRepository=deliveryRepository;
        this.orderAdapter=orderAdapter;
    }

    DeliveryDto buildDeliveryDto(Delivery delivery)
    {
        DeliveryDto dto =  new DeliveryDto();
        dto.setDeliveryId(delivery.getDeliveryId());
        dto.setShippingAddress(delivery.getShippingAddress());
        dto.setShippingDate(delivery.getShippingDate());
        dto.setOrder(orderAdapter.getOrderById(delivery.getOrderId()));
        return dto;
    }

    @Override
    public DeliveryDto findById(String deliveryId) {

        return buildDeliveryDto(deliveryRepository.findOne(deliveryId));
    }

    @Override
    public List<DeliveryDto> findAll() {
        List<DeliveryDto> list=new ArrayList<>();
        for(Delivery delivery:deliveryRepository.findAll())
        {
            list.add(buildDeliveryDto(delivery));
        }
        return list;
    }
}
