package com.joaogabriel.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaogabriel.vendas.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
