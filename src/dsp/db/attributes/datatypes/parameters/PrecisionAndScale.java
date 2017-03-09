package dsp.db.attributes.datatypes.parameters;

/**
 * {@link PrecisionAndScale} contains the precision and scale
 * parameters of a data type.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 *
 */
public class PrecisionAndScale extends Parameter {
	
	/**
	 * The {@link Precision} object.
	 */
	private Precision precision;
	
	/**
	 * The {@link Scale} object.
	 */
	private Scale scale;
	
	/**
	 * Constructs a new {@link PrecisionAndScale}.
	 * 
	 * @param precision The precision
	 * @param scale The scale
	 */
	public PrecisionAndScale(int precision, int scale) {
		super("Precision,Scale");
		this.precision = new Precision(precision);
		this.scale = new Scale(scale);
	}
	
	/**
	 * Returns the precision.
	 * 
	 * @return The precision
	 */
	public int getPrecision() {
		return precision.getPrecision();
	}

	/**
	 * Returns the scale.
	 * 
	 * @return The scale
	 */
	public int getScale() {
		return scale.getScale();
	}
	
	/**
	 * Returns the {@link Precision} object.
	 * 
	 * @return The {@link Precision} object
	 */
	public Precision getPrecisionParameter() {
		return precision;
	}

	/**
	 * Returns the {@link Scale} object.
	 * 
	 * @return The {@link Scale} object
	 */
	public Scale getScaleParameter() {
		return scale;
	}
	
	@Override
	public String toString() {
		return getPrecision() + "," + getScale();
	}
}
