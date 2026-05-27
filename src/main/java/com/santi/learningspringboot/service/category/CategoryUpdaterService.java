package com.santi.learningspringboot.service.category;


import com.santi.learningspringboot.dto.request.category.CategoryRequest;
import com.santi.learningspringboot.model.category.Category;
import com.santi.learningspringboot.repository.category.JPACategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryUpdaterService {
    private final JPACategoryRepository categoryRepository;
    private final CategoryFinderService categoryFinderService;

    public CategoryUpdaterService(JPACategoryRepository categoryRepository, CategoryFinderService categoryFinderService) {
        this.categoryRepository = categoryRepository;
        this.categoryFinderService = categoryFinderService;
    }

    public Category update(Long id, CategoryRequest request) {
        Category categoryToUpdate = categoryFinderService.findById(id);
        categoryToUpdate.setName(request.getName());
        return categoryRepository.save(categoryToUpdate);
    }
}
