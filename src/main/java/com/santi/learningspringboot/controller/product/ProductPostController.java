package com.santi.learningspringboot.controller.product;

import com.santi.learningspringboot.dto.request.product.ProductRequest;
import com.santi.learningspringboot.dto.response.product.ProductResponse;
import com.santi.learningspringboot.mapper.product.ProductMapper;
import com.santi.learningspringboot.model.product.Product;
import com.santi.learningspringboot.service.product.ProductCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductPostController {
    private final ProductCreatorService productCreatorService;

    public ProductPostController(ProductCreatorService productCreatorService) {
        this.productCreatorService = productCreatorService;
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        Product newProduct = productCreatorService.create(request);
        ProductResponse response = ProductMapper.toResponse(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
