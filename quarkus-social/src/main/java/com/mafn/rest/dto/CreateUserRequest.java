package com.mafn.rest.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class CreateUserRequest {
	
	@NotBlank(message = "Field name cannot be empty")
	private String name;
	@NotNull(message = "Field age cannot be null")
	private Integer age;	
}
