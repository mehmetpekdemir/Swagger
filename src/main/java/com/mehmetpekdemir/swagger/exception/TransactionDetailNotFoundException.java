package com.mehmetpekdemir.swagger.exception;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
public class TransactionDetailNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TransactionDetailNotFoundException(String message) {
		super(message);
	}

}
