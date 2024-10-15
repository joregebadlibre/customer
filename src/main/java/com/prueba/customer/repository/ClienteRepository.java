package com.prueba.customer.repository;

import com.prueba.customer.repository.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
}