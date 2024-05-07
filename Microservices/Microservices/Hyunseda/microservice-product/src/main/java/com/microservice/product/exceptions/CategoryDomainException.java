package com.microservice.product.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


public class CategoryDomainException extends Exception{
    /**
     * Listado de errores
     */
    public final List<CategoryError> errors;

    public CategoryDomainException(List<CategoryError> errors) {
        this.errors = errors;
    }
}
