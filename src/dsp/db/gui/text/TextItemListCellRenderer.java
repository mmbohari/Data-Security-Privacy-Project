package dsp.db.gui.text;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class TextItemListCellRenderer
		extends JLabel
		implements ListCellRenderer<TextItem> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2533942368159312026L;

	private DefaultListCellRenderer renderer;
	
	public TextItemListCellRenderer() {
		renderer = new DefaultListCellRenderer();
        setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(
			JList<? extends TextItem> list, TextItem value, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		Component component = renderer.getListCellRendererComponent(
				list, value, index, isSelected, cellHasFocus);
		
		if(component instanceof JLabel) {
			JLabel label = (JLabel) component;
			label.setText(value.getText());
		}
		
		return component;
		 
	}
}
