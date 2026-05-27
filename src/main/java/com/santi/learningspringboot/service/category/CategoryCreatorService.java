package com.santi.learningspringboot.service.category;

import com.santi.learningspringboot.dto.request.category.CategoryRequest;
import com.santi.learningspringboot.mapper.category.CategoryMapper;
import com.santi.learningspringboot.model.category.Category;
import com.santi.learningspringboot.repository.category.JPACategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryCreatorService {
    private final JPACategoryRepository categoryRepository;

    public CategoryCreatorService(JPACategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(CategoryRequest request) {
        Category newCategory = CategoryMapper.toEntity(request);
        return categoryRepository.save(newCategory);
    }
}
