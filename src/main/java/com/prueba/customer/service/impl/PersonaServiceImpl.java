package com.prueba.customer.service.impl;

import com.prueba.customer.exception.ClienteException;
import com.prueba.customer.exception.PersonaException;
import com.prueba.customer.repository.PersonaRepository;
import com.prueba.customer.repository.entity.Persona;
import com.prueba.customer.service.PersonaService;
import com.prueba.customer.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona save(Persona persona) throws PersonaException {
        try
        {
        return personaRepository.save(persona);
        }
        catch (Exception ex) {
            throw new PersonaException(Constants.ERROR_SAVE);
        }
    }

    public Persona update(Persona persona) throws PersonaException {
        try
        {
        return personaRepository.save(persona);
        }
        catch (Exception ex) {
            throw new PersonaException(Constants.ERROR_UPDATE);
        }
    }

    public void delete(Long id) throws PersonaException {
        try
        {
        personaRepository.deleteById(id);
        }catch (Exception ex) {
            throw new PersonaException(Constants.ERROR_DELETE);
        }
    }

    public Optional<Persona> findById(Long id) throws PersonaException {
        try
        {
        return personaRepository.findById(id);
        }
        catch (Exception ex) {
            throw new PersonaException(Constants.ERROR_FIND);
        }
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

}