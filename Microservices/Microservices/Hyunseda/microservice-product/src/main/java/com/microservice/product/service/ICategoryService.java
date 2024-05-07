package com.microservice.product.service;

import com.microservice.product.entities.Category;
import com.microservice.product.exceptions.CategoryDomainException;
import com.microservice.product.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service

public interface ICategoryService
{
    public List<Category> findAll();

    public Category findById(Long id) throws ResourceNotFoundException;

    public Category create(Category category) throws CategoryDomainException;

    public Category update(Long id, Category category) throws CategoryDomainException, ResourceNotFoundException;

    public void deleteById(Long id) throws ResourceNotFoundException;

    public Category findByName(String name);
}
