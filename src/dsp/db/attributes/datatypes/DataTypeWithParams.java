package dsp.db.attributes.datatypes;

import dsp.db.attributes.datatypes.generic.DBDataType;
import dsp.db.attributes.datatypes.parameters.Parameter;

public abstract class DataTypeWithParams extends DBDataType {

	private Parameter params;
	
	public DataTypeWithParams(String type, Parameter params) {
		super(type);
		
		this.params = params;
	}
	
	@Override
	public String toString() {
		return super.getType() + "(" + params + ")";
	}
}
