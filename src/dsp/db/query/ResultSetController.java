package dsp.db.query;

import java.sql.ResultSet;

public class ResultSetController {
	private ResultSet resultSet;
	private boolean hasResults;
	
	public ResultSetController(ResultSet resultSet) {
		this.resultSet = resultSet;
		this.hasResults = resultSet != null;
	}
	
	public ResultSetController() {
		this.hasResults = false;
	}
	
	public ResultSet getResultSet() {
		return resultSet;
	}
	
	public boolean hasResults() {
		return hasResults;
	}
}
