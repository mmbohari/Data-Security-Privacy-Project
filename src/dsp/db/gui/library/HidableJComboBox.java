package dsp.db.gui.library;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;

public class HidableJComboBox<E> extends JComboBox<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3256168247204306586L;
	
	private Map<E,Integer> hiddenItems;
	
	public HidableJComboBox() {
		hiddenItems = new HashMap<E,Integer>();
	}
	
	public void hide(E item) {
		int index = -1;
		for(int i = 0; i < getModel().getSize(); ++i) {
			if(getModel().getElementAt(i).equals(item)) {
				index = i;
				break;
			}
		}
		if(index != -1) {
			removeItem(item);
			hiddenItems.put(item, index);
		}
	}
	public void unhide(E item) {
		if(hiddenItems.containsKey(item))
		{
			int index = hiddenItems.get(item);
			insertItemAt(item, index);
			hiddenItems.remove(item);
		}
	}
}
