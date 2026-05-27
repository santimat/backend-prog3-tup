package com.santi.learningspringboot.service.category;

import com.santi.learningspringboot.model.category.Category;
import com.santi.learningspringboot.repository.category.JPACategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategorySearcherService {
    private final JPACategoryRepository categoryRepository;

    public CategorySearcherService(JPACategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
