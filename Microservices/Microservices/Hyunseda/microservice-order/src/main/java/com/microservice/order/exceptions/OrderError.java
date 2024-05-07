package com.microservice.order.exceptions;


import com.microservice.order.service.EnumErrorCodes;

public class OrderError {
    /**
     * Codigo del error
     */
    public final EnumErrorCodes code;
    /**
     * Campo del error
     */
    public final String field;
    /**
     * Descripción del error
     */
    public final String description;

    public OrderError(EnumErrorCodes code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
