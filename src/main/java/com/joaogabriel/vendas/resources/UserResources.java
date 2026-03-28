package com.joaogabriel.vendas.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.vendas.entities.User;

@RestController
@RequestMapping("/users")
public class UserResources {
	
	@GetMapping("/")
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "João GAbriel", "joao@email", "80028922", "senha");
		return ResponseEntity.ok().body(u);
	}
}
