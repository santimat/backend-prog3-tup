package com.santi.learningspringboot.repository.product;

import com.santi.learningspringboot.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
