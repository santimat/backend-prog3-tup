package com.santi.learningspringboot.service.product;

import com.santi.learningspringboot.model.product.Product;
import com.santi.learningspringboot.repository.product.JPAProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleterService {
    private final JPAProductRepository productRepository;
    private final ProductFinderService productFinderService;

    public ProductDeleterService(JPAProductRepository productRepository, ProductFinderService productFinderService) {
        this.productRepository = productRepository;
        this.productFinderService = productFinderService;
    }

    public void deleteById(Long id) {
        Product product = productFinderService.findById(id);
        productRepository.delete(product);
    }
}
