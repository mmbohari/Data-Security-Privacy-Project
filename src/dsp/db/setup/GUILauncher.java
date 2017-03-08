package dsp.db.setup;

import dsp.db.gui.frame.MainFrame;
import dsp.db.gui.frame.MainFrameHandler;

/**
 * A {@link GUILauncher} initializes the look and feel and
 * initializes a {@link MainFrame} and its {@link MainFrameHandler}.
 * 
 * @author Ryan Conrad
 */
public class GUILauncher {
	
	/**
	 * Prevent instantiation.
	 */
	private GUILauncher(){}
	
	/**
	 * Launches the GUI on the EDT, taking in a connection controller
	 * since the GUI handlers require it.
	 * 
	 * @param connectionController The connection controller
	 */
	public static void launchOnEDT(
			ConnectionController connectionController) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	launch(connectionController);
            }
        });
	}

	/**
	 * Launches the GUI, taking in a connection controller
	 * since the GUI handlers require it.
	 * 
	 * @param connectionController The connection controller
	 */
	private static void launch(
			ConnectionController connectionController) {
		
		// Initialize the look and feel
		LookAndFeelController.initLookAndFeel();
		
		// Initialize the main frame and its handler, and show the frame
        MainFrame mainFrame = new MainFrame();
        new MainFrameHandler(mainFrame, connectionController);
        mainFrame.setVisible(true);
	}
}
