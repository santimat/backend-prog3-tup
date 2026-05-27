package com.santi.learningspringboot.mapper.category;

import com.santi.learningspringboot.dto.request.category.CategoryRequest;
import com.santi.learningspringboot.dto.response.category.CategoryResponse;
import com.santi.learningspringboot.model.category.Category;

public class CategoryMapper {
    public static Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}
