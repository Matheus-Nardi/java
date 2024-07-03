package com.mafn.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePostRequest {

	@NotBlank(message = "Field text cannot be empty")
	private String text;
}
