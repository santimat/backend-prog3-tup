package com.santi.learningspringboot.repository.category;

import com.santi.learningspringboot.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
}
