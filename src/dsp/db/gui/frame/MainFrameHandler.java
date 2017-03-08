package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dsp.db.gui.ComponentHandler;
import dsp.db.query.ResultSetController;
import dsp.db.setup.ConnectionController;

public class MainFrameHandler extends ComponentHandler {
	
	private MainFrame mainFrame;
	private ConnectionController connectionController;
	
	public MainFrameHandler(
			MainFrame mainFrame,
			ConnectionController connectionController) {
		
		super(mainFrame);
		
		this.mainFrame = mainFrame;
		this.connectionController = connectionController;
		
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
					ResultSetController rsc = connectionController
						.executeQuery("show tables");
					
					ResultsDialog rd = new ResultsDialog();
					new ResultsDialogHandler(rd,rsc);
					rd.setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mainFrame.getSelectButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SelectDialog sd = new SelectDialog();
				new SelectDialogHandler(sd, connectionController);
				sd.setVisible(true);
			}
		});
	}
}
