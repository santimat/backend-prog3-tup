package com.santi.learningspringboot.controller.product;

import com.santi.learningspringboot.dto.request.product.ProductUpdatable;
import com.santi.learningspringboot.dto.response.product.ProductResponse;
import com.santi.learningspringboot.mapper.product.ProductMapper;
import com.santi.learningspringboot.model.product.Product;
import com.santi.learningspringboot.service.product.ProductUpdaterPartiallyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductPatchController {
    private final ProductUpdaterPartiallyService productUpdaterPartiallyService;

    public ProductPatchController(ProductUpdaterPartiallyService productUpdaterPartiallyService) {
        this.productUpdaterPartiallyService = productUpdaterPartiallyService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> updatePartially(@RequestBody ProductUpdatable request,
                                                           @PathVariable Long id) {
        Product updatedProduct = productUpdaterPartiallyService.update(request, id);
        ProductResponse response = ProductMapper.toResponse(updatedProduct);
        return ResponseEntity.ok(response);
    }
}
