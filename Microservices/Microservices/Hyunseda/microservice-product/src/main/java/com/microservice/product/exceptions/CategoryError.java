package com.microservice.product.exceptions;

import com.microservice.product.service.EnumErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class CategoryError {
    public final EnumErrorCodes code;
    /**
     * Campo del error
     */
    public final String field;
    /**
     * Descripción del error
     */
    public final String description;

}
