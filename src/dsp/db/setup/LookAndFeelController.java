package dsp.db.setup;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The {@link LookAndFeelController} contains a method for
 * initializing the look and feel.
 * 
 * @author Ryan Conrad
 */
public class LookAndFeelController {
	
	/**
	 * Initializes the look and feel. If an exception occurs,
	 * the stack trace is printed.
	 */
	public static final void initLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
