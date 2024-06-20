package javacore.ZZJcrudJbdc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javacore.ZZJcrudJbdc.conn.ConnectionFactory;
import javacore.ZZJcrudJbdc.domain.Anime;
import javacore.ZZJcrudJbdc.domain.Producer;

public class AnimeRepository {
	public static List<Anime> findByName(String name) {
		List<Anime> animes = new ArrayList<>();
		System.out.printf("Finding all Animes by name %s%n", name);

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementFindByName(conn, name);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Producer producer = Producer.builder().id(rs.getInt("producer_id")).name(rs.getString("producer_name")).build();

				Anime anime = Anime.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.episodes(rs.getInt("episodes"))
						.producer(producer).build();

				animes.add(anime);

			}

		} catch (SQLException e) {
			System.out.printf("Error while to find all animes %s", e);
		}
		return animes;
	}

	private static PreparedStatement createdPreparedStatementFindByName(Connection connection, String name)
			throws SQLException {
		String sql = """
				SELECT a.id, a.name , a.episodes , a.producer_id , p.name as 'producer_name' FROM anime a
				INNER JOIN producer p
				on a.producer_id = p.id
				WHERE a.name LIKE ?;
				""";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		return ps;
	}

	public static Optional<Anime> findById(Integer id) {

		System.out.printf("Finding Anime by id %s%n", id);

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementFindById(conn, id);
				ResultSet rs = ps.executeQuery();) {
			if (!rs.next())
				Optional.empty();

			Producer producer = Producer.builder().id(rs.getInt("producer_id")).name(rs.getString("name")).build();

			Anime anime = Anime.builder().id(rs.getInt("id")).name(rs.getString("anime_name"))
					.episodes(rs.getInt("episodes")).producer(producer).build();

			return Optional.of(anime);

		} catch (SQLException e) {
			System.out.printf("Error while to find the anime %s", e);
		}

		return Optional.empty();

	}

	private static PreparedStatement createdPreparedStatementFindById(Connection connection, Integer id)
			throws SQLException {
		String sql = """
				SELECT a.id, a.name 'anime_name', a.episodes , a.producer_id , p.name FROM anime a
				INNER JOIN producer p
				on a.producer_id = p.id
				WHERE a.id = ?;
				""";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;
	}

	public static void delete(Integer id) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementDelete(conn, id)) {
			ps.execute();
			System.out.printf("Deleted anime '%d' in the database", id);
		} catch (SQLException e) {
			System.out.printf("Error while trying to anime producer %s", e);
		}
	}

	private static PreparedStatement createdPreparedStatementDelete(Connection connection, Integer id)
			throws SQLException {
		String sql = "DELETE FROM `anime_store`.`anime` WHERE (`id` = ?);";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		return ps;
	}

	public static void save(Anime anime) {
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementSave(conn, anime)) {
			ps.execute();
			System.out.printf("Saved anime '%s' in the database", anime.getName());
		} catch (SQLException e) {
			System.out.printf("Error while trying to save anime %s", e);
		}
	}

	private static PreparedStatement createdPreparedStatementSave(Connection connection, Anime anime)
			throws SQLException {
		String sql = "INSERT INTO `anime_store`.`anime` (`name`, `episodes`, `producer_id`) VALUES (?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, anime.getName());
		ps.setInt(2, anime.getEpisodes());
		ps.setInt(3, anime.getProducer().getId());
		return ps;
	}

	public static void update(Anime anime) {

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement ps = createdPreparedStatementUpdate(conn, anime);) {
			ps.execute();
			System.out.printf("Updated anime %s in the database%n", anime.getName());
		} catch (SQLException e) {
			System.out.printf("Error while trying to update anime %s", e);
		}

	}

	private static PreparedStatement createdPreparedStatementUpdate(Connection connection, Anime anime)
			throws SQLException {
		String sql = "UPDATE `anime_store`.`anime` SET `name` = ?, `episodes` = ? WHERE (`id` = ?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, anime.getName());
		ps.setInt(2, anime.getEpisodes());
		ps.setInt(3, anime.getId());
		return ps;
	}

}
