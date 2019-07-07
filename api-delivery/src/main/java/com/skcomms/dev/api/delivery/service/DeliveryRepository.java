package com.skcomms.dev.api.delivery.service;

import com.skcomms.dev.api.common.exception.DataNotFoundException;
import com.skcomms.dev.api.delivery.model.Delivery;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryRepository {
    private static List<Delivery> deliveries = new ArrayList<>();

    @PostConstruct
    void init()
    {
        deliveries.add(Delivery.builder().deliveryId("0001").orderId("0001").shippingAddress("서울역").shippingDate(LocalDateTime.now()).build());
        deliveries.add(Delivery.builder().deliveryId("0002").orderId("0002").shippingAddress("동대문역사공원역").shippingDate(LocalDateTime.now()).build());
        deliveries.add(Delivery.builder().deliveryId("0003").orderId("0003").shippingAddress("왕심리역").shippingDate(LocalDateTime.now()).build());
        deliveries.add(Delivery.builder().deliveryId("0004").orderId("0004").shippingAddress("강남역").shippingDate(LocalDateTime.now()).build());
        deliveries.add(Delivery.builder().deliveryId("0005").orderId("0005").shippingAddress("홍대역").shippingDate(LocalDateTime.now()).build());

    }

    public Delivery findOne(String id)
    {
        return deliveries.stream().filter(delivery -> id.equalsIgnoreCase(delivery.getDeliveryId())).findFirst().orElseThrow(()->new DataNotFoundException("주문 내역이 없습니다."));
    }

    public List<Delivery> findAll()
    {
        return deliveries;
    }
}
