package com.microservice.product.persistence;

import com.microservice.product.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
