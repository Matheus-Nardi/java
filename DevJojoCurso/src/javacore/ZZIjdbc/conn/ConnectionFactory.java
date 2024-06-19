package javacore.ZZIjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConnectionFactory {
	// JDBC : Biblioteca para padrozinar acesso ao bd
	// java.sql : Connection , Statement, Result, DriveManeger
	// Maven ; gerenciador de depedencias e builder de projeto

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/anime_store";
		String username = "root";
		String password = "root";

		return DriverManager.getConnection(url, username, password);

	}

	public static JdbcRowSet getJbdcRowSet() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/anime_store";
		String username = "root";
		String password = "root";

		JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
		jdbcRowSet.setUrl(url);
		jdbcRowSet.setUsername(username);
		jdbcRowSet.setPassword(password);

		return jdbcRowSet;

	}

	public static CachedRowSet getCachedRowSet() throws SQLException {

		return RowSetProvider.newFactory().createCachedRowSet();

	}
}
