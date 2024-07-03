package com.mafn.rest.dto;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.core.Response;
import lombok.Data;

@Data
public class ResponseError {
	public static final int UNPROCESSABLE_ENTITY_STATUS = 422;
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

	public Response withStatusCode(int code) {
		return Response.status(code).entity(this).build();
	}

}
