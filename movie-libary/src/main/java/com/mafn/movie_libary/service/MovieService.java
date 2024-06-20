package com.mafn.movie_libary.service;

import java.util.List;
import java.util.Scanner;

import com.mafn.movie_libary.domain.models.Genre;
import com.mafn.movie_libary.domain.models.Movie;
import com.mafn.movie_libary.repository.MovieRepository;

public class MovieService {
	private static final Scanner SCAN = new Scanner(System.in);

	public static void save() {
		System.out.println("TITLE: ");
		String title = SCAN.nextLine();
		System.out.println("DIRECTOR: ");
		String director = SCAN.nextLine();
		System.out.println("REALESE YEAR: ");
		Integer realese_year = Integer.parseInt(SCAN.nextLine());
		System.out.println("GENRE: ");
		Genre.showValues();
		Genre genre = Genre.valueOf(Integer.parseInt(SCAN.nextLine()));
		Movie movieSave = Movie.builder().title(title).director(director).realese_year(realese_year).genre(genre)
				.build();

		MovieRepository.save(movieSave);
	}

	public static void delete() {
		System.out.println("Type de id of the movie that you want to delete: ");
		int idMovieToDelete = Integer.parseInt(SCAN.nextLine());
		if (idMovieToDelete < 0) {
			System.out.println("Enter a valid id!");
			return;
		}
		MovieRepository.delete(idMovieToDelete);
	}

	public static void update() {
		System.out.println("Type de id of the movie that you want to update : ");
		int idMovieToUpdate = Integer.parseInt(SCAN.nextLine());
		Movie movieFromDB = MovieRepository.readById(idMovieToUpdate);
		System.out.println("NEW OR EMPTY TTILE FOR THE SAME:");
		String title = SCAN.nextLine();
		title = title.isEmpty() ? movieFromDB.getTitle() : title;
		System.out.println("NEW OR EMPTY DIRECTOR FOR THE SAME:");
		String director = SCAN.nextLine();
		director = director.isEmpty() ? movieFromDB.getDirector() : director;
		System.out.println("NEW OR EMPTY REALESE YEAR FOR THE SAME:");
		String realese_year = SCAN.nextLine();
		realese_year = realese_year.isEmpty() ? movieFromDB.getRealese_year().toString() : realese_year;

		Movie movieUpdate = Movie.builder().title(title).director(director).realese_year(Integer.parseInt(realese_year))
				.build();

		MovieRepository.save(movieUpdate);
	}

	public static List<Movie> readAll() {
		return MovieRepository.readAll();
	}

	public static List<Movie> readByTitle() {
		System.out.println("Type the title of the movie that you waint to search:");
		String title = SCAN.nextLine();
		return MovieRepository.readByTitle(title);
	}

	public static Movie readById() {
		System.out.println("Type de id of the movie that you want to search : ");
		int idMovieToSearch = Integer.parseInt(SCAN.nextLine());
		return MovieRepository.readById(idMovieToSearch);
	}

}
