package dsp.db.query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dsp.db.setup.ConnectionController;

/**
 * A {@link PreparedStatementGenerator} should contain a series of methods
 * related to compiling SQL queries, and following this compilation,
 * {@link PreparedStatementGenerator#executeQuery()} should be called.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public abstract class PreparedStatementGenerator {
	
	/**
	 * The connection controller.
	 */
	private ConnectionController connectionController;
	
	/**
	 * The prepared statement string.
	 */
	private String preparedString;
	
	/**
	 * The query values to fill in the prepared statement with.
	 */
	private List<String> queryValues;
	
	/**
	 * The previous query fragment that was filled out (as an {@link Enum}).
	 */
	private Enum<?> prev;
	
	/**
	 * Constructs a new {@link PreparedStatementGenerator}.
	 * 
	 * @param connectionController The connection controller
	 */
	public PreparedStatementGenerator(
			ConnectionController connectionController) {
		
		// Store the connection controller
		this.connectionController = connectionController;
		
		// Initialize the prepared string
		this.preparedString = "";
		
		// Initialize the query values list
		this.queryValues = new ArrayList<String>();
		
		// Set enum to null, initially
		prev = null;
	}
	
	/**
	 * Executes a query based on the generator's compiled SQL query.
	 * 
	 * @return The results set controller
	 * @throws SQLException If there is an error in the SQL query
	 */
	public ResultSetController executeQuery() throws SQLException {
		return connectionController.executeQuery(
				preparedString, queryValues);
	}
	
	/**
	 * Executes a query based on the generator's compiled SQL query.
	 * 
	 * @return The results set controller
	 * @throws SQLException If there is an error in the SQL query
	 */
	public int executeUpdate() throws SQLException {
		return connectionController.executeUpdate(
				preparedString, queryValues);
	}
	
	/**
	 * Appends the given string to the query.
	 * 
	 * This method also takes in an enum representation of the query to
	 * make sure that the query fragments are being compiled in the
	 * correct order as defined by the subclass.
	 * 
	 * @param curr The current enum to set
	 * @param queryFragment The string to append
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	protected void append(Enum<?> curr, String queryFragment)
			throws DisorderlyQueryException {
		checkSetPrev(curr);
		preparedString += queryFragment;
	}
	
	/**
	 * Appends the given string to the query and appends the given values
	 * to the list of query values.
	 * 
	 * This method also takes in an enum representation of the query to
	 * make sure that the query fragments are being compiled in the
	 * correct order as defined by the subclass.
	 * 
	 * @param curr The current enum to set
	 * @param queryFragment The string to append
	 * @param values The values to substitute in the query fragment
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	protected void append(Enum<?> curr, String queryFragment, String... values)
			throws DisorderlyQueryException {
		append(curr, queryFragment);
		if(values != null && values.length > 0) {
			for(String value : values) {
				queryValues.add(value);
			}
		}
	}
	
	/**
	 * Synonymous with {@link PreparedStatementGenerator#checkSetPrev(Enum)}.
	 * 
	 * @param curr The current enum to set
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	protected void append(Enum<?> curr) throws DisorderlyQueryException {
		checkSetPrev(curr);
	}
	
	/**
	 * Checks the enum to see if it comes after the previously launched
	 * statement and then sets it if so.
	 * 
	 * @param curr The current enum to set
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	protected void checkSetPrev(Enum<?> curr)
			throws DisorderlyQueryException {
		
		// Check for null and ordinality
		if(prev != null && curr.ordinal() <= prev.ordinal()) {
			
			// Throw an exception if called out of order
			throw new DisorderlyQueryException();
		}
		else {
			
			// If this isn't the first query
			if(prev != null) {
				
				// Add a space
				preparedString += " ";
			}
			
			// Set the enum
			prev = curr;
		}
	}
}
