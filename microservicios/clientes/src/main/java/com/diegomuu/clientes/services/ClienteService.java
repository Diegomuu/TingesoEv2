package com.diegomuu.clientes.services;

import com.diegomuu.clientes.entity.ClienteEntity;
import com.diegomuu.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity obtenerCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void registrarCliente(ClienteEntity cliente) {
        clienteRepository.save(cliente);
    }
}

