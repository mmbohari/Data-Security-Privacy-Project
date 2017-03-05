package dsp.db.attributes.datatypes.generic;

public abstract class DBDataType {
	
	String type;
	
	public DBDataType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return getType();
	}
}
