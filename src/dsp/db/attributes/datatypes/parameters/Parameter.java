package dsp.db.attributes.datatypes.parameters;

/**
 * {@link Parameter} is an abstract representation of a parameter
 * for a {@link DBDataType}.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public abstract class Parameter {
	
	/**
	 * The parameter's name.
	 */
	private String name;
	
	/**
	 * Constructs a new {@link Parameter}.
	 * 
	 * @param name The parameter's name
	 */
	public Parameter(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the parameter's name.
	 * 
	 * @return The parameter's name
	 */
	public String getName() {
		return name;
	}
}
