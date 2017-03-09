package dsp.db.attributes.datatypes;

import dsp.db.attributes.datatypes.generic.DBDataType;

/**
 * A {@link DataTypeNoParams} is a {@link DBDataType} which
 * does not take in any parameters.
 * 
 * Use {@link Object#toString()} to get this object's representation.
 * 
 * @author Ryan Conrad
 */
public class DataTypeNoParams extends DBDataType {

	/**
	 * Constructs a new {@link DataTypeNoParams}.
	 * 
	 * @param type The type's name
	 */
	public DataTypeNoParams(String type) {
		super(type);
	}
}
