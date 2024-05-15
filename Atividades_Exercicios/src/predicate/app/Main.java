package predicate.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import predicate.interfaces.MoviePredicate;
import predicate.model.Movie;
import predicate.repository.Repository;

public class Main {

	public static void main(String[] args) {
		List<Movie> movies = Repository.getMovies();
		
		//Predicate e interface anonima
		showMovie(filterMovie(movies, new MoviePredicate() {
			@Override
			public boolean test(Movie movie) {
				return movie.getLunchYear() > 2010 ;
			}
		}));
		
		//Predicate e lambda
		showMovie(filterMovie(movies, m -> m.getDuration() >= 100));
	}
	
	public static List<Movie> filterByDuration(List<Movie> movies, Integer duration){
		List<Movie> moviesByDuration = new ArrayList<Movie>();
		for (Movie movie : movies) {
			if(movie.getDuration() < duration) {
				moviesByDuration.add(movie);
			}
		}
		return moviesByDuration;
	}
	public static List<Movie> filterMovie(List<Movie> movies, MoviePredicate predicate){
		List<Movie> filterMovie = new ArrayList<Movie>();
		for (Movie movie : movies) {
			if(predicate.test(movie)) {
				filterMovie.add(movie);
			}
		}
		Collections.sort(filterMovie);
		return filterMovie;
	}
	
	
	
	public static void showMovie(List<Movie> filmes) {
		for (Movie movie : filmes) {
			System.out.println(movie.getTitle());
			System.out.println(movie.getDuration());
			System.out.println(movie.getLunchYear());
			System.out.println("-----------");
		}
	}

}
