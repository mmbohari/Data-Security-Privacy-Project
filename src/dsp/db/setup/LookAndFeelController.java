package dsp.db.setup;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LookAndFeelController {
	public static final void initLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
