package dsp.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementGenerator {
	
	private enum Keyword {
		INIT,
		SELECT,
		DISTINCT,
		FROM,
		WHERE
	};
	
	private PreparedStatement stmt;
	private Connection connection;
	private String preparedString;
	
	private Keyword prev;
	
	private List<String> queryFragments;
	
	public PreparedStatementGenerator(Connection connection) {
		this.connection = connection;
		this.preparedString = "";
		
		prev = Keyword.INIT;
		
		this.queryFragments = new ArrayList<String>();
	}
	
	public ResultSet executeQuery() throws SQLException {
		stmt = connection.prepareStatement(preparedString);
		int index = 1;
		for(String query : queryFragments) {
			stmt.setString(index++, query);
		}
		System.out.println(stmt);
		return stmt.executeQuery();
	}
	
	public PreparedStatementGenerator select(String... select) throws DisorderlyQueryException {
		checkSetPrev(Keyword.SELECT);
		prev = Keyword.SELECT;
		preparedString += "SELECT " + commaSeparated(select);
		return this;
	}

	public PreparedStatementGenerator selectAll() throws DisorderlyQueryException {
		checkSetPrev(Keyword.SELECT);
		prev = Keyword.SELECT;
		preparedString += "SELECT *";
		return this;
	}
	
	public PreparedStatementGenerator distinct() throws DisorderlyQueryException {
		checkSetPrev(Keyword.DISTINCT);
		return this;
	}
	
	public PreparedStatementGenerator from(String from) throws DisorderlyQueryException {
		checkSetPrev(Keyword.FROM);
		preparedString += "FROM " + from;
		return this;
	}
	
	public PreparedStatementGenerator where(String where) throws DisorderlyQueryException {
		checkSetPrev(Keyword.WHERE);
		preparedString += "WHERE ? ";
		queryFragments.add(where);
		return this;
	}
	
	private void checkSetPrev(Keyword curr) throws DisorderlyQueryException {
		if(curr.ordinal() <= prev.ordinal()) {
			throw new DisorderlyQueryException();
		}
		else {
			if(!prev.equals(Keyword.INIT)) {
				preparedString += " ";
			}
			prev = curr;
		}
	}
	
	private String commaSeparated(String[] strings) {
	    StringBuilder sb = new StringBuilder();
	    String sep = "";
	    for (String string: strings) {
	        sb.append(sep);
	        sb.append(string);
	        sep = ",";
	    }
	    return sb.toString();
	}
}
