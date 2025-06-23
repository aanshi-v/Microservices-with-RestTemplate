package com.design.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.design.dto.UserDTO;
import com.design.entity.Order;
import com.design.repository.OrderRepository;


/**
 *  Project Structure
    User Service (user-service) — exposes user data

    Order Service (order-service) — fetches user info from user-service using RestTemplate
    
    user-service: runs on 8081
    order-service: runs on 8082
 */
@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepo;

    @Autowired
    private RestTemplate restTemplate;


	public Map<String, Object> getOrderWithUser(Long orderId) {
		 Order order = orderRepo.findById(orderId).orElse(null);
	        UserDTO user = restTemplate.getForObject("http://localhost:8081/users/" + order.getUserId(), UserDTO.class);

	        Map<String, Object> response = new HashMap<>();
	        response.put("order", order);
	        response.put("user", user);

	        return response;
	}
	
	
	
	
	
	public Order saveOrder(Order order) {
	    return orderRepo.save(order);
	}
	
	
}
