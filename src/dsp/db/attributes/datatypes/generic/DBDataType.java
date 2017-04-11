package dsp.db.attributes.datatypes.generic;

/**
 * A {@link DBDataType} is an abstract representation
 * of a database data type.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public abstract class DBDataType {
	
	/**
	 * The type's name.
	 */
	String type;
	
	/**
	 * Constructs a new {@link DBDataType}.
	 * 
	 * @param type The type's name
	 */
	public DBDataType(String type) {
		this.type = type;
	}
	
	/**
	 * Returns the type's name.
	 * 
	 * @return The type's name
	 */
	public String getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		return getType();
	}
}
