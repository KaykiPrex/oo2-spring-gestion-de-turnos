package com.unla.grupo18.services;

import com.unla.grupo18.model.Client;
import com.unla.grupo18.model.Role;
import com.unla.grupo18.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class clientService {

    private final IClientRepository clientRepository;

    @Autowired
    public clientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Optional<Client> findByUsername(String username){
       return clientRepository.findByUsername(username);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public ResponseEntity<String> createClient(String username, String password, String name, String lastName, String dni) {
        if (clientRepository.findByUsername(username).isPresent()) {
            return ResponseEntity.ok("El nombre de usuario ya está en uso");
        }

        Client client = new Client(username, password, name, lastName, dni);

        System.out.println(client);
        Role role = roleService.findByName("client")
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        client.setRole(role);
        clientRepository.save(client);

        return null;
    }

}
