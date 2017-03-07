package dsp.main;

import dsp.db.connection.BlankConnection;
import dsp.db.setup.GUILauncher;
import dsp.db.setup.ModelLauncher;

public class MainGUIOnly {
	public static void main(String[] args) {
		GUILauncher.launchOnEDT(new BlankConnection());
	}
}
