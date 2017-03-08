package dsp.main;

import dsp.db.setup.GUILauncher;
import dsp.db.setup.ModelLauncher;

/**
 * Main method for model and GUI.
 * 
 * @author Ryan Conrad
 */
public class Main {
	
	/**
	 * Main method for model and GUI.
	 * 
	 * @param args Command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		ModelLauncher modelLauncher = ModelLauncher.getInstance();
		GUILauncher.launchOnEDT(modelLauncher.getConnectionController());
	}
}
