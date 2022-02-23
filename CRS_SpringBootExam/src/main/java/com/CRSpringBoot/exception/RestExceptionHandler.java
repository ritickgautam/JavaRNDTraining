package com.CRSpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NotFoundException e) {

		ErrorResponse error = new ErrorResponse(HttpStatus.FOUND.value(), e.getMessage(), System.currentTimeMillis());
		System.out.println("Inside Rest Exception");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
