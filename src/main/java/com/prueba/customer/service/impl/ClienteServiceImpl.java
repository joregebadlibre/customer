package com.prueba.customer.service.impl;

import com.prueba.customer.exception.ClienteException;
import com.prueba.customer.repository.ClienteRepository;
import com.prueba.customer.repository.entity.Cliente;
import com.prueba.customer.service.ClienteService;
import com.prueba.customer.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) throws ClienteException {
        try {
            return clienteRepository.findById(id);
        }
        catch (Exception ex) {
            throw new ClienteException(Constants.ERROR_FIND);
        }
    }

    public Cliente save(Cliente cliente) throws ClienteException {
        try {
            return clienteRepository.save(cliente);
        }
        catch (Exception ex) {
            throw new ClienteException(Constants.ERROR_SAVE);
        }
    }

    public Cliente update(Cliente cliente) throws ClienteException {
        try {
            return clienteRepository.save(cliente);
        }
        catch (Exception ex) {
            throw new ClienteException(Constants.ERROR_UPDATE);
        }
    }

    public void delete(Long id) throws ClienteException {
        try {
            clienteRepository.deleteById(id);
        }catch (Exception ex) {
            throw new ClienteException(Constants.ERROR_DELETE);
        }
    }
}
