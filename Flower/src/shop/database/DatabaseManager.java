package shop.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import shop.flower.config.ConfigMangaer;

public class DatabaseManager {

	public static Connection getConnection() throws SQLException {
	
		
		ConfigMangaer cm = ConfigMangaer.getInstance();
		Properties p = cm.getProperties();
		
		String username = p.getProperty("database.username");
		String password = p.getProperty("database.password");
		String jdbcUrl = p.getProperty("database.jdbcUrl");
		String jdbcDriver = p.getProperty("database.jdbcDriver");
		
		try {
			Class.forName(jdbcDriver);
		}
		catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}
		
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
}

