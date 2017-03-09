package dsp.db.attributes.datatypes.parameters;

/**
 * {@link Scale} represents the scale parameter of a data type.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 */
public class Scale extends Parameter {
	
	/**
	 * The precision.
	 */
	private int scale;
	
	/**
	 * Constructs a new {@link Scale}.
	 * 
	 * @param precision The scale
	 */
	public Scale(int scale) {
		super("Scale");
		this.scale = scale;
	}
	
	/**
	 * Returns the scale.
	 * 
	 * @return The scale
	 */
	public int getScale() {
		return scale;
	}
}
