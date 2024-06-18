package com.mafn.movie_libary.service;

import java.util.List;
import java.util.Scanner;

import com.mafn.movie_libary.domain.models.Movie;
import com.mafn.movie_libary.repository.MovieRepository;

public class MovieService {
	Scanner scan = new Scanner(System.in);
	public static void save(Movie movie) {
		MovieRepository.save(movie);
	}

	public static void delete(Integer id) {
		if(id < 0 ) {
			System.out.println("Enter a valid id!");
			return;
		}
		MovieRepository.delete(id);
	}

	public static void update(Movie movie ) {
		MovieRepository.update(movie);
	}

	public static List<Movie> read() {
		return MovieRepository.read();
	}

}
