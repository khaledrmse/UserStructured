package com.techboat.firstwebservice.exceptions;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ApiBaseException.class)
	public ResponseEntity<ErrorDetails> handleApiExceptions(ApiBaseException ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, ex.getStatusCode());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ValidExceptions validExceptions = new ValidExceptions();
		validExceptions.setUri(request.getContextPath());
		List<FieldError> fieldErrors = ex.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			validExceptions.addError(fieldError.getDefaultMessage());
		}

		return new ResponseEntity<>(validExceptions, HttpStatus.BAD_REQUEST);
	}
}
