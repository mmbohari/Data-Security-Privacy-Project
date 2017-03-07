package dsp.main;

import dsp.db.setup.ConnectionController;
import dsp.db.setup.GUILauncher;

public class MainGUIOnly {
	public static void main(String[] args) {
		GUILauncher.launchOnEDT(new ConnectionController());
	}
}
