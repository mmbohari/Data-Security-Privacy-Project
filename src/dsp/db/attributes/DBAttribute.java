package dsp.db.attributes;

import dsp.db.attributes.datatypes.generic.DBDataType;

public class DBAttribute {
	private String name;
	private DBDataType type;
	private boolean isNullAllowed;
	
	public DBAttribute(String name, DBDataType type, boolean isNullAllowed) {
		this.name = name;
		this.type = type;
		this.isNullAllowed = isNullAllowed;
	}
	
	public String getName() {
		return name;
	}
	
	public DBDataType getType() {
		return type;
	}
	
	public boolean isNullAllowed() {
		return isNullAllowed;
	}
	
	@Override
	public String toString() {
		String nullString = !isNullAllowed ? " NOT NULL" : "";
		return name + " " + type + nullString;
	}
}
