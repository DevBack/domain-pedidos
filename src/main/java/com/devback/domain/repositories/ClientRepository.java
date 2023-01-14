package com.devback.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devback.domain.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
