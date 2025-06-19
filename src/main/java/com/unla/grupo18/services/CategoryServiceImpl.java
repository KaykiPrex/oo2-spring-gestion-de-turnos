package com.unla.grupo18.services;

import com.unla.grupo18.model.Category;
import com.unla.grupo18.repositories.ICategoryRepository;
import com.unla.grupo18.services.abstraction.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository repository;

    public CategoryServiceImpl(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category getName(String name) {
        return repository.findByName(name).orElseThrow();
    }

    @Override
    public Category getById(String id) {
        return repository.findById(Integer.valueOf(id)).orElseThrow();
    }
}
