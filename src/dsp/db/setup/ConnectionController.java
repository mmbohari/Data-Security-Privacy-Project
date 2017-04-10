package dsp.db.setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dsp.db.query.ResultSetController;

/**
 * A {@link ConnectionController} manages a {@link Connection} to
 * a sql server.
 * 
 * @author Ryan Conrad
 */
public class ConnectionController {
	
	/**
	 * String to append to the database URL that specifies behavior
	 * in the case that a zero date time is returned.
	 * 
	 * If this isn't desired, change the string to "".
	 */
	private static final String ZERO_DATE_HANDLER =
			"?zeroDateTimeBehavior=convertToNull";
	
	/**
	 * The URL of the database.
	 */
	public static final String URL =
			"mariadb-healthcare.c7nndjr2fzxb.us-east-1.rds.amazonaws.com";
	
	/**
	 * The port number to use for the database.
	 */
	public static final int PORT = 3306;
	
	/**
	 * The name of the database.
	 */
	public static final String DATABASE_NAME = "Healthcare";
	
	/**
	 * The username of the database on the remote.
	 */
	public static final String REMOTE_DATABASE_USERNAME = "dsap_group3";
	
	/**
	 * The connection.
	 */
	Connection connection;
	
	/**
	 * If false, the connection wasn't established (it's null).
	 * 
	 * Otherwise, the connection was successful.
	 */
	boolean isConnected;
	
	/**
	 * Creates a new {@link ConnectionController}.
	 */
	public ConnectionController() {
		connection = null;
		isConnected = false;
	}
	
	/**
	 * Attempts to connect to the database with the given password.
	 * 
	 * @param password The database's password
	 */
	public void connect(String password) {
		connect(REMOTE_DATABASE_USERNAME, password);
	}
	
	/**
	 * Attempts to connect to the database with the given username and password.
	 * 
	 * @param password The user's username
	 * @param password The user's password
	 */
	public void connect(String username, String password) {
		
	    // Attempt to instantiate the driver
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.err.println("Where is your MySQL JDBC Driver?");
	        e.printStackTrace();
	    }
	    
	    // Establish the connection
	    try {
	        connection = DriverManager.
	                getConnection("jdbc:mysql://" + URL + ":" + PORT + "/"
	                		+ DATABASE_NAME + ZERO_DATE_HANDLER,
	                		username, password);
	    } catch (SQLException e) {
	        System.err.println("Connection Failed!:\n" + e.getMessage());
	        JOptionPane.showMessageDialog(null,
	        		"Connection Failed!:\n" + e.getMessage(),
	        		"Error!",
	        		JOptionPane.ERROR_MESSAGE);
	    }

	    // If the connection was established successfully
	    if (connection != null) {
	    	
	    	// Reflect it in the boolean
	        isConnected = true;
	    }
	}
	
	/**
	 * Attempts to execute a query on the server and returns the results
	 * in a {@link ResultSetController}.
	 * 
	 * @param sql The query
	 * @return The results
	 * @throws SQLException
	 */
	public ResultSetController executeQuery(String sql) throws SQLException {
		
		// If the server is connected
		if(isConnected) {
			
			// Return the results of the executed query
			return new ResultSetController(
					connection.prepareStatement(sql).executeQuery());
		}
		else {
			
			// With no connection, return an empty result set
			return new ResultSetController();
		}
	}
	
	/**
	 * Attempts to execute a statement on the server.
	 * in a {@link ResultSetController}.
	 * 
	 * @param sql The query
	 * @return True if successful
	 * @throws SQLException
	 */
	public boolean execute(String sql) throws SQLException {
		
		// If the server is connected
		if(isConnected) {
			
			// Return the results of the executed query
			return connection.prepareStatement(sql).execute();
		}
		
		return false;
	}

	/**
	 * Attempts to execute a parameterized query on the server and
	 * returns the results in a {@link ResultSetController}.
	 * 
	 * @param sql The parameterized query
	 * @param queryFragments The parameters to fill
	 * @return The results
	 * @throws SQLException
	 */
	public ResultSetController executeQuery(
			String sql, List<String> queryFragments) throws SQLException {
		
		// If the server is connected
		if(isConnected) {
			
			// Prepare the statement
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// Set the parameters
			int index = 1;
			for(String query : queryFragments) {
				stmt.setString(index++, query);
			}
			
			// Return the results of the executed query
			return new ResultSetController(stmt.executeQuery());
		}
		else {
			
			// With no connection, return an empty result set
			return new ResultSetController();
		}
	}

	/**
	 * Attempts to execute a parameterized query on the server and
	 * returns the results in a {@link ResultSetController}.
	 * 
	 * @param sql The parameterized query
	 * @param queryFragments The parameters to fill
	 * @return The results
	 * @throws SQLException
	 */
	public int executeUpdate(
			String sql, List<String> queryFragments) throws SQLException {
		
		// If the server is connected
		if(isConnected) {
			
			// Prepare the statement
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// Set the parameters
			int index = 1;
			for(String query : queryFragments) {
				stmt.setString(index++, query);
			}
			
			// Return the result of the executed query
			return stmt.executeUpdate();
		}
		else {
			
			// With no connection, return -1
			return -1;
		}
	}
}
