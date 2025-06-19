package com.unla.grupo18.controller;

import com.unla.grupo18.model.Service;
import com.unla.grupo18.services.ServiceServiceImpl;
import com.unla.grupo18.services.abstraction.IServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServiceController {
    private final IServiceService service;

    public ServiceController(ServiceServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getSpecialityById(Model model, @PathVariable String id) {
        Service serviceAttribute = service.getById(id);
        model.addAttribute("service", serviceAttribute);
        return "client/home/categories/specialities/services/professionals";
    }
}
