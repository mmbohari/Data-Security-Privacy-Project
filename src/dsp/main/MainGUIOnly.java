package dsp.main;

import dsp.db.setup.ConnectionController;
import dsp.db.setup.GUILauncher;

/**
 * Main method for GUI only.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class MainGUIOnly {
	
	/**
	 * Main method for GUI only.
	 * 
	 * @param args Command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		GUILauncher.launchOnEDT(new ConnectionController());
	}
}
