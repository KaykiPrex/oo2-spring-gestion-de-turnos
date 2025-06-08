package com.unla.grupo18.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.unla.grupo18.model.Role;

import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}