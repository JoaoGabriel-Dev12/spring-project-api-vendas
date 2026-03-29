package com.joaogabriel.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaogabriel.vendas.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
