package javacore.ZZIjdbc.repository;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
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
				Producer producer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();

				producers.add(producer);
			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}
		return producers;
	}

	public static void showProducerMetaData() {

		System.out.println("Showing Producer MetaData");
		String sql = "SELECT * FROM `anime_store`.`producer`";

		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int columnCount = rsMetaData.getColumnCount();
			System.out.printf("Columns count %d%n", columnCount);
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("Table name %s%n", rsMetaData.getTableName(i));
				System.out.printf("Column name %s%n", rsMetaData.getColumnName(i));
				System.out.printf("Column size %s%n", rsMetaData.getColumnDisplaySize(i));
				System.out.printf("Column type %s%n", rsMetaData.getColumnTypeName(i));
			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}

	}

	public static void showDriverMetaData() {

		System.out.println("Showing Driver MetaData");

		try (Connection conn = ConnectionFactory.getConnection()){
			DatabaseMetaData dbMetaData = conn.getMetaData();
			//CONCUR_UPDATABLE : o resultSet permite atualização no bd
			//CONCUR_READ_ONLY : o resultSet é de apenas leitura
			//TYPE_FORWARD_ONLY : apenas navegação para frente do bd
			if(dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				System.out.println("Supports TYPE_FORWARD_ONLY");
				if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("and supporsts CONCUR_UPDATABLE ");
				}
			}
			//TYPE_SCROLL_INSENSITIVE : navegação bidirecional(para frente e para atras do bd) e as mudanças feitas no bd não são refletidas
			if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
				if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("and supporsts CONCUR_UPDATABLE ");
				}
			}
			
			// TYPE_SCROLL_SENSITIVE : o inverso do insentitive , as mudanças refletem de forma dinamica
			if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				System.out.println("Supports TYPE_SCROLL_SENSITIVE");
				if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("and supporsts CONCUR_UPDATABLE ");
				}
			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}

	}
	
	public static void showTypeScrollWorking() {
		System.out.println("Test type scrool result set");
		String sql = "SELECT * FROM anime_store.producer";

		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql)) {
			
			//Movendo o cursor para a ultima posicao
			System.out.println("Last row :" + rs.last());
			System.out.println("Row number :" + rs.getRow());
			Producer lastProducer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
			System.out.println(lastProducer);
			
			//Movendo o cursor para a primeira posicao
			System.out.println("First row :" + rs.first());
			System.out.println("Row number :" + rs.getRow());
			Producer fisrtProducer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
			System.out.println(fisrtProducer);
			
			//Movendo o cursor para uma posição escolhida
			System.out.println("Chosen row:" + rs.absolute(2));
			System.out.println("Row number :" + rs.getRow());
			Producer chosenProducer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
			System.out.println(chosenProducer);
			
			//Retornando o cursor em uma posicao
			System.out.println("Row relative:" + rs.relative(-1));
			System.out.println("Row number :" + rs.getRow());
			Producer relativeProducer = Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build();
			System.out.println(relativeProducer);
			
			//Verifica se é a ultima e não move o cursor
			System.out.println("Is last ? " + rs.isLast());
			System.out.println("Row number :" + rs.getRow());
			//Verifica se é a primeira e não move o cursor
			System.out.println("Is First ? " + rs.isFirst());
			System.out.println("Row number :" + rs.getRow());
			
			System.out.println("Last row :" + rs.last());
			rs.next();
			System.out.println("--------------");
			rs.afterLast();
			while(rs.previous()) {
				System.out.println(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all producers %s", e);
		}
	}

}
