package com.orderservice.service;

import com.orderservice.dto.OrderDTO;
import com.orderservice.dto.ResponseDTO;
import com.orderservice.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {
    ResponseDTO createOrder(Order order);

    ResponseDTO getOrder(String orderNumber);

    ResponseDTO getListOfOrder();

    ResponseDTO updateOrder(Order updateOrder);

    ResponseDTO deleteOrder(String orderNumber);

}
