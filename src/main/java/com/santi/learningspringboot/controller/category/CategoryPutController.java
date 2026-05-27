package com.santi.learningspringboot.controller.category;

import com.santi.learningspringboot.dto.request.category.CategoryRequest;
import com.santi.learningspringboot.dto.response.category.CategoryResponse;
import com.santi.learningspringboot.mapper.category.CategoryMapper;
import com.santi.learningspringboot.service.category.CategoryUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryPutController {
    private final CategoryUpdaterService categoryUpdaterService;

    public CategoryPutController(CategoryUpdaterService categoryUpdaterService) {
        this.categoryUpdaterService = categoryUpdaterService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody CategoryRequest request) {
        CategoryResponse response = CategoryMapper.toResponse(categoryUpdaterService.update(id, request));
        return ResponseEntity.ok(response);
    }
}
