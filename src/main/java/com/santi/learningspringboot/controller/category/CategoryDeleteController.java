package com.santi.learningspringboot.controller.category;

import com.santi.learningspringboot.service.category.CategoryDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryDeleteController {
    private final CategoryDeleterService categoryDeleterService;

    public CategoryDeleteController(CategoryDeleterService categoryDeleterService) {
        this.categoryDeleterService = categoryDeleterService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryDeleterService.deleteById(id);
        return ResponseEntity.ok("Category with id " + id + " has been deleted");
    }
}
