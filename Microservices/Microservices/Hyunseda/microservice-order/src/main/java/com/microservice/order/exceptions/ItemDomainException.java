package com.microservice.order.exceptions;

import java.util.List;

public class ItemDomainException extends Exception {
    /**
     * Listado de errores
     */
    public final List<ItemError> errors;

    public ItemDomainException(List<ItemError> errors) {
        this.errors = errors;
    }
}

