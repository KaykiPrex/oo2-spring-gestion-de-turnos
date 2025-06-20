package com.unla.grupo18.services;

import com.unla.grupo18.model.ProfessionalService;
import com.unla.grupo18.repositories.IProfessionalServiceRepository;
import com.unla.grupo18.services.abstraction.IProfessionalServiceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<com.unla.grupo18.model.Service> getServicesByProfessional(HttpSession session) {
        Integer professionalId = (Integer) session.getAttribute("userId");
        List<ProfessionalService> professionalServices = repository.findByProfessionalId(professionalId);

        return professionalServices.stream()
                .map(ProfessionalService::getService)
                .distinct()
                .toList();
    }
}
