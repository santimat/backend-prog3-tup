package com.santi.learningspringboot.controller.product;

import com.santi.learningspringboot.service.product.ProductDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductDeleteController {
    private final ProductDeleterService productDeleterService;

    public ProductDeleteController(ProductDeleterService productDeleterService) {
        this.productDeleterService = productDeleterService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        productDeleterService.deleteById(id);

        return ResponseEntity.ok("Product with ID " + id + " has been deleted successfully.");
    }
}
