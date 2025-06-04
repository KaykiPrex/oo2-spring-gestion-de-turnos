package com.unla.grupo18.services;

import com.unla.grupo18.model.ProfessionalService;
import com.unla.grupo18.repositories.IProfessionalServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalServiceService {
    private final IProfessionalServiceRepository repository;

    public ProfessionalServiceService(IProfessionalServiceRepository repository) {
        this.repository = repository;
    }

    public ProfessionalService getById(String id) {
        return repository.findById(Integer.valueOf(id)).orElseThrow();
    }
}
