package com.unla.grupo18.services;

import com.unla.grupo18.repositories.IServiceRepository;
import com.unla.grupo18.services.abstraction.IServiceService;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements IServiceService {
    private final IServiceRepository serviceRepository;

    public ServiceServiceImpl(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public com.unla.grupo18.model.Service getById(String id) {
        return serviceRepository.findById(Integer.valueOf(id)).orElseThrow();
    }
}
