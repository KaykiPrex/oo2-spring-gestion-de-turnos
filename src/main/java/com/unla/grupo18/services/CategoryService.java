package com.unla.grupo18.services;

import com.unla.grupo18.model.Category;
import com.unla.grupo18.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category getName(String name) {
        return repository.findByName(name).orElseThrow();
    }

    public Category getById(String id) {
        return repository.findById(Integer.valueOf(id)).orElseThrow();
    }
}
