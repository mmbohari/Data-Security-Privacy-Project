package dsp.db.attributes.datatypes.parameters;

/**
 * {@link Precision} represents the precision parameter of a data type.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class Precision extends Parameter {
	
	/**
	 * The precision.
	 */
	private int precision;
	
	/**
	 * Constructs a new {@link Precision}.
	 * 
	 * @param precision The precision
	 */
	public Precision(int precision) {
		super("Precision");
		this.precision = precision;
	}
	
	/**
	 * Returns the precision.
	 * 
	 * @return The precision
	 */
	public int getPrecision() {
		return precision;
	}
}
