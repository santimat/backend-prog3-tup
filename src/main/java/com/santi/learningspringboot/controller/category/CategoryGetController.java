package com.santi.learningspringboot.controller.category;

import com.santi.learningspringboot.dto.response.category.CategoryResponse;
import com.santi.learningspringboot.mapper.category.CategoryMapper;
import com.santi.learningspringboot.service.category.CategoryFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryGetController {
    private final CategoryFinderService categoryFinderService;

    public CategoryGetController(CategoryFinderService categoryFinderService) {
        this.categoryFinderService = categoryFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        CategoryResponse response = CategoryMapper.toResponse(categoryFinderService.findById(id));
        return ResponseEntity.ok(response);
    }
}
