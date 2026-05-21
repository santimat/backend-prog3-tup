package com.santi.learningspringboot.controller.product;

import com.santi.learningspringboot.dto.response.product.ProductResponse;
import com.santi.learningspringboot.mapper.product.ProductMapper;
import com.santi.learningspringboot.model.product.Product;
import com.santi.learningspringboot.service.product.ProductFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductGetController {
    private final ProductFinderService productFinderService;

    public ProductGetController(ProductFinderService productFinderService) {
        this.productFinderService = productFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product foundedProduct = productFinderService.findById(id);
        ProductResponse response = ProductMapper.toResponse(foundedProduct);
        return ResponseEntity.ok(response);
    }
}
