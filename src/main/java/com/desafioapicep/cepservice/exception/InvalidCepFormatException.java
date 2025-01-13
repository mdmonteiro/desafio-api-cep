package com.desafioapicep.cepservice.exception;

public class InvalidCepFormatException extends RuntimeException {

	private static final long serialVersionUID = -6131580921953283764L;

	public InvalidCepFormatException(String message) {
		super(message);
	}
}
