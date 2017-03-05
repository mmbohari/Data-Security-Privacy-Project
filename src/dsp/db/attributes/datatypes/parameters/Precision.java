package dsp.db.attributes.datatypes.parameters;

public class Precision extends Parameter {
	private int precision;
	
	public Precision(int precision) {
		super("Precision");
		this.precision = precision;
	}
	
	public int getPrecision() {
		return precision;
	}

}
