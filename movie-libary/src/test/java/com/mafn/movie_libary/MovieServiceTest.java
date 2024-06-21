package com.mafn.movie_libary;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mafn.movie_libary.domain.models.Movie;
import com.mafn.movie_libary.service.MovieService;

class MovieServiceTest {

	private Movie movieFromCurrentYear;
	private Movie movieNotFromCurrentYear;

	@BeforeEach
	public void setUp() {
		movieFromCurrentYear = Movie.builder().realese_year(LocalDate.now().getYear()).build();
		movieNotFromCurrentYear = Movie.builder().realese_year(2023).build();
	}

	@Test
	@DisplayName("The film shouldn't be from the current year")
	void isFromCurrentYear_ReturnFalse_WhenRealeseYearEqualsCurrentYear() {
		Assertions.assertFalse(MovieService.isFromCurrentYear(movieNotFromCurrentYear));
	}

	@Test
	@DisplayName("The film should be from the current year")
	void isFromCurrentYear_ReturnTrue_WhenRealeseYearEqualsCurrentYear() {
		Assertions.assertTrue(MovieService.isFromCurrentYear(movieFromCurrentYear));
	}

	@Test
	@DisplayName("Should throw NullPointerException when movie is null")
	void isFromCurrentYear_ThorowExecption_WhenMovieIsNull() {
		Assertions.assertThrows(NullPointerException.class, () -> MovieService.isFromCurrentYear(null),
				"Movie can't be null");
	}

	@Test
	@DisplayName("Should return list with only movies from the current year")
	void filterRemovingMoviesNotFromCurrentYear() {
		Movie movie1 = Movie.builder().realese_year(2024).build();
		Movie movie2 = Movie.builder().realese_year(2024).build();
		Movie movie3 = Movie.builder().realese_year(2023).build();
		List<Movie> movies = List.of(movie1, movie2, movie3);
		Assertions.assertEquals(2, MovieService.filterRemovingMoviesNotFromCurrentYear(movies).size());
	}

}
