package com.unla.grupo18.controller;

import com.unla.grupo18.model.Category;
import com.unla.grupo18.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String getCategoryById(Model model, @PathVariable String id) {
        Category category = service.getById(id);
        model.addAttribute("category", category);
        return "client/home/categories/specialities";
    }
}
