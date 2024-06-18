package com.mafn.movie_libary.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mafn.movie_libary.conn.ConnectionFactory;
import com.mafn.movie_libary.domain.models.Genre;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class GenreRepository {
	public static void save(Genre genre) {
		String sql = "INSERT INTO `movie_libary`.`genres` (`name`) VALUES ('%s')"
				.formatted(genre.getLabel());
		
		try(Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement();){
			int rowsAffected = stmt.executeUpdate(sql);
			log.info("Inserted genre '{}' in the database, rows affected '{}'" , genre.getLabel() , rowsAffected);
		}catch(SQLException e) {
			log.error("Error while trying to insert a genre '{}' : {}" , genre.getLabel() ,e);
		}
	}
}
