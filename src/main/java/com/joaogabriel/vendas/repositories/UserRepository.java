package com.joaogabriel.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaogabriel.vendas.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
