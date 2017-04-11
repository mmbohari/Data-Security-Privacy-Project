package dsp.db.query;

import java.sql.ResultSet;

/**
 * A {@link ResultSetController} contains a {@link ResultSet} as well
 * as the functionality to state whether said result set has any
 * results or not.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class ResultSetController {
	
	/**
	 * The result set.
	 */
	private ResultSet resultSet;
	
	/**
	 * Specifies whether there are results or not.
	 */
	private boolean hasResults;
	
	/**
	 * Constructs a new {@link ResultSetController}.
	 * 
	 * @param resultSet The result set
	 */
	public ResultSetController(ResultSet resultSet) {
		this.resultSet = resultSet;
		this.hasResults = resultSet != null;
	}
	
	/**
	 * Constructs a new {@link ResultSetController} with no results.
	 */
	public ResultSetController() {
		this.resultSet = null;
		this.hasResults = false;
	}
	
	/**
	 * Returns the result set.
	 * 
	 * If there are no results, a warning will be printed. Please use
	 * {@link ResultSetController#hasResults()} to check whether there are
	 * results or not before calling this method.
	 * 
	 * @return The result set
	 */
	public ResultSet getResultSet() {
		if(!hasResults) {
			System.err.println("WARNING: No results were set or obtained.");
		}
		return resultSet;
	}
	
	/**
	 * Returns whether there are results or not.
	 * 
	 * @return Whether there are results or not
	 */
	public boolean hasResults() {
		return hasResults;
	}
}
