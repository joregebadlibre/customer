package com.prueba.customer.controller;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    private final StreamBridge streamBridge;

    public ClienteController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        // Lógica para guardar cliente
        streamBridge.send("output", cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
