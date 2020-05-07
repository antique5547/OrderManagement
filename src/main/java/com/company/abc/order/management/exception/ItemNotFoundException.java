package com.company.abc.order.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
	String message;
	public ItemNotFoundException(String message) {
		super(message);
	}
}
