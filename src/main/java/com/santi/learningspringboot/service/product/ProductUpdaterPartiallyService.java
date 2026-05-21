package com.santi.learningspringboot.service.product;

import com.santi.learningspringboot.dto.request.product.ProductUpdatable;
import com.santi.learningspringboot.model.product.Product;
import com.santi.learningspringboot.repository.product.JPAProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdaterPartiallyService {
    private final JPAProductRepository productRepository;
    private final ProductFinderService productFinderService;

    public ProductUpdaterPartiallyService(JPAProductRepository productRepository, ProductFinderService productFinderService) {
        this.productRepository = productRepository;
        this.productFinderService = productFinderService;
    }

    public Product update(ProductUpdatable request, Long id) {
        Product foundedProduct = productFinderService.findById(id);
        if (request.getName() != null) foundedProduct.setName(request.getName());
        if (request.getDescription() != null) foundedProduct.setDescription(request.getDescription());
        if (request.getPrice() != null) foundedProduct.setPrice(request.getPrice());
        if (request.getActive() != null) foundedProduct.setActive(request.getActive());
        if (request.getStock() != null) foundedProduct.setStock(request.getStock());
        return productRepository.save(foundedProduct);
    }
}
