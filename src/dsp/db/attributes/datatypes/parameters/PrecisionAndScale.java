package dsp.db.attributes.datatypes.parameters;

public class PrecisionAndScale extends Parameter {

	private int precision;
	private int scale;
	
	public PrecisionAndScale(int precision, int scale) {
		super("Precision,Scale");
		this.precision = precision;
		this.scale = scale;
	}
	
	public int getPrecision() {
		return precision;
	}
	
	public int getScale() {
		return scale;
	}
}
