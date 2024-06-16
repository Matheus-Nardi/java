package com.mafn.movie_libary;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mafn.movie_libary.conn.ConnectionFactory;
import com.mafn.movie_libary.domain.models.Genre;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class App 
{
    public static void main( String[] args )
    {
    		for (Genre g : Genre.values()) {
				insertGenre(g);
			}
    }

	private static void insertGenre(Genre genre) {
		String sql = "INSERT INTO `movie_libary`.`genres` (`name`) VALUES ('%s')".formatted(genre.getLabel());
    	
    	try(Connection conn = ConnectionFactory.getConnection();
    		Statement stmt = conn.createStatement();){
    		int rows = stmt.executeUpdate(sql);
    		log.info("Inserido '{}' no banco de dados , linhas afetadas '{}'" , genre.getLabel() ,rows);
    	}catch(SQLException e) {
    		log.info("Erro ao inserir dados na tabela 'genre'" );
    	}
	}
}
