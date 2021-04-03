package com.user.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNameAlreadyExistsException.class)
	public ErrorResponse handleUserErros(UserNameAlreadyExistsException userNameAlreadyExistsException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage(userNameAlreadyExistsException.getMessage());
		return errorResponse;
	}

	@ExceptionHandler(UserNotExistsException.class)
	public ErrorResponse handleInvalidUserErros(UserNotExistsException userNotExistsException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage(userNotExistsException.getMessage());
		return errorResponse;
	}
}
