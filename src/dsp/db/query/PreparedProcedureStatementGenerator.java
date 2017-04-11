package dsp.db.query;

import dsp.db.setup.ConnectionController;
import dsp.util.StringUtils;

/**
 * A {@link PreparedProcedureStatementGenerator}
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class PreparedProcedureStatementGenerator
		extends PreparedStatementGenerator {

	/**
	 * Ordered enum of query keywords for this generator.
	 * 
	 * @author Ryan Conrad
	 * @author Imran Iqubal Bohari
	 * @author Fynn Dallmeier
	 */
	private enum Keyword {
		CALL,
		PARAMS,
		END
	};
	
	/**
	 * Constructs a new {@link PreparedInsertStatementGenerator}.
	 * 
	 * @param connectionController The connection controller
	 */
	public PreparedProcedureStatementGenerator(
			ConnectionController connectionController) {

		// Send the connection controller to super
		super(connectionController);
	}
	
	public void call(String procedureName) throws DisorderlyQueryException {
		append(Keyword.CALL, "CALL " + procedureName);
	}
	
	public void params(String... params) throws DisorderlyQueryException {
		append(Keyword.PARAMS, "(" + StringUtils.commaSeparated(params));
	}
	
	public void end() throws DisorderlyQueryException {
		append(Keyword.END, ")");
	}
	
}
