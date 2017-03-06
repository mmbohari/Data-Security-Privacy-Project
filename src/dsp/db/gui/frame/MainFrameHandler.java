package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dsp.db.gui.ComponentHandler;

public class MainFrameHandler extends ComponentHandler {
	
	private MainFrame mainFrame;
	private Connection connection;
	
	public MainFrameHandler(
			MainFrame mainFrame,
			Connection connection) {
		
		super(mainFrame);
		
		this.mainFrame = mainFrame;
		this.connection = connection;
		
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
					ResultSet rs = connection
						.prepareStatement("show tables")
						.executeQuery();
					
					ResultsDialog rd = new ResultsDialog();
					new ResultsDialogHandler(rd,rs);
					rd.setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
