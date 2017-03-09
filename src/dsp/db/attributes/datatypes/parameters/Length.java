package dsp.db.attributes.datatypes.parameters;

/**
 * {@link Length} represents the length parameter of a data type.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 */
public class Length extends Parameter {
	
	/**
	 * The length.
	 */
	private int length;
	
	/**
	 * Constructs a new {@link Length}.
	 * 
	 * @param length The length
	 */
	public Length(int length) {
		super("Length");
		this.length = length;
	}
	
	/**
	 * Returns the length.
	 * 
	 * @return The length
	 */
	public int getLength() {
		return length;
	}
}
