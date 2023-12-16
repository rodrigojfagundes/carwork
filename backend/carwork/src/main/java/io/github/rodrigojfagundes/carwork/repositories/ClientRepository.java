package io.github.rodrigojfagundes.carwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rodrigojfagundes.carwork.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
