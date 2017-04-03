package dsp.util;

import java.util.Collection;
import java.util.HashSet;

import javax.swing.JComboBox;

public class GUIUtils {
	
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
			Collection<JComboBox<T>> comboBoxes) {
		Collection<Object> selections = new HashSet<Object>();
		for(JComboBox<?> comboBox : comboBoxes) {
			selections.add(comboBox);
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
