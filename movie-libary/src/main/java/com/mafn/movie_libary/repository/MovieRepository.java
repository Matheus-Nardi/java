package com.mafn.movie_libary.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mafn.movie_libary.conn.ConnectionFactory;
import com.mafn.movie_libary.domain.models.Genre;
import com.mafn.movie_libary.domain.models.Movie;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class MovieRepository {
	
		public static void save(Movie movie) {
			String sql = "INSERT INTO `movie_libary`.`movies` (`title`, `director`, `realese_year`, `genre`) VALUES ('%s', '%s', '%d', '%d')"
					.formatted(movie.getTitle(), movie.getDirector(), movie.getRealese_year(), movie.getGenre().getId());
			
			try(Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();){
				int rowsAffected = stmt.executeUpdate(sql);
				log.info("Inserted movie '{}' in the database, rows affected '{}'" , movie.getTitle() , rowsAffected);
			}catch(SQLException e) {
				log.error("Error while trying to insert a movie '{}' : {}" , movie.getTitle() ,e);
			}
		}
		
		public static void delete(Integer id) {
			String sql = "DELETE FROM `movie_libary`.`movies` WHERE (`id` = '%d');"
					.formatted(id);
			
			try(Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();){
				int rowsAffected = stmt.executeUpdate(sql);
				log.info("Deleted movie in the database, rows affected '{}'"  , rowsAffected);
			}catch(SQLException e) {
				log.error("Error while trying to delete a movie : {}" ,e);
			}
		}
		
		public static void update(Movie movie) {
			String sql = "UPDATE `movie_libary`.`movies` SET `title` = '%s', `director` = '%s', `realese_year` = '%d', `genre` = '%d' WHERE (`id` = '%d');"
					.formatted(movie.getTitle(), movie.getDirector(), movie.getRealese_year(), movie.getGenre().getId(), movie.getId());
			
			try(Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();){
				int rowsAffected = stmt.executeUpdate(sql);
				log.info("Updated movie  in the database, rows affected '{}'" , rowsAffected);
			}catch(SQLException e) {
				log.error("Error while trying to update a movie : {}" ,e);
			}
		}
		
		public static List<Movie> read(){
			List<Movie> movies = new ArrayList<Movie>();
			String sql = "SELECT * FROM movie_libary.movies; ";
			
			try(Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);){
				
				while(rs.next()) {
					Movie movie = Movie.builder()
					.id(rs.getInt("id"))
					.title(rs.getString("title"))
					.realese_year(rs.getInt("realese_year"))
					.genre(Genre.valueOf(rs.getInt("genre")))
					.build();
					
					movies.add(movie);
				}
			}catch(SQLException e) {
				log.error("Error while reading a movie : {}" ,e);
			}
			
			return movies;
		}
		
}
