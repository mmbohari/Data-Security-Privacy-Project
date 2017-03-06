package dsp.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsp.util.StringUtils;

public class PreparedInsertStatementGenerator
		implements PreparedStatementGenerator {

	private enum Keyword {
		INIT,
		INSERT_INTO,
		VALUES,
	};
	
	private PreparedStatement stmt;
	private Connection connection;
	private String preparedString;
	
	private Keyword prev;
	
	private List<String> queryFragments;
	
	public PreparedInsertStatementGenerator(Connection connection) {
		this.connection = connection;
		this.preparedString = "";
		
		prev = Keyword.INIT;
		
		this.queryFragments = new ArrayList<String>();
	}
	
	@Override
	public ResultSet executeQuery() throws SQLException {
		stmt = connection.prepareStatement(preparedString);
		int index = 1;
		for(String query : queryFragments) {
			stmt.setString(index++, query);
		}
		System.out.println(stmt);
		
		// TODO Make sure the query is correct before executing it
		return null;
		//return stmt.executeQuery();
	}
	
	public PreparedInsertStatementGenerator insertInto(String table)
			throws DisorderlyQueryException {
		return insertInto(table, new String[0]);
	}
	
	public PreparedInsertStatementGenerator insertInto(
			String table, String... columns)
			throws DisorderlyQueryException {
		checkSetPrev(Keyword.INSERT_INTO);
		preparedString += "INSERT INTO " + table;
		if(columns != null && columns.length > 0) {
			preparedString += "(";
			preparedString += StringUtils.commaSeparated(columns);
			preparedString += ")";
		}
		return this;
	}
	
	public PreparedInsertStatementGenerator values(String... values)
			throws DisorderlyQueryException {
		checkSetPrev(Keyword.VALUES);
		preparedString += "VALUES";
		preparedString += "(";
		preparedString += StringUtils.commaSeparated(
				StringUtils.fill(values.length, "?"));
		preparedString += ")";
		
		for(String value : values) {
			queryFragments.add(value);
		}
		
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
}
