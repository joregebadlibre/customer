package com.prueba.customer.controller;

import com.prueba.customer.repository.entity.Persona;
import com.prueba.customer.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private PersonaService personaServiceImpl;

    public PersonaController(PersonaService personaServiceImpl) {
        this.personaServiceImpl = personaServiceImpl;
    }

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return personaServiceImpl.save(persona);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable Long id, @RequestBody Persona persona) {
        persona.setPersonaId(id);
        return personaServiceImpl.update(persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personaServiceImpl.delete(id);
    }

}
