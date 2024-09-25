package com.prueba.customer.service.impl;

import com.prueba.customer.repository.ClienteRepository;
import com.prueba.customer.repository.entity.Cliente;
import com.prueba.customer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }
//
//    public List<Cliente> findAll() {
//        return clienteRepository.findAll();
//    }
}
