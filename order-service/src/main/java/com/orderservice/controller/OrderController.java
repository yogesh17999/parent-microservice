package com.orderservice.controller;

import com.orderservice.dto.OrderDTO;
import com.orderservice.dto.ResponseDTO;
import com.orderservice.mapper.Mapper;
import com.orderservice.service.OrderService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private  Mapper mapper;
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> placeOrder(@RequestBody  OrderDTO orderDTO)
    {
        return new ResponseEntity<>(orderService.createOrder(mapper.dtoToEntity(orderDTO)), HttpStatus.OK);
    }

    @GetMapping("{orderNumber}")
    public ResponseEntity<ResponseDTO> getOrder(@PathVariable String orderNumber)
    {
        return new ResponseEntity<>(orderService.getOrder(orderNumber),HttpStatus.OK);
    }

    @GetMapping
    public  ResponseEntity<ResponseDTO> getAllOrder()
    {
        return new ResponseEntity<>(orderService.getListOfOrder(),HttpStatus.OK);
    }

    @PutMapping("/update")
    public  ResponseEntity<ResponseDTO> updateOrder(@RequestBody OrderDTO orderDTO)
    {
        return new ResponseEntity<>(orderService.updateOrder(mapper.dtoToEntity(orderDTO)),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderNumber}")
    public  ResponseEntity<ResponseDTO> deleteOrder(@PathVariable String orderNumber)
    {
        return new ResponseEntity<>(orderService.deleteOrder(orderNumber),HttpStatus.OK);
    }

}
