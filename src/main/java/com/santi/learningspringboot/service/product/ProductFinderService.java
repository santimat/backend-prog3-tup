package com.santi.learningspringboot.service.product;

import com.santi.learningspringboot.exception.product.ProductNotFoundException;
import com.santi.learningspringboot.model.product.Product;
import com.santi.learningspringboot.repository.product.JPAProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductFinderService {
    private final JPAProductRepository productRepository;

    public ProductFinderService(JPAProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
