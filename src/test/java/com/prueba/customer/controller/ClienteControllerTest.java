package com.prueba.customer.controller;

import com.prueba.customer.exception.ClienteException;
import com.prueba.customer.repository.entity.Cliente;
import com.prueba.customer.repository.entity.Persona;
import com.prueba.customer.service.ClienteService;
import com.prueba.customer.service.PersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ClienteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClienteService clienteService;

    @Mock
    private PersonaService pesonaService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

//    @Test
//    void create() throws Exception, ClienteException {
//        Cliente cliente = new Cliente();
//        cliente.setClienteId(1L);
//
//        Persona persona = new Persona();
//        persona.setPersonaId(1L);
//        persona.setNombre("John Doe");
//        persona.setDireccion("123 Main St");
//        persona.setIdentificacion("2222222222222222222222");
//        cliente.setPersona(persona);
//
//        when(clienteService.save(any(Cliente.class))).thenReturn(new Cliente());
//        when(pesonaService.save(any(Persona.class))).thenReturn(new Persona());
//        when(pesonaService.findById(anyLong())).thenReturn(null);
//
//        mockMvc.perform(post("/clientes")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"nombre\":\"John Doe\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.clienteId").value(1L))
//                .andExpect(jsonPath("$.persona.nombre").value("John Doe"));
//    }

    @Test
    void update() throws Exception, ClienteException {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setPersona(new Persona());
        cliente.getPersona().setPersonaId(1L);
        cliente.getPersona().setNombre("Juan");
        when(clienteService.update(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(put("/clientes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.clienteId").value(1L))
                .andExpect(jsonPath("$.persona.nombre").value("Juan"));

    }

    @Test
    void testCreate() {
    }
}