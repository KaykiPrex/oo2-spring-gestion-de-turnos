package com.unla.grupo18.controller;

import com.unla.grupo18.model.Specialty;
import com.unla.grupo18.services.SpecialityServiceImpl;
import com.unla.grupo18.services.abstraction.ISpecialtyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/specialities")
public class SpecialityController {
    private final ISpecialtyService service;

    public SpecialityController(SpecialityServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getSpecialityById(Model model, @PathVariable String id) {
        Specialty specialty = service.getById(id);
        model.addAttribute("specialty", specialty);
        return "client/home/categories/specialities/services";
    }
}
