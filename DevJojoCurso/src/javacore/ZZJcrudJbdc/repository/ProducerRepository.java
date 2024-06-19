package javacore.ZZJcrudJbdc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javacore.ZZJcrudJbdc.conn.ConnectionFactory;
import javacore.ZZJcrudJbdc.domain.Producer;

public class ProducerRepository {
	public static List<Producer> findByName(String name) {
		List<Producer> producers = new ArrayList<Producer>();
		System.out.printf("Finding all Producers by name %s%n", name);

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementFindByName(conn, name);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

				producers.add(producer);
			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}
		return producers;
	}

	private static PreparedStatement createdPreparedStatementFindByName(Connection connection, String name)
			throws SQLException {
		String sql = "SELECT * FROM `anime_store`.`producer` WHERE name LIKE ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		return ps;
	}

	public static Optional<Producer> findById(Integer id) {

		System.out.printf("Finding all Producers by id %s%n", id);

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementFindById(conn, id);
				ResultSet rs = ps.executeQuery();) {
			if (!rs.next())
				Optional.empty();

			return Optional.of(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}

		return Optional.empty();

	}

	private static PreparedStatement createdPreparedStatementFindById(Connection connection, Integer id)
			throws SQLException {
		String sql = "SELECT * FROM `anime_store`.`producer` WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;
	}

	public static void delete(Integer id) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementDelete(conn, id)) {
			ps.execute();
			System.out.printf("Deleted producer '%d' in the database", id);
		} catch (SQLException e) {
			System.out.printf("Error while trying to delete producer %s", e);
		}
	}

	private static PreparedStatement createdPreparedStatementDelete(Connection connection, Integer id)
			throws SQLException {
		String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;
	}

	public static void save(Producer producer) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementSave(conn, producer)) {
			ps.execute();
			System.out.printf("Saved producer '%s' in the database", producer.getName());
		} catch (SQLException e) {
			System.out.printf("Error while trying to save producer %s", e);
		}
	}

	private static PreparedStatement createdPreparedStatementSave(Connection connection, Producer producer)
			throws SQLException {
		String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, producer.getName());
		return ps;
	}

	public static void update(Producer producer) {

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementUpdate(conn, producer);) {
			ps.execute();
			System.out.printf("Updated producer %s in the database%n" ,producer.getName());
		} catch (SQLException e) {
			System.out.printf("Error while trying to update producer %s", e);
		}

	}

	private static PreparedStatement createdPreparedStatementUpdate(Connection connection, Producer producer)
			throws SQLException {
		String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, producer.getName());
		ps.setInt(2, producer.getId());
		return ps;
	}

}
