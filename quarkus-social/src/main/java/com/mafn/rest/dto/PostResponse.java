package com.mafn.rest.dto;

import java.time.format.DateTimeFormatter;

import com.mafn.domain.model.Post;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class PostResponse {
	private String text;
	private String dateTime;
	
	
	public static PostResponse fromEntity(Post post) {
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss");
		 return PostResponse.builder()
				 .text(post.getText())
				 .dateTime(post.getDateTime().format(formater))
				 .build();
	}
}
