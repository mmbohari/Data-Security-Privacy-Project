package dsp.db.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dsp.db.query.ResultSetController;

public class ConnectionController {
	
	private static final String ZERO_DATE_HANDLER =
			"?zeroDateTimeBehavior=convertToNull";
	
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
	                getConnection("jdbc:mysql://" + URL + ":" + PORT + "/" + DATABASE
	        				+ ZERO_DATE_HANDLER, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
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

	public ResultSetController executeQuery(String sql) throws SQLException {
		if(isConnected) {
			return new ResultSetController(
					connection.prepareStatement(sql).executeQuery());
		}
		else {
			return new ResultSetController();
		}
	}

	public ResultSetController executeQuery(
			String sql, List<String> queryFragments) throws SQLException {
		if(isConnected) {
			PreparedStatement stmt = connection.prepareStatement(sql);
			int index = 1;
			for(String query : queryFragments) {
				stmt.setString(index++, query);
			}
			System.out.println(stmt);
			return new ResultSetController(stmt.executeQuery());
		}
		else {
			return new ResultSetController();
		}
	}
}
