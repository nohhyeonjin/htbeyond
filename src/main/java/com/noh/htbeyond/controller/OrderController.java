package com.noh.htbeyond.controller;

import com.noh.htbeyond.controller.dto.OrderResDTO;
import com.noh.htbeyond.model.Orders;
import com.noh.htbeyond.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/{id}")
    public List<OrderResDTO> getOrders(@PathVariable Long id) {
        List<Orders> orders = orderService.findById(id);
        return orders.stream()
                .map(order -> new OrderResDTO(order.getOrderNum(), order.getProductName(), order.getPaymentTime()))
                .collect(Collectors.toList());
    }
    
}
