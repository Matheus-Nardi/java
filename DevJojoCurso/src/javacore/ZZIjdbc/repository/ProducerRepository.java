package javacore.ZZIjdbc.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javacore.ZZIjdbc.conn.ConnectionFactory;
import javacore.ZZIjdbc.model.Producer;

public class ProducerRepository {
	public static void save(Producer producer) {
		String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());

		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
			int rows = stmt.executeUpdate(sql);
			System.out.printf("Inserted producer %s in the database, rows affected %d", producer.getName(), rows);
		} catch (SQLException e) {
			System.out.printf("Error while trying to insert producer %s  , %s", producer.getName(), e);
		}
	}

	public static void deleteBetween(Integer fisrtId, Integer lastId) {
		String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` between %d AND %d);".formatted(fisrtId, lastId);

		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
			int rows = stmt.executeUpdate(sql);
			System.out.printf("Deleted producer in the database, rows affected %d", rows);
		} catch (SQLException e) {
			System.out.printf("Error while trying to delete producer %s", e);
		}
	}

	public static void delete(Integer id) {
		String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = %d);".formatted(id);

		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
			int rows = stmt.executeUpdate(sql);
			System.out.printf("Deleted producer in the database, rows affected %d", rows);
		} catch (SQLException e) {
			System.out.printf("Error while trying to delete producer %s", e);
		}
	}

	public static void update(Producer producer) {

		String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');"
				.formatted(producer.getName(), producer.getId());

		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
			int rows = stmt.executeUpdate(sql);
			System.out.printf("Updated producer in the database, rows affected %d", rows);
		} catch (SQLException e) {
			System.out.printf("Error while trying to delete producer %s", e);
		}

	}

	public static List<Producer> findAll() {
		List<Producer> producers = new ArrayList<Producer>();
		System.out.println("Finding all Producers");
		String sql = "SELECT id , name FROM `anime_store`.`producer`";

		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

				producers.add(producer);
			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}
		return producers;
	}
	
	public static List<Producer> findByName(String name) {
		List<Producer> producers = new ArrayList<Producer>();
		System.out.println("Finding all Producers by name");
		String sql = "SELECT * FROM `anime_store`.`producer` WHERE name LIKE '%%%s%%'".formatted(name);

		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Producer producer = Producer.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.build();

				producers.add(producer);
			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}
		return producers;
	}

}
