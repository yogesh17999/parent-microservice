package com.orderservice.mapper;

import com.orderservice.dto.OrderDTO;
import com.orderservice.entity.Order;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    Order dtoToEntity(OrderDTO orderDTO);

    OrderDTO toDto(Order order);

    @Mapping(target = "id",ignore = true)
    Order entityToEntity(Order order, @MappingTarget Order updateOrder);

    List<OrderDTO> toListOfDto(List<Order> orderList);

}
