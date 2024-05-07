package com.microservice.product.exceptions;


import com.microservice.product.service.EnumErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Error de un producto
 * 
 * @author wpantoja, ahurtado
 *
 */
@Data
@Builder
@AllArgsConstructor
public class ProductError {
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

	/*public ProductError(EnumErrorCodes code, String field, String description) {
		this.code = code;
		this.field = field;
		this.description = description;
	}*/
}
