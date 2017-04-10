package dsp.db.query;

import dsp.db.setup.ConnectionController;

public class PreparedUserStatementGenerator
		extends PreparedStatementGenerator {
	
	/**
	 * Ordered enum of query keywords for this generator.
	 * 
	 * @author Ryan Conrad
	 */
	private enum Keyword {
		CREATE_USER,
		IDENTIFIED_BY
	};

	public PreparedUserStatementGenerator(
			ConnectionController connectionController) {
		super(connectionController);
	}

	public PreparedUserStatementGenerator createUser(String username)
			throws DisorderlyQueryException {
		append(Keyword.CREATE_USER, "CREATE USER '" + username + "'");
		
		return this;
	}
	
	public PreparedUserStatementGenerator identifiedBy(char[] password)
			throws DisorderlyQueryException {
		append(Keyword.IDENTIFIED_BY, "IDENTIFIED BY '" + new String(password) + "'");
		
		return this;
	}
}
