package io.github.rodrigojfagundes.carwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.rodrigojfagundes.carwork.entities.Work;

public interface WorkRepository extends JpaRepository<Work, Long>{

}
