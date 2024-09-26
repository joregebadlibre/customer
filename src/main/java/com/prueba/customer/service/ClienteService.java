package com.prueba.customer.service;

import com.prueba.customer.repository.entity.Cliente;

public interface ClienteService {

    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(Long id);
}
