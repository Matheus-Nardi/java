package com.mafn.movie_libary.domain.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Movie {
	private long id;
	private String title;
	private String director;
	private Integer release_year;
	private Genre genre;
	
}
