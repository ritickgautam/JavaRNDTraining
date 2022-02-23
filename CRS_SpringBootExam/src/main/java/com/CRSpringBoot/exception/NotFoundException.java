package com.CRSpringBoot.exception;

public class NotFoundException extends RuntimeException{


	public NotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
