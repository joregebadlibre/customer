package com.prueba.customer.controller;

import com.prueba.customer.repository.entity.Cliente;
import com.prueba.customer.repository.entity.Persona;
import com.prueba.customer.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    void create() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setPersona(new Persona());
        cliente.getPersona().setNombre("John Doe");
        cliente.getPersona().setIdentificacion("1233333333");

        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId").value(1L))
                .andExpect(jsonPath("$.persona.nombre").value("John Doe"));
    }

    @Test
    void update() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setPersona(new Persona());
        cliente.getPersona().setNombre("Juan");

        when(clienteService.update(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(put("/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId").value(1L))
                .andExpect(jsonPath("$.persona.nombre").value("Juan"));
    }
}