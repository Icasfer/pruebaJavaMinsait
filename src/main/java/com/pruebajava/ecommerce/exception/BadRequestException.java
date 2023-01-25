package com.pruebajava.ecommerce.exception;

public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		super("Bad Request Exception");
	}

}
