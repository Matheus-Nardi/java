package javacore.ZZJcrudJbdc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}
