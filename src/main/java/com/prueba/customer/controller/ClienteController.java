package com.prueba.customer.controller;

import com.prueba.customer.exception.ClienteException;
import com.prueba.customer.exception.ClienteNotFoundException;
import com.prueba.customer.exception.PersonaException;
import com.prueba.customer.repository.entity.Cliente;
import com.prueba.customer.repository.entity.CustomError;
import com.prueba.customer.repository.entity.Persona;
import com.prueba.customer.service.ClienteService;
import com.prueba.customer.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    private PersonaService personaService;

    public ClienteController(ClienteService clienteService, PersonaService personaService) {
        this.clienteService = clienteService;
        this.personaService = personaService;
    }


    @GetMapping
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id) throws ClienteException {
        return clienteService.findById(id).orElseThrow( ()-> new ClienteNotFoundException( "No se encuentra el cliente")  );
    }


    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) throws ClienteException, PersonaException {

        Optional<Persona> personaOpt = personaService.findById(cliente.getPersona().getPersonaId());
        if (!personaOpt.isPresent()) {
            // Guardar la persona si no existe
            Persona savedPersona = personaService.save(cliente.getPersona());
            cliente.setPersona(savedPersona);
        } else {
            cliente.setPersona(personaOpt.get());
        }
            return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) throws ClienteException {
        cliente.setClienteId(id);
        return clienteService.update(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ClienteException {
        clienteService.delete(id);
    }

}
