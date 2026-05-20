package com.santi.learningspringboot.service.product;

import com.santi.learningspringboot.dto.request.product.ProductRequest;
import com.santi.learningspringboot.mapper.product.ProductMapper;
import com.santi.learningspringboot.model.product.Product;
import com.santi.learningspringboot.repository.product.JPAProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreatorService {
    private final JPAProductRepository productRepository;

    public ProductCreatorService(JPAProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(ProductRequest request) {
        Product newProduct = ProductMapper.toEntity(request);
        return productRepository.save(newProduct);
    }
}
