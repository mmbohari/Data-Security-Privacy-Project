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
		this.resultSet = null;
		this.hasResults = false;
	}
	
	public ResultSet getResultSet() {
		if(!hasResults) {
			System.err.println("WARNING: No results were set or obtained.");
		}
		return resultSet;
	}
	
	public boolean hasResults() {
		return hasResults;
	}
}
