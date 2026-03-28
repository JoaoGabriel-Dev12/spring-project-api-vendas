package com.joaogabriel.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.vendas.entities.Order;
import com.joaogabriel.vendas.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResources {
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id){
		Order o = service.findById(id);
		
		if(o == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
		}
		
		return ResponseEntity.ok().body(o);
	}
}
