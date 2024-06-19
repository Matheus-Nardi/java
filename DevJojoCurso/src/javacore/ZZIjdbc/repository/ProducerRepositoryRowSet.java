package javacore.ZZIjdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import javacore.ZZIjdbc.conn.ConnectionFactory;
import javacore.ZZIjdbc.listener.CustomRowSetListener;
import javacore.ZZIjdbc.model.Producer;

public class ProducerRepositoryRowSet {

	public static List<Producer> findByNameJdbcRowSet(String name) {
		String sql = "SELECT * FROM `anime_store`.`producer` WHERE name LIKE ?";
		List<Producer> producers = new ArrayList<Producer>();

		try (JdbcRowSet jrs = ConnectionFactory.getJbdcRowSet();) {
			jrs.addRowSetListener(new CustomRowSetListener());
			jrs.setCommand(sql);
			jrs.setString(1, "%" + name + "%");
			jrs.execute();

			while (jrs.next()) {
				Producer producer = Producer.builder().id(jrs.getInt("id")).name(jrs.getString("name")).build();

				producers.add(producer);
			}

		} catch (SQLException e) {
			System.out.printf("Error while find '%s' in the database with JbdcRowSet", name);
		}

		return producers;
	}

	public static void updateJdbcRowSet(Producer producer) {
		String sql ="SELECT * FROM `anime_store`.`producer` WHERE (`id` = ?);";

		try (JdbcRowSet jrs = ConnectionFactory.getJbdcRowSet();) {
			jrs.addRowSetListener(new CustomRowSetListener());
			jrs.setCommand(sql);
			jrs.setInt(1, producer.getId());
			jrs.execute();
			
			if(!jrs.next())
				return;
			
			jrs.updateString("name", producer.getName());
			jrs.updateRow(); // Confirmando update

		} catch (SQLException e) {
			System.out.printf("Error while update '%s' in the database with JbdcRowSet", producer.getName());
		}

	}
	public static void updateCachedRowSet(Producer producer) {
		String sql ="SELECT * FROM `producer` WHERE (`id` = ?);";
		
		try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
				Connection connection = ConnectionFactory.getConnection();) {
//			crs.addRowSetListener(new CustomRowSetListener());
			connection.setAutoCommit(false);
			crs.setCommand(sql);
			crs.setInt(1, producer.getId());
			crs.execute(connection);
			
			if(!crs.next())
				return;
			
			crs.updateString("name", producer.getName());
			crs.updateRow(); // Confirmando update
			crs.acceptChanges();
			
		} catch (SQLException e) {
			System.out.printf("Error while update '%s' in the database with JbdcRowSet", producer.getName());
		}
		
	}

}
