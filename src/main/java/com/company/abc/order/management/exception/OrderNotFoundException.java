package com.company.abc.order.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {
	String message;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
