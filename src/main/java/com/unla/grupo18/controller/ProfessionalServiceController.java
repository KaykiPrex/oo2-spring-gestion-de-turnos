package com.unla.grupo18.controller;

import com.unla.grupo18.model.ProfessionalService;
import com.unla.grupo18.model.Service;
import com.unla.grupo18.services.ProfessionalServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professionalservices")
public class ProfessionalServiceController {
    private final ProfessionalServiceService service;

    public ProfessionalServiceController(ProfessionalServiceService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getProfessionalServiceById(Model model, @PathVariable String id) {
        ProfessionalService professionalService = service.getById(id);
        model.addAttribute("professionalService", professionalService);
        return "client/home/categories/specialities/services/professionals/calendar";
    }
}
