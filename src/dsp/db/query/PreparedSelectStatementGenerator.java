package dsp.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsp.util.StringUtils;

public class PreparedSelectStatementGenerator
		implements PreparedStatementGenerator {
	
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
	
	public PreparedSelectStatementGenerator(Connection connection) {
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
		return stmt.executeQuery();
	}
	
	public PreparedSelectStatementGenerator select(String... select) throws DisorderlyQueryException {
		if(select != null && select.length == 1 && "*".equals(select[0])) {
			return selectAll();
		}
		
		checkSetPrev(Keyword.SELECT);
		prev = Keyword.SELECT;
		preparedString += "SELECT " + StringUtils.commaSeparated(select);
		return this;
	}

	public PreparedSelectStatementGenerator selectAll() throws DisorderlyQueryException {
		checkSetPrev(Keyword.SELECT);
		prev = Keyword.SELECT;
		preparedString += "SELECT *";
		return this;
	}
	
	public PreparedSelectStatementGenerator distinct() throws DisorderlyQueryException {
		checkSetPrev(Keyword.DISTINCT);
		return this;
	}
	
	public PreparedSelectStatementGenerator from(String from) throws DisorderlyQueryException {
		checkSetPrev(Keyword.FROM);
		preparedString += "FROM " + from;
		return this;
	}
	
	public PreparedSelectStatementGenerator where(String where) throws DisorderlyQueryException {
		if(where.isEmpty()) {
			return this;
		}
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
}
