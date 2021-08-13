package sk.Adreez.DarkQuests.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sk.Adreez.DarkQuests.Main;

public class MySQL {
	
	private String host = Main.config.getString("MySQL.host");
	private String port = Main.config.getString("MySQL.port");
	private String database = Main.config.getString("MySQL.database");
	private String username = Main.config.getString("MySQL.username");
	private String password = Main.config.getString("MySQL.password");
	private boolean useSSL = Main.config.getBoolean("MySQL.useSSL");
	
	private Connection connection;
	
	public boolean isConnected() {
		return (connection == null ? false : true);
	}
	
	public void connect() throws ClassNotFoundException, SQLException {
		if (!isConnected()) {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=" + useSSL, username, password);
		}
	}
	
	public void disconnect() {
		if (isConnected()) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public Connection getConnection() {
		return connection;
	}

}
