package dsp.db.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dsp.db.query.BlankResultSet;

public class ConnectionController {
	
	Connection connection;
	boolean isConnected;
	
	public ConnectionController() {
		connection = null;
		isConnected = false;
	}
	
	public void connect(String password) {
		String URL = "dsap-project.c7nndjr2fzxb.us-east-1.rds.amazonaws.com";
		String PORT = "3306";
		String DATABASE = "Healthcare";
		String REMOTE_DATABASE_USERNAME = "dsap_group3";
		String DATABASE_USER_PASSWORD = password;

	    System.out.println("----MySQL JDBC Connection Testing -------");
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Where is your MySQL JDBC Driver?");
	        e.printStackTrace();
	    }

	    System.out.println("MySQL JDBC Driver Registered!");

	    try {
	        connection = DriverManager.
	                getConnection("jdbc:mysql://" + URL + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
	    } catch (SQLException e) {
	        System.out.println("Connection Failed!:\n" + e.getMessage());
	    }

	    if (connection != null) {
	        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
	        isConnected = true;
	    } else {
	        System.out.println("FAILURE! Failed to make connection!");
	    }
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		if(isConnected) {
			return connection.prepareStatement(sql).executeQuery();
		}
		else {
			return new BlankResultSet();
		}
	}

	public ResultSet executeQuery(
			String sql, List<String> queryFragments) throws SQLException {
		if(isConnected) {
			PreparedStatement stmt = connection.prepareStatement(sql);
			int index = 1;
			for(String query : queryFragments) {
				stmt.setString(index++, query);
			}
			return stmt.executeQuery();
		}
		else {
			return new BlankResultSet();
		}
	}
}
