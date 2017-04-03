package dsp.db.gui.text;

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
