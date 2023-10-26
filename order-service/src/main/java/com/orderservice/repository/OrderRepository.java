package com.orderservice.repository;

import com.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    boolean existsByOrderNumber(String orderNumber);

    Optional<Order> findByOrderNumber(String orderNumber);
}
