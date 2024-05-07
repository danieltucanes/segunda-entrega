package com.microservice.product.service;

import com.microservice.product.entities.Category;
import com.microservice.product.entities.Product;
import com.microservice.product.exceptions.*;
import com.microservice.product.persistence.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CategoryImplService implements ICategoryService {
    //inyectando

    @Autowired
    private CategoryRepository  CategoryRepository;
    @Override
    public List<Category> findAll() {
        return (List<Category>) CategoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) throws ResourceNotFoundException {
        Category cate = CategoryRepository.findById(id).orElse(null);
        if (cate == null) {
            throw new ResourceNotFoundException();

        }
        return cate;
    }
    @Transactional
    @Override
    public Category create(Category category) throws CategoryDomainException {
        List<CategoryError> errors = validateDomain(category);

        if (!errors.isEmpty()) {
            throw new CategoryDomainException(errors);
        }

        return CategoryRepository.save(category);
    }
    @Transactional
    @Override
    public Category update(Long id, Category category) throws CategoryDomainException, ResourceNotFoundException {
        Category cate = this.findById(id);
        if (cate == null) {
            throw new ResourceNotFoundException();
        }

        List<CategoryError> errors = validateDomain(cate);

        if (!errors.isEmpty()) {
            throw new CategoryDomainException(errors);
        }

       // cate.setName(cate.getName());

        cate.setName(category.getName());

        return CategoryRepository.save(cate);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        Category cate = this.findById(id);
        if (cate == null) {
            throw new ResourceNotFoundException();
        }
        CategoryRepository.deleteById(id);
    }
    @Override
    public Category findByName(String name) {
        return CategoryRepository.findByName(name);
    }


    /**
     * Aplica validaciones o reglas del dominio para un producto. Antes de ser
     * agregado o modificado.
     *
     * @param product producto a validad
     * @return lista de errores de validación
     */

    private List<CategoryError> validateDomain(Category category) {
        List<CategoryError> errors = new ArrayList<>();

        if (category.getName() == null || category.getName().isBlank()) {
            errors.add(new CategoryError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre de la categoria es obligatorio"));
        }

        return errors;

    }
}
