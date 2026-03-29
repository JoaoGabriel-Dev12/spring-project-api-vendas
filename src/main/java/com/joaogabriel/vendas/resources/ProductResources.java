package com.joaogabriel.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.vendas.entities.Product;
import com.joaogabriel.vendas.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResources {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id){
		Product p = service.findById(id);
		
		if(p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		
		return ResponseEntity.ok().body(p);
	}
}
