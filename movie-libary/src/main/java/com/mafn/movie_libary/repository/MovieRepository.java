package com.mafn.movie_libary.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mafn.movie_libary.conn.ConnectionFactory;
import com.mafn.movie_libary.domain.models.Genre;
import com.mafn.movie_libary.domain.models.Movie;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MovieRepository {

	public static void save(Movie movie) {

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementSave(conn, movie);) {
			ps.execute();
			log.info("Inserted movie '{}' in the database", movie.getTitle());
		} catch (SQLException e) {
			log.error("Error while trying to insert a movie '{}' : {}", movie.getTitle(), e);
		}
	}

	private static PreparedStatement createPreparedStatementSave(Connection conn, Movie movie) throws SQLException {
		String sql = "INSERT INTO `movie_libary`.`movies` (`title`, `director`, `realese_year`, `genre`) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, movie.getTitle());
		ps.setString(2, movie.getDirector());
		ps.setInt(3, movie.getRealese_year());
		ps.setInt(4, movie.getGenre().getId());
		return ps;
	}

	public static void delete(Integer id) {

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementDelete(conn, id);) {
			ps.execute();
			log.info("Deleted movie '{}' in the database", id);
		} catch (SQLException e) {
			log.error("Error while trying to delete a movie : {}", e);
		}
	}

	private static PreparedStatement createPreparedStatementDelete(Connection conn, Integer id) throws SQLException {
		String sql = "DELETE FROM `movie_libary`.`movies` WHERE (`id` =  ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;

	}

	public static void update(Movie movie) {

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementUpdate(conn, movie)) {
			log.info("Updated movie '{}' in the database", movie.getTitle());
		} catch (SQLException e) {
			log.error("Error while trying to update a movie : {}", e);
		}
	}

	private static PreparedStatement createPreparedStatementUpdate(Connection conn, Movie movie) throws SQLException {
		String sql = "UPDATE `movie_libary`.`movies` SET `title` = ?, `director` = ?, `realese_year` = ?, `genre` = ? WHERE (`id` = ?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, movie.getTitle());
		ps.setString(2, movie.getDirector());
		ps.setInt(3, movie.getRealese_year());
		ps.setInt(4, movie.getGenre().getId());
		ps.setLong(5, movie.getId());
		return ps;

	}

	public static List<Movie> readAll() {
		List<Movie> movies = new ArrayList<Movie>();

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementRead(conn);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Movie movie = Movie.builder().id(rs.getInt("id")).title(rs.getString("title"))
						.realese_year(rs.getInt("realese_year")).genre(Genre.valueOf(rs.getInt("genre"))).build();

				movies.add(movie);
			}
		} catch (SQLException e) {
			log.error("Error while reading a movie : {}", e);
		}

		return movies;
	}

	private static PreparedStatement createPreparedStatementRead(Connection conn) throws SQLException {
		String sql = "SELECT * FROM movie_libary.movies; ";
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps;

	}

	public static List<Movie> readByTitle(String title) {
		List<Movie> movies = new ArrayList<Movie>();

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementRead(conn, title);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Movie movie = Movie.builder().id(rs.getInt("id")).title(rs.getString("title"))
						.realese_year(rs.getInt("realese_year")).genre(Genre.valueOf(rs.getInt("genre"))).build();

				movies.add(movie);
			}
		} catch (SQLException e) {
			log.error("Error while reading a movie : {}", e);
		}

		return movies;
	}

	private static PreparedStatement createPreparedStatementRead(Connection conn, String title) throws SQLException {
		String sql = "SELECT * FROM movie_libary.movies WHERE movies.title LIKE ?; ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, title);
		return ps;

	}

	public static Movie readById(Integer id) {
		Movie movieFindById = null;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createPreparedStatementRead(conn, id);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				movieFindById = Movie.builder().id(rs.getInt("id")).title(rs.getString("title"))
						.realese_year(rs.getInt("realese_year")).genre(Genre.valueOf(rs.getInt("genre"))).build();

				
			}
		} catch (SQLException e) {
			log.error("Error while reading a movie : {}", e);
		}

		return movieFindById;
	}

	private static PreparedStatement createPreparedStatementRead(Connection conn, Integer id) throws SQLException {
		String sql = "SELECT * FROM movie_libary.movies WHERE movies.id LIKE ?; ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;

	}

}
