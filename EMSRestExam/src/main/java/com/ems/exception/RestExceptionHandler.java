<<<<<<< HEAD
package com.ems.exception;

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
=======
package com.ems.exception;

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
>>>>>>> ca98932d9306c6218e14d6b42efd1c68119703d8
