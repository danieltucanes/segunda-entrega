package com.unicauca.presentation.rest.exceptions;

import java.util.List;

public class ClientDomainException extends Exception {
    /**
     * Listado de errores
     */
    public List<ClientError> errors;

    public ClientDomainException(List<ClientError> errors) {
        this.errors = errors;
    }
}
