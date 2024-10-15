package com.prueba.customer.service;

import com.prueba.customer.exception.ClienteException;
import com.prueba.customer.repository.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Cliente save(Cliente cliente) throws ClienteException;
    Cliente update(Cliente cliente) throws ClienteException;
    void delete(Long id) throws ClienteException;

    List<Cliente> findAll();
    Optional<Cliente> findById(Long id) throws ClienteException;

}
