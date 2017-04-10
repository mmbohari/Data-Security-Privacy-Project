package dsp.util;

import java.util.HashMap;
import java.util.Map;

public final class SQLErrorCodeMap {
	public static final Map<Integer, String> ERROR_CODE_STRINGS =
		new HashMap<Integer, String>() {
		
			/**
			 * 
			 */
			private static final long serialVersionUID = -9191648848407079678L;
			
			{
				put(1044, "User does not have permission to access the database.");
				put(1045, "Incorrect or missing password.");
			}
	};
}
