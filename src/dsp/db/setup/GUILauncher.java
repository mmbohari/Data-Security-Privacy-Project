package dsp.db.setup;

import java.sql.Connection;

import dsp.db.gui.frame.MainFrame;
import dsp.db.gui.frame.MainFrameHandler;

public class GUILauncher {
	
	private GUILauncher(){}
	
	public static void launchOnEDT(Connection connection) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	launch(connection);
            }
        });
	}
	
	private static void launch(Connection connection) {
        MainFrame mainFrame = new MainFrame();
        new MainFrameHandler(mainFrame, connection);
        mainFrame.setVisible(true);
	}
}
