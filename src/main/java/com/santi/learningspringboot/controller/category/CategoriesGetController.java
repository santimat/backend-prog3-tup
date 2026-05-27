package com.santi.learningspringboot.controller.category;


import com.santi.learningspringboot.dto.response.category.CategoryResponse;
import com.santi.learningspringboot.mapper.category.CategoryMapper;
import com.santi.learningspringboot.model.category.Category;
import com.santi.learningspringboot.service.category.CategorySearcherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/categories")
public class CategoriesGetController {
    private final CategorySearcherService categorySearcherService;

    public CategoriesGetController(CategorySearcherService categorySearcherService) {
        this.categorySearcherService = categorySearcherService;
    }

    @GetMapping()
    public ResponseEntity<Page<CategoryResponse>> getAll(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categories = categorySearcherService.getAll(pageable);
        return ResponseEntity.ok(categories.map(CategoryMapper::toResponse));
    }
}
