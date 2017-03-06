package dsp.main;

import dsp.db.setup.GUILauncher;
import dsp.db.setup.ModelLauncher;

public class Main {
	public static void main(String[] args) {
		ModelLauncher modelLauncher = ModelLauncher.getInstance();
		GUILauncher.launchOnEDT(modelLauncher.getConnection());
	}
}
