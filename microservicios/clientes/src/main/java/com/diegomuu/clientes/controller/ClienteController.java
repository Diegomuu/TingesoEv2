package com.diegomuu.clientes.controller;

import com.diegomuu.clientes.entity.ClienteEntity;
import com.diegomuu.clientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> obtenerCliente(@PathVariable Long id) {
        ClienteEntity cliente = clienteService.obtenerCliente(id);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> registrarCliente(@RequestBody ClienteEntity cliente) {
        clienteService.registrarCliente(cliente);
        return ResponseEntity.ok("Cliente registrado: " + cliente.getNombre());
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<ClienteEntity> buscarCliente(@PathVariable String nombre) {
        return clienteService.buscarClientePorNombre(nombre)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
