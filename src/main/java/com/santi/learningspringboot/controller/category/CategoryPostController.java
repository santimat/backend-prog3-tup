package com.santi.learningspringboot.controller.category;

import com.santi.learningspringboot.dto.request.category.CategoryRequest;
import com.santi.learningspringboot.dto.response.category.CategoryResponse;
import com.santi.learningspringboot.mapper.category.CategoryMapper;
import com.santi.learningspringboot.service.category.CategoryCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryPostController {
    private final CategoryCreatorService categoryCreatorService;

    public CategoryPostController(CategoryCreatorService categoryCreatorService) {
        this.categoryCreatorService = categoryCreatorService;
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
        CategoryResponse response = CategoryMapper.toResponse(categoryCreatorService.create(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
