package com.orderservice.service;

import com.orderservice.constants.Constants;
import com.orderservice.dto.OrderDTO;
import com.orderservice.dto.ResponseDTO;
import com.orderservice.entity.Order;
import com.orderservice.mapper.Mapper;
import com.orderservice.repository.OrderRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Mapper orderMapper;

    @Override
    public ResponseDTO createOrder(Order order) {
        order.setOrderNumber(UUID.randomUUID().toString());
        order.getOrderLineItems().forEach(item -> item.setOrder(order));
        return ResponseDTO.builder().status(HttpStatus.OK.value()).message(Constants.SUCCESS).data(orderMapper.toDto(orderRepository.save(order))).build();
    }

    @Override
    public ResponseDTO getOrder(String orderNumber) {
        Optional<Order> orderDetails = orderRepository.findByOrderNumber(orderNumber);
        return orderDetails.map(order -> new ResponseDTO(HttpStatus.OK.value(), Constants.SUCCESS, orderMapper.toDto(order))).orElseGet(() -> ResponseDTO.builder().status(HttpStatus.NO_CONTENT.value()).message(Constants.NOT_FOUND).build());
    }

    @Override
    public ResponseDTO getListOfOrder() {
        return ResponseDTO.builder().status(HttpStatus.OK.value()).message(Constants.SUCCESS).data(orderMapper.toListOfDto(orderRepository.findAll())).build();
    }

    @Override
    public ResponseDTO updateOrder(Order updateOrder) {
        Optional<Order> orderDetails = orderRepository.findByOrderNumber(updateOrder.getOrderNumber());
        return orderDetails.map(order -> ResponseDTO.builder().status(HttpStatus.OK.value()).message(Constants.SUCCESS).data(orderRepository.save(orderMapper.entityToEntity(updateOrder, order))).build())
                .orElseThrow(() ->
                     new ResponseStatusException(HttpStatus.NOT_FOUND, "Order is not available!"));
    }

    @Override
    public ResponseDTO deleteOrder(String orderNumber) {
        Optional<Order> orderDetails = orderRepository.findByOrderNumber(orderNumber);
       return orderDetails.map(order -> ResponseDTO.builder().status(HttpStatus.OK.value()).message(Constants.SUCCESS).data(orderMapper.toDto(order)).build()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "order is not available"));
    }
}
