package com.unla.grupo18.services;

import com.unla.grupo18.model.Service;
import com.unla.grupo18.repositories.IServiceRepository;



import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    private final IServiceRepository serviceRepository;

    public ServiceService(IServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public com.unla.grupo18.model.Service getById(String id) {
        return serviceRepository.findById(Integer.valueOf(id)).orElseThrow();
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }
}
