package dsp.db.gui.frame.dev;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.frame.ResultsDialog;
import dsp.db.gui.frame.ResultsDialogHandler;
import dsp.db.query.ResultSetController;
import dsp.db.setup.ConnectionController;
import dsp.util.StringUtils;

public class DevDialogHandler extends ComponentHandler {
	
	private DevDialog devDialog;
	private ConnectionController connectionController;

	public DevDialogHandler(DevDialog devDialog, ConnectionController connectionController) {
		super(devDialog);

		this.devDialog = devDialog;
		this.connectionController = connectionController;
		
		initializeGUI();
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeListeners() {
		devDialog.getExecuteQueryButton().addActionListener(executeQueryListener);
		devDialog.getExecuteUpdateButton().addActionListener(executeUpdateListener);
	}

	private ActionListener executeQueryListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				ResultSetController rsc = connectionController
					.executeQuery(devDialog.getQueryTextField().getText());
				
				ResultsDialog rd = new ResultsDialog();
				new ResultsDialogHandler(rd,rsc);
				rd.setVisible(true);
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						devDialog,
						StringUtils.splitLines(e.getMessage(), 36),
						"SQL Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
	};

	private ActionListener executeUpdateListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				connectionController
					.execute(devDialog.getQueryTextField().getText());
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						devDialog,
						StringUtils.splitLines(e.getMessage(), 36),
						"SQL Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
	};
}
