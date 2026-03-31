package com.joaogabriel.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaogabriel.vendas.entities.OrderItem;
import com.joaogabriel.vendas.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
