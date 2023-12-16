package io.github.rodrigojfagundes.carwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rodrigojfagundes.carwork.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
