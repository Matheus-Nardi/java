package javacore.ZZIjdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javacore.ZZIjdbc.conn.ConnectionFactory;
import javacore.ZZIjdbc.model.Producer;

public class ProducerRepository {
	public static void save(Producer producer) {
		String sql =  "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
		
		try(Connection conn =  ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()){
			int rows = stmt.executeUpdate(sql);
			if(rows > 1)
				System.out.println(rows + " linhas foram afetadas");
			else
				System.out.println(rows + " linha foi afetada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
