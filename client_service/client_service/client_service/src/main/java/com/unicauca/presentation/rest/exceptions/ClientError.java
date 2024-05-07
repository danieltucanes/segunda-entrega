package com.unicauca.presentation.rest.exceptions;

import com.unicauca.domain.service.EnumErrorCodes;

public class ClientError {
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

    public ClientError(EnumErrorCodes code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
