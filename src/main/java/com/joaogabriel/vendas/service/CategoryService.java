package com.joaogabriel.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogabriel.vendas.entities.Category;
import com.joaogabriel.vendas.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);

		if (category.isEmpty()) {
			return null;
		} else {
			return category.get();
		}
	}
}
