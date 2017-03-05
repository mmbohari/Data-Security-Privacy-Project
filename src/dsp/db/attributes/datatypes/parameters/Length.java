package dsp.db.attributes.datatypes.parameters;

public class Length extends Parameter {
	
	private int length;
	
	public Length(int length) {
		super("Length");
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
}
