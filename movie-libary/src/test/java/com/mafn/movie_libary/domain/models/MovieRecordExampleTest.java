package com.mafn.movie_libary.domain.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieRecordExampleTest {

	private MovieRecordExample movie1;
	private MovieRecordExample movie2;

	@BeforeEach
	void setUp() {
		movie1 = new MovieRecordExample("Poor things", 2023);
		movie2 = new MovieRecordExample("Poor things", 2023);
	}

	@Test
	void acessors_ReturnDate_WhenInitialized() {
		Assertions.assertEquals("Poor things", movie1.title());
		Assertions.assertEquals(2023, movie1.release_year());
	}

	@Test
	void equals_ReturnTrue_WhenObjectsAreEquals() {
		Assertions.assertTrue(movie1.equals(movie2));
	}

}
