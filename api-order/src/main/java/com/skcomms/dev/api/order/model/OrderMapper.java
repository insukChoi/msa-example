package com.skcomms.dev.api.order.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper instance = Mappers.getMapper(OrderMapper.class);

    @Mappings({
            @Mapping(source = "order.orderId",target = "orderId"),
            @Mapping(source = "order.created",target = "created")
    })
    OrderDto map(Order order, User user,Product product);

}
