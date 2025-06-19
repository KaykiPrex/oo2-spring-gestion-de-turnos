package com.unla.grupo18.services.abstraction;

import com.unla.grupo18.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    Category getName(String name);
    Category getById(String id);
}
