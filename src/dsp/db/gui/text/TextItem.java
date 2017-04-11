package dsp.db.gui.text;

/**
 * A {@link TextItem}
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class TextItem {
	private final String name;
	private final String displayText;
	
	public TextItem(String name, String displayText) {
		this.name = name;
		this.displayText = displayText;
	}
	
	public final String getText() {
		return displayText;
	}
	
	public final String toString() {
		return name;
	}
}
