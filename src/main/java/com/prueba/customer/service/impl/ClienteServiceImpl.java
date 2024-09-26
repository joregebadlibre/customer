package com.prueba.customer.service.impl;

import com.prueba.customer.repository.ClienteRepository;
import com.prueba.customer.repository.PersonaRepository;
import com.prueba.customer.repository.entity.Cliente;
import com.prueba.customer.repository.entity.Persona;
import com.prueba.customer.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;
    private PersonaRepository personaRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, PersonaRepository personaRepository) {
        this.clienteRepository = clienteRepository;
        this.personaRepository = personaRepository;
    }

    public Cliente save(Cliente cliente) {

        Optional<Persona> personaOpt = personaRepository.findById(cliente.getPersona().getPersonaId());
        if (!personaOpt.isPresent()) {
            // Guardar la persona si no existe
            Persona savedPersona = personaRepository.save(cliente.getPersona());
            cliente.setPersona(savedPersona);
        } else {
            cliente.setPersona(personaOpt.get());
        }
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

}
