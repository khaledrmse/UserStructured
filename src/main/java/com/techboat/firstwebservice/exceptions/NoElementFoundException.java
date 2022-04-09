package com.techboat.firstwebservice.exceptions;

import org.springframework.http.HttpStatus;

public class NoElementFoundException extends ApiBaseException {

	public NoElementFoundException(String message) {
		super(message);

	}

	@Override
	public HttpStatus getStatusCode() {

		return HttpStatus.NOT_FOUND;
	}

}
