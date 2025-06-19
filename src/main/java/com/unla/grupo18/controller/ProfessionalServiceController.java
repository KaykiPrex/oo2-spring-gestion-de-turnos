package com.unla.grupo18.controller;

import com.unla.grupo18.model.ProfessionalService;
import com.unla.grupo18.services.ProfessionalServiceServiceImpl;
import com.unla.grupo18.services.abstraction.IProfessionalServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professionalservices")
public class ProfessionalServiceController {
    private final IProfessionalServiceService service;

    public ProfessionalServiceController(ProfessionalServiceServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getProfessionalServiceById(Model model, @PathVariable String id) {
        ProfessionalService professionalService = service.getById(id);
        model.addAttribute("professionalService", professionalService);
        return "client/home/categories/specialities/services/professionals/calendar";
    }
}
