package com.devback.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devback.domain.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
