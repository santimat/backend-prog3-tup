package com.santi.learningspringboot.service.category;

import com.santi.learningspringboot.model.category.Category;
import com.santi.learningspringboot.repository.category.JPACategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryDeleterService {
    private final JPACategoryRepository categoryRepository;
    private final CategoryFinderService categoryFinderService;

    public CategoryDeleterService(JPACategoryRepository categoryRepository, CategoryFinderService categoryFinderService) {
        this.categoryRepository = categoryRepository;
        this.categoryFinderService = categoryFinderService;
    }

    public void deleteById(Long id) {
        Category categoryToDelete = categoryFinderService.findById(id);
        categoryRepository.delete(categoryToDelete);
    }
}
