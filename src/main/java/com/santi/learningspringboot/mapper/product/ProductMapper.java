package com.santi.learningspringboot.mapper.product;

import com.santi.learningspringboot.dto.request.product.ProductRequest;
import com.santi.learningspringboot.dto.response.product.ProductResponse;
import com.santi.learningspringboot.model.product.Product;

public class ProductMapper {
    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setActive(request.getActive() != null ? request.getActive() : true);
        product.setStock(request.getStock() != null ? request.getStock() : 0);
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(product.getName(), product.getDescription(), product.getPrice(), product.getActive(), product.getStock());
    }
}
