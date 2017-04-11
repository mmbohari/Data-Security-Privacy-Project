package dsp.db.query;

import dsp.db.setup.ConnectionController;
import dsp.util.StringUtils;

/**
 * A {@link PreparedSelectStatementGenerator} generates SELECT queries
 * for SQL.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class PreparedSelectStatementGenerator
		extends PreparedStatementGenerator {
	
	/**
	 * Ordered enum of query keywords for this generator.
	 * 
	 * @author Ryan Conrad
	 * @author Imran Iqubal Bohari
	 * @author Fynn Dallmeier
	 */
	private enum Keyword {
		SELECT,
		DISTINCT,
		FROM,
		WHERE
	};
	
	/**
	 * Constructs a new {@link PreparedSelectStatementGenerator}.
	 * 
	 * @param connectionController The connection controller
	 */
	public PreparedSelectStatementGenerator(
			ConnectionController connectionController) {
		
		// Send the connection controller to super
		super(connectionController);
	}
	
	/**
	 * Generates a SELECT statement.
	 * 
	 * @param select The item(s) to select
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedSelectStatementGenerator select(
			String... select) throws DisorderlyQueryException {
		
		// Special case for selecting all
		if(select != null && select.length == 1 && "*".equals(select[0])) {
			return selectAll();
		}

		// Append the string and continue building
		append(Keyword.SELECT, "SELECT " + StringUtils.commaSeparated(select));
		return this;
	}

	/**
	 * Generates a SELECT * statement.
	 * 
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedSelectStatementGenerator selectAll()
			throws DisorderlyQueryException {
		
		// Append the string and continue building
		append(Keyword.SELECT, "SELECT *");
		return this;
	}
	
	/**
	 * Sets the selection to be distinct.
	 * 
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedSelectStatementGenerator distinct()
			throws DisorderlyQueryException {

		// Append the distinct setting and continue building
		append(Keyword.DISTINCT);
		return this;
	}
	
	/**
	 * Generates a FROM statement.
	 * 
	 * @param from The tables
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedSelectStatementGenerator from(
			String from) throws DisorderlyQueryException {
		
		// Append the string and continue building
		append(Keyword.FROM, "FROM " + from);
		return this;
	}
	
	/**
	 * Generates a WHERE statement.
	 * 
	 * @param attribute The attribute to check
	 * @param value The value to look for
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedSelectStatementGenerator where(
			String attribute, String value) throws DisorderlyQueryException {
		
		// Special case for null or empty input
		// TODO Handle these cases with more grace
		// (i.e. what if only one is filled out?)
		if(attribute == null || attribute.isEmpty()
				|| value == null || value.isEmpty()) {
			return this;
		}

		// Append the string and continue building
		append(Keyword.WHERE, "WHERE " + attribute + " = ?", value);
		return this;
	}
}
