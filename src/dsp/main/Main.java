package dsp.main;

import dsp.db.gui.frame.MainFrame;
import dsp.db.gui.frame.MainFrameHandler;
import dsp.db.setup.DBConnection;
import dsp.db.setup.DBPasswordManager;

public class Main {
	
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame();
                new MainFrameHandler(mainFrame);
                mainFrame.setVisible(true);
                
        		System.out.println("Hey!");
        		
        		new DBConnection().getConnection(
        				new DBPasswordManager().getPassword());
            }
        });
	}
}