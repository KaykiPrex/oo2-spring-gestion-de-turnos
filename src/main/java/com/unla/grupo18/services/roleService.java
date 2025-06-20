package com.unla.grupo18.services;

import com.unla.grupo18.model.Role;
import com.unla.grupo18.repositories.IRoleRepository;

import java.util.Optional;

public class roleService {
    private static IRoleRepository roleRepository = null;

    public roleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public static Optional<Role> findByName(String username){
        return roleRepository.findByName(username);
    }
}
