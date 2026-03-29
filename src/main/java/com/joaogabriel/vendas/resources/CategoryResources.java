package com.joaogabriel.vendas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.vendas.entities.Category;
import com.joaogabriel.vendas.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResources {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id){
		Category c = service.findById(id);
		
		if(c == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não encontrada");
		}
		
		return ResponseEntity.ok().body(c);
	}
}
