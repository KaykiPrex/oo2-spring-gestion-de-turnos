package com.unla.grupo18.services;

import com.unla.grupo18.model.Specialty;
import com.unla.grupo18.repositories.ISpecialityRepository;
import com.unla.grupo18.services.abstraction.ISpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements ISpecialtyService {
    private final ISpecialityRepository repository;

    public SpecialityServiceImpl(ISpecialityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Specialty getById(String id) {
        return repository.findById(Integer.valueOf(id)).orElseThrow();
    }
}
