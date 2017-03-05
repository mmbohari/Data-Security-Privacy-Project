package dsp.db.attributes.datatypes.parameters;

public abstract class Parameter {
	String name;
	
	public Parameter(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
