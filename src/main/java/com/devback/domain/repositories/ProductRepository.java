package com.devback.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devback.domain.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
