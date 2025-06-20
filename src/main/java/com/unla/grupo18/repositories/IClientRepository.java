package com.unla.grupo18.repositories;


import com.unla.grupo18.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface IClientRepository extends JpaRepository<Client, Integer> {
   Optional<Client> findByUsername(String username);
}