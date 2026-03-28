package com.joaogabriel.vendas.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogabriel.vendas.entities.User;

@RestController
@RequestMapping("/users")
public class UserResources {
	
	@GetMapping("/")
	public List<User> findAll(){
		
		List<User> list = new ArrayList<>();
		list.add(new User(1L, "João Gabriel", "joao@email", "80028922", "senha"));
		list.add(new User(1L, "Bianca", "bianca@email", "5637829", "1234"));
		list.add(new User(1L, "Bolsonaro mito", "bolsonaro@email", "123456789", "globolixo"));
		list.add(new User(1L, "Osama Bin Laden", "bomba@email", "87879871", "torresgemeas"));
		
		return list;
	}
}
