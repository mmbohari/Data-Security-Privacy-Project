package dsp.db.query;

/**
 * A {@link DisorderlyQueryException} should be thrown when a
 * {@link PreparedStatementGenerator} subclass has its query
 * preparation methods called out of order.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class DisorderlyQueryException extends Exception {
	private static final long serialVersionUID = -4145627551810367666L;
}
