package com.prueba.customer.repository;

import com.prueba.customer.repository.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}