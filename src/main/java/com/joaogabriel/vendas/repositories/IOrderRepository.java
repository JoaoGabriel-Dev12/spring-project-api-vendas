package com.joaogabriel.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaogabriel.vendas.entities.Order;

public interface IOrderRepository extends JpaRepository<Order, Long>{

}
