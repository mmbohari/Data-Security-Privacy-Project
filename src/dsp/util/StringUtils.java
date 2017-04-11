package dsp.util;

/**
 * {@link StringUtils} contains some helper functions
 * for {@link String} objects.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class StringUtils {
	
	/**
	 * Creates a concatenation of the given strings,
	 * comma-separated.
	 * 
	 * @param strings The strings to comma-separate
	 * @return String concatenation, comma-separated
	 */
	public static final String commaSeparated(String[] strings) {
	    String returnString = "";
	    String separator = "";
	    for (String string: strings) {
	    	returnString += separator;
	    	returnString += string;
	        separator = ",";
	    }
	    return returnString;
	}
	
	/**
	 * Creates a new array of the specified length,
	 * gives every element of the array the given value,
	 * and returns the array.
	 * 
	 * @param length The length of the array
	 * @param val The value to use
	 * @return New String array with filled in values
	 */
	public static final String[] fill(int length, String val) {
		String[] parameterizedArray = new String[length];
		for(int i = 0; i < parameterizedArray.length; ++i) {
			parameterizedArray[i] = val;
		}
		return parameterizedArray;
	}
}
