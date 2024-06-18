package com.mafn.movie_libary.domain.models;

import java.util.Scanner;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Movie {
	private long id;
	private String title;
	private String director;
	private Integer realese_year;
	private Genre genre;
	
	public static Movie createMovie() {
		Scanner scan = new Scanner(System.in);
		System.out.println("TITLE: ");
		String title = scan.nextLine();
		System.out.println("DIRECTOR: ");
		String director = scan.nextLine();
		System.out.println("REALESE YEAR: ");
		Integer realese_year = Integer.parseInt(scan.nextLine());
		System.out.println("GENRE: ");
		Genre.showValues();
		Genre genre = Genre.valueOf(Integer.parseInt(scan.nextLine()));
		
		return Movie.builder()
		.title(title)
		.director(director)
		.realese_year(realese_year)
		.genre(genre)
		.build();
		
	}
}
