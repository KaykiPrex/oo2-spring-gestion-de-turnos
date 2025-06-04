package com.unla.grupo18.services;

import com.unla.grupo18.model.Specialty;
import com.unla.grupo18.repositories.ISpecialityRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {
    private final ISpecialityRepository repository;

    public SpecialityService(ISpecialityRepository repository) {
        this.repository = repository;
    }

    public Specialty getById(String id) {
        return repository.findById(Integer.valueOf(id)).orElseThrow();
    }
}
