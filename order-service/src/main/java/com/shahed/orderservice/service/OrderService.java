package com.shahed.orderservice.service;

import java.util.List;
import java.util.Optional;

import com.shahed.orderservice.entity.Order;

public interface OrderService {
    Order placeOrder(Order order);

    List<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);
}
