package com.microservice.product.service;

import com.microservice.product.entities.Category;
import com.microservice.product.entities.Product;
import com.microservice.product.exceptions.ProductDomainException;
import com.microservice.product.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IProductService
{
    public List<Product> findAll();

    public Product findById(Long id) throws ResourceNotFoundException;

    public Product create(Product product) throws ProductDomainException;

    public Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException;

    public void deleteById(Long id) throws ResourceNotFoundException;
}
