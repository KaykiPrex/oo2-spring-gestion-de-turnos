package com.unla.grupo18.services.abstraction;

import com.unla.grupo18.model.ProfessionalService;
import com.unla.grupo18.model.Service;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface IProfessionalServiceService {
    ProfessionalService getById(String id);

    List<Service> getServicesByProfessional(HttpSession session);
}
