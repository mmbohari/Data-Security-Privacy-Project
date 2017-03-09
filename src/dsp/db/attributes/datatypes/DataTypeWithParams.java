package dsp.db.attributes.datatypes;

import dsp.db.attributes.datatypes.generic.DBDataType;
import dsp.db.attributes.datatypes.parameters.Parameter;

/**
 * A {@link DataTypeWithParams} is a {@link DBDataType} which can use
 * parameters along with the type.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 */
public abstract class DataTypeWithParams extends DBDataType {

	/**
	 * The parameter(s).
	 */
	private Parameter params;
	
	/**
	 * Constructs a new {@link DataTypeWithParams}.
	 * 
	 * @param type The type's name
	 * @param params The parameter(s)
	 */
	public DataTypeWithParams(String type, Parameter params) {
		super(type);
		
		this.params = params;
	}
	
	@Override
	public String toString() {
		return super.getType() + "(" + params + ")";
	}
}
