package dsp.db.setup;

import dsp.db.gui.frame.MainFrame;
import dsp.db.gui.frame.MainFrameHandler;

public class GUILauncher {
	
	private GUILauncher(){}
	
	public static void launchOnEDT(ConnectionController connectionController) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	launch(connectionController);
            }
        });
	}
	
	private static void launch(ConnectionController connectionController) {
		LookAndFeelController.initLookAndFeel();
		
        MainFrame mainFrame = new MainFrame();
        new MainFrameHandler(mainFrame, connectionController);
        mainFrame.setVisible(true);
	}
}
