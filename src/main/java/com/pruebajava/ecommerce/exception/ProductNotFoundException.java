package com.pruebajava.ecommerce.exception;

import com.pruebajava.ecommerce.model.RequestPrice;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(RequestPrice reqPrice) {
		super("The product with id " + reqPrice.getProductId() + " and brandId " + reqPrice.getBrandId() 
		+ " is not found for this date " + reqPrice.getDateApplication());
	}

	
}
