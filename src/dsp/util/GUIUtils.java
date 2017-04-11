package dsp.util;

import java.util.Collection;
import java.util.HashSet;

import javax.swing.JComboBox;

import dsp.db.gui.library.HidableJComboBox;

/**
 * A {@link GUIUtils}
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class GUIUtils {
	
	@SuppressWarnings("unchecked")
	public static <T> void hideDuplicateItems(
			Collection<HidableJComboBox<T>> comboBoxes) {
		
		Collection<Object> selections = getSelectedItems(comboBoxes);
		for(HidableJComboBox<T> comboBox : comboBoxes) {
			for(Object selection: selections) {
				if(!comboBox.getSelectedItem().equals(selection)) {
					try {
						comboBox.hide((T)selection);
					}
					catch(ClassCastException e) {
						System.err.println(e.getMessage());
					}
				}
			}
		}
	}
	
	public static <T> void makeSelectionUnique(
			JComboBox<T> comboBox,
			Collection<JComboBox<T>> comboBoxes) {

		if(isSelectionUnique(comboBox, comboBoxes)) {
			return;
		}
		
		Collection<Object> selections = getSelectedItems(comboBoxes);
		
		for(int i = 0; i < comboBox.getModel().getSize(); ++i) {
			if(!selections.contains(comboBox.getItemAt(i))) {
				System.out.println(i);
				comboBox.setSelectedIndex(i);
				return;
			}
		}
		
		comboBox.setSelectedIndex(0);
	}
	
	public static <T> Collection<Object> getSelectedItems(
			Collection<? extends JComboBox<T>> comboBoxes) {
		Collection<Object> selections = new HashSet<Object>();
		for(JComboBox<?> comboBox : comboBoxes) {
			selections.add(comboBox.getSelectedItem());
		}
		return selections;
	}
	
	public static <T> boolean isSelectionUnique(
			JComboBox<T> comboBox,
			Collection<JComboBox<T>> comboBoxes) {
		if(comboBox.getModel().getSize() == 0) {
			return true;
		}
		for(JComboBox<?> currComboBox : comboBoxes) {
			if(currComboBox.getSelectedItem().equals(
					comboBox.getSelectedItem())) {
				return true;
			}
		}
		
		return false;
	}
}
