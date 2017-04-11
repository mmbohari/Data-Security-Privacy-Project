package dsp.db.query;

import dsp.db.setup.ConnectionController;

/**
 * A {@link PreparedUserStatementGenerator}
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class PreparedUserStatementGenerator
		extends PreparedStatementGenerator {
	
	/**
	 * Ordered enum of query keywords for this generator.
	 * 
	 * @author Ryan Conrad
	 * @author Imran Iqubal Bohari
	 * @author Fynn Dallmeier
	 */
	private enum Keyword {
		CREATE_USER,
		IF_NOT_EXISTS,
		USERNAME,
		IDENTIFIED_BY
	};

	public PreparedUserStatementGenerator(
			ConnectionController connectionController) {
		super(connectionController);
	}

	public PreparedUserStatementGenerator createUser()
			throws DisorderlyQueryException {
		append(Keyword.CREATE_USER, "CREATE USER");
		
		return this;
	}

	public PreparedUserStatementGenerator ifNotExists()
			throws DisorderlyQueryException {
		append(Keyword.IF_NOT_EXISTS, "IF NOT EXISTS");
		
		return this;
	}
	
	public PreparedUserStatementGenerator username(String username)
			throws DisorderlyQueryException {
		append(Keyword.USERNAME, "?", username);
		
		return this;
	}
	
	public PreparedUserStatementGenerator identifiedBy(char[] password)
			throws DisorderlyQueryException {
		append(Keyword.IDENTIFIED_BY, "IDENTIFIED BY '" + new String(password) + "'");
		
		return this;
	}
}
