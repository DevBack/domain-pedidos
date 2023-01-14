package com.devback.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devback.domain.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
