package com.prueba.customer.service.impl;

import com.prueba.customer.repository.PersonaRepository;
import com.prueba.customer.repository.entity.Persona;
import com.prueba.customer.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }
}