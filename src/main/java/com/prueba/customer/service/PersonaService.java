package com.prueba.customer.service;

import com.prueba.customer.exception.PersonaException;
import com.prueba.customer.repository.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    Persona save(Persona persona) throws PersonaException;
    Persona update(Persona persona) throws PersonaException;
    void delete(Long id) throws PersonaException;
    Optional<Persona> findById(Long id) throws PersonaException;
    List<Persona> findAll();
}
