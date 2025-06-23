package com.design.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.design.entity.Order;
import com.design.service.OrderService;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
    private OrderService service;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOrderWithUser(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderWithUser(id));
    }
    
    
    
    
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = service.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

}
