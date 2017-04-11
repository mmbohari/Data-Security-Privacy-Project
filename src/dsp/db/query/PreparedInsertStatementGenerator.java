package dsp.db.query;

import java.sql.SQLException;

import dsp.db.setup.ConnectionController;
import dsp.util.StringUtils;

/**
 * A {@link PreparedInsertStatementGenerator} generates INSERT INTO
 * queries for SQL.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class PreparedInsertStatementGenerator
		extends PreparedStatementGenerator {

	/**
	 * Ordered enum of query keywords for this generator.
	 * 
	 * @author Ryan Conrad
	 */
	private enum Keyword {
		INSERT_INTO,
		VALUES,
	};
	
	/**
	 * Constructs a new {@link PreparedInsertStatementGenerator}.
	 * 
	 * @param connectionController The connection controller
	 */
	public PreparedInsertStatementGenerator(
			ConnectionController connectionController) {

		// Send the connection controller to super
		super(connectionController);
	}
	
	@Override
	public ResultSetController executeQuery() throws SQLException {
		// TODO Make sure the query is correct before executing it
		return null;
		//return super.executeQuery();
	}
	
	/**
	 * Generates an INSERT INTO statement.
	 * 
	 * @param table The table
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedInsertStatementGenerator insertInto(String table)
			throws DisorderlyQueryException {
		
		// Use the other insertInto(...) method with no columns
		return insertInto(table, new String[0]);
	}
	
	/**
	 * Generates an INSERT INTO statement.
	 * 
	 * @param table The table
	 * @param columns The columns
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedInsertStatementGenerator insertInto(
			String table, String... columns)
			throws DisorderlyQueryException {
		
		// Prepare the string
		String preparedString = "INSERT INTO " + table;
		if(columns != null && columns.length > 0) {
			preparedString += "(";
			preparedString += StringUtils.commaSeparated(columns);
			preparedString += ")";
		}
		
		// Append the string and continue building
		append(Keyword.INSERT_INTO, preparedString);
		return this;
	}
	
	/**
	 * Generates a VALUES statement.
	 * 
	 * @param values The values to insert
	 * @return this
	 * @throws DisorderlyQueryException If the query elements are out of order
	 */
	public PreparedInsertStatementGenerator values(String... values)
			throws DisorderlyQueryException {
		
		// Prepare the string
		String preparedString = "VALUES";
		preparedString += "(";
		preparedString += StringUtils.commaSeparated(
				StringUtils.fill(values.length, "?"));
		preparedString += ")";
		
		// Append the string and continue building
		append(Keyword.VALUES, preparedString, values);
		return this;
	}
}
