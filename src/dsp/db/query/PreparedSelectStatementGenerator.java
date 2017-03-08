package dsp.db.query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsp.db.setup.ConnectionController;
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
	
	private ConnectionController connectionController;
	private String preparedString;
	
	private Keyword prev;
	
	private List<String> queryFragments;
	
	public PreparedSelectStatementGenerator(ConnectionController connectionController) {
		this.connectionController = connectionController;
		this.preparedString = "";
		
		prev = Keyword.INIT;
		
		this.queryFragments = new ArrayList<String>();
	}
	
	@Override
	public ResultSetController executeQuery() throws SQLException {
		return connectionController.executeQuery(preparedString, queryFragments);
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
	
	public PreparedSelectStatementGenerator where(String attribute, String value) throws DisorderlyQueryException {
		if(attribute == null || attribute.isEmpty()
				|| value == null || value.isEmpty()) {
			return this;
		}
		checkSetPrev(Keyword.WHERE);
		preparedString += "WHERE " + attribute + " = ?";
		queryFragments.add(value);
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
