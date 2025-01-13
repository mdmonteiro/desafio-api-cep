package com.desafioapicep.cepservice.exception;

public class ExternalApiException extends RuntimeException {

	private static final long serialVersionUID = 1067934395139411537L;

	public ExternalApiException(String message) {
        super(message);
    }
}
