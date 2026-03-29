package com.joaogabriel.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogabriel.vendas.entities.Order;
import com.joaogabriel.vendas.repositories.IOrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private IOrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		
		if(order.isEmpty()) {
			return null;
		}else {
			return order.get();
		}
	}
}
