package dsp.util;

public class StringUtils {
	public static final String commaSeparated(String[] strings) {
	    StringBuilder sb = new StringBuilder();
	    String sep = "";
	    for (String string: strings) {
	        sb.append(sep);
	        sb.append(string);
	        sep = ",";
	    }
	    return sb.toString();
	}
	
	public static final String[] fill(int length, String val) {
		String[] parameterizedArray = new String[length];
		for(int i = 0; i < parameterizedArray.length; ++i) {
			parameterizedArray[i] = val;
		}
		return parameterizedArray;
	}
}
