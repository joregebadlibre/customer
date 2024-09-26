package com.prueba.customer.service;

import com.prueba.customer.repository.entity.Persona;

public interface PersonaService {

    Persona save(Persona persona);
    Persona update(Persona persona);
    void delete(Long id);
}
