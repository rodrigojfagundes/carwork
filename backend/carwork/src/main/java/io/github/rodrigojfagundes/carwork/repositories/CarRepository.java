package io.github.rodrigojfagundes.carwork.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.rodrigojfagundes.carwork.entities.Car;
import io.github.rodrigojfagundes.carwork.entities.Client;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	
	@Query("SELECT obj FROM Car obj WHERE :client IS NULL OR obj.client = :client")
	Page<Car> find(Client client, Pageable pageable);
	
	
}
