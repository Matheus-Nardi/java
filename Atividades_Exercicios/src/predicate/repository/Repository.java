package predicate.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import predicate.model.Movie;

public class Repository {
	private static List<Movie> movies = new ArrayList<Movie>(
			Arrays.asList(
					new Movie("The grandfather",175, 1972),
					new Movie("Poor things",100, 2023),
					new Movie("One day",90, 2011)));
	
	
	public static List<Movie> getMovies() {
		return movies;
	}
}
