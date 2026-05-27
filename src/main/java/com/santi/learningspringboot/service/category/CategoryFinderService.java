package com.santi.learningspringboot.service.category;

import com.santi.learningspringboot.exception.category.CategoryNotFoundException;
import com.santi.learningspringboot.model.category.Category;
import com.santi.learningspringboot.repository.category.JPACategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryFinderService {
    private final JPACategoryRepository categoryRepository;

    public CategoryFinderService(JPACategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
