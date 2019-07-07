package com.skcomms.dev.api.order.service;

import com.skcomms.dev.api.order.model.Order;
import com.skcomms.dev.api.order.model.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserAdapter userAdapter;
    private final ProductAdapter productAdapter;

    @Autowired
    OrderServiceImpl(OrderRepository orderRepository,UserAdapter userAdapter,ProductAdapter productAdapter)
    {
        this.orderRepository=orderRepository;
        this.userAdapter=userAdapter;
        this.productAdapter=productAdapter;
    }

    private OrderDto getOrderData(Order order)
    {
        OrderDto dto=new OrderDto();
        dto.setOrderId(order.getOrderId());
        dto.setCreated(order.getCreated());
        dto.setUser(userAdapter.getUserById(order.getUserId()));
        dto.setProduct(productAdapter.getProductById(order.getProductId()));
        return dto;
    }

    @Override
    public List<OrderDto> findOrders() {
        List<OrderDto> list=new ArrayList<>();
        for(Order order: orderRepository.findAll())
        {
            list.add(getOrderData(order));
        }
        return list;
    }

    @Override
    public OrderDto findOne(String orderId) {
        return getOrderData(orderRepository.findOne(orderId));
    }

    @Override
    public List<OrderDto> findByUserId(String userId) {
        List<OrderDto> list=new ArrayList<>();
        for(Order order: orderRepository.findByUserId(userId))
        {
            list.add(getOrderData(order));
        }
        return list;
    }
}
