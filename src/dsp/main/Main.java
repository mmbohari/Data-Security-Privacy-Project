package dsp.main;

import java.sql.*;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hey!");
		
		connectJDBCToAWSEC2();
	
		
	}
	
public static void connectJDBCToAWSEC2() {
	
	String URL = "dsap-project.c7nndjr2fzxb.us-east-1.rds.amazonaws.com";
	String PORT = "3306";
	String DATABASE = "Healthcare";
	String REMOTE_DATABASE_USERNAME = "dsap_group3";
	String DATABASE_USER_PASSWORD = "dsap-34U-6yn-T4R";

    System.out.println("----MySQL JDBC Connection Testing -------");
    
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Where is your MySQL JDBC Driver?");
        e.printStackTrace();
        return;
    }

    System.out.println("MySQL JDBC Driver Registered!");
    Connection connection = null;

    try {
        connection = DriverManager.
                getConnection("jdbc:mysql://" + URL + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
    } catch (SQLException e) {
        System.out.println("Connection Failed!:\n" + e.getMessage());
    }

    if (connection != null) {
        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
    } else {
        System.out.println("FAILURE! Failed to make connection!");
    }

}

}

