package com.unla.grupo18.services;

import com.unla.grupo18.model.ProfessionalService;
import com.unla.grupo18.repositories.IProfessionalServiceRepository;
import com.unla.grupo18.services.abstraction.IProfessionalServiceService;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalServiceServiceImpl implements IProfessionalServiceService {
    private final IProfessionalServiceRepository repository;

    public ProfessionalServiceServiceImpl(IProfessionalServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProfessionalService getById(String id) {
        return repository.findById(Integer.valueOf(id)).orElseThrow();
    }
}
