package dsp.db.attributes;

import dsp.db.attributes.datatypes.generic.DBDataType;

/**
 * A {@link DBAttribute} is an attribute in a database table.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 */
public class DBAttribute {
	
	/**
	 * The attribute's name.
	 */
	private String name;
	
	/**
	 * The attribute's type.
	 */
	private DBDataType type;
	
	/**
	 * Specifies whether null is allowed or not.
	 */
	private boolean isNullAllowed;
	
	/**
	 * Constructs a new {@link DBAttribute}.
	 * 
	 * @param name The attribute's name
	 * @param type The attribute's type
	 * @param isNullAllowed Specifies whether null is allowed or not
	 */
	public DBAttribute(String name, DBDataType type, boolean isNullAllowed) {
		this.name = name;
		this.type = type;
		this.isNullAllowed = isNullAllowed;
	}
	
	/**
	 * Returns the attribute's name.
	 * 
	 * @return The attribute's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the attribute's type.
	 * 
	 * @return The attribute's type
	 */
	public DBDataType getType() {
		return type;
	}

	/**
	 * Returns whether null is allowed or not.
	 * 
	 * @return Whether null is allowed or not
	 */
	public boolean isNullAllowed() {
		return isNullAllowed;
	}
	
	@Override
	public String toString() {
		String nullString = !isNullAllowed ? " NOT NULL" : "";
		return name + " " + type + nullString;
	}
}
