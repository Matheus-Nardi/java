package com.mafn.rest.dto;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;

public class ResponseError {
	private String message;
	private Collection<FieldError> invalidInputs;

	private ResponseError(String message, Collection<FieldError> invalidInputs) {
		super();
		this.message = message;
		this.invalidInputs = invalidInputs;
	}

	public static <T> ResponseError createFromValidation(Set<ConstraintViolation<T>> violations) {
			List<FieldError> invalidInputs = violations.stream()
					.map(cv -> new FieldError(cv.getPropertyPath().toString() , cv.getMessage()))
					.collect(Collectors.toList());
			String messsage = "Validation Input";
			return new ResponseError(messsage, invalidInputs);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<FieldError> getInvalidInputs() {
		return invalidInputs;
	}

	public void setInvalidInputs(Collection<FieldError> invalidInputs) {
		this.invalidInputs = invalidInputs;
	}

}
