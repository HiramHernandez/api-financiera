package com.gestionfinanciera.artigoajava.services;

import com.gestionfinanciera.artigoajava.entities.Category;
import com.gestionfinanciera.artigoajava.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
    }
}
