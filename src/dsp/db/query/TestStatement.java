package dsp.db.query;

import java.sql.ResultSet;
import java.sql.SQLException;

import dsp.db.setup.DBConnection;
import dsp.db.setup.DBPasswordManager;

public class TestStatement {
	public static void main(String[] args) {
		try {
			ResultSet rs = new DBConnection().getConnection(
					new DBPasswordManager().getPassword())
			.prepareStatement("show tables")
			.executeQuery();
			
			printAll(rs);
			
			rs = new PreparedStatementGenerator(
					new DBConnection().getConnection(
							new DBPasswordManager().getPassword()))
				.selectAll()
				.from("INFORMATION_SCHEMA.COLUMNS")
				.where("TABLE_NAME='Doctor'")
				.executeQuery();
			
			printAll(rs);
		} catch (SQLException | DisorderlyQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printAll(ResultSet rs) throws SQLException {
		
		   while (rs.next()) {
		       for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
		           if (i > 1) System.out.print(",  ");
		           String columnValue = rs.getString(i);
		           System.out.print(columnValue + " " +
		        		   rs.getMetaData().getColumnName(i));
		       }
		       System.out.println("");
		   }
		
	}
}
