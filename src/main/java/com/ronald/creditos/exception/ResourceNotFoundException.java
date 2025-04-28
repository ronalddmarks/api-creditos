package com.ronald.creditos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 593730764271740180L;

	public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
