package com.microservice.order.exceptions;

import java.util.List;

public class OrderDomainException extends Exception{
    /**
     * Listado de errores
     */
    public final List<OrderError> errors;

    public OrderDomainException(List<OrderError> errors) {
        this.errors = errors;
    }
}
