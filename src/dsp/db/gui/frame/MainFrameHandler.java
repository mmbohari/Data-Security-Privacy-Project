package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import dsp.db.gui.ComponentHandler;
import dsp.db.setup.DBConnection;
import dsp.db.setup.DBPasswordManager;

public class MainFrameHandler extends ComponentHandler {
	
	private MainFrame mainFrame;
	
	public MainFrameHandler(MainFrame mainFrame) {
		
		super(mainFrame);
		
		this.mainFrame = mainFrame;
		
		initializeGUI();
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeListeners() {
		mainFrame.getShowTablesButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSet rs = new DBConnection().getConnection(
							new DBPasswordManager().getPassword())
					.prepareStatement("show tables")
					.executeQuery();
					
					ResultsDialog rd = new ResultsDialog();
					ResultsDialogHandler rdh = new ResultsDialogHandler(rd,rs);
					rd.setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
