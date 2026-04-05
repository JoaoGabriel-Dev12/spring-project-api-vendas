package com.joaogabriel.vendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.joaogabriel.vendas.entities.User;
import com.joaogabriel.vendas.repositories.UserRepository;
import com.joaogabriel.vendas.service.exceptions.DatabaseException;
import com.joaogabriel.vendas.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);

		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return userRepository.save(obj);
	}

	public void delete(Long id) {
		try {
			
			if(!userRepository.existsById(id)) throw new ResourceNotFoundException(id);
			userRepository.deleteById(id);
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e ) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Long id, User obj) {

		try {
			User user = userRepository.getReferenceById(id);
			updateData(user, obj);
			return userRepository.save(user);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(User user, User obj) {
		user.setName(obj.getName());
		user.setEmail(obj.getEmail());
		user.setPhone(obj.getPhone());
	}
}
