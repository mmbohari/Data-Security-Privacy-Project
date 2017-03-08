package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.actions.CancelDialogAction;
import dsp.db.query.DisorderlyQueryException;
import dsp.db.query.PreparedSelectStatementGenerator;
import dsp.db.query.ResultSetController;
import dsp.db.setup.ConnectionController;

public class SelectDialogHandler extends ComponentHandler {
	
	private SelectDialog selectDialog;
	private ConnectionController connectionController;

	public SelectDialogHandler(
			SelectDialog selectDialog,
			ConnectionController connectionController) {
		super(selectDialog);
		
		this.selectDialog = selectDialog;
		this.connectionController = connectionController;
		
		initializeGUI();
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeListeners() {
		selectDialog.getCancelButton().setAction(
				new CancelDialogAction(
						selectDialog));
		selectDialog.getOkButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSetController rsc = new PreparedSelectStatementGenerator(
							connectionController)
						.select(selectDialog.getSelectTextField().getText())
						.from(selectDialog.getFromTextField().getText())
						.where(selectDialog.getWhereTextField().getText())
						.executeQuery();
					
					ResultsDialog rd = new ResultsDialog();
					new ResultsDialogHandler(rd,rsc);
					rd.setVisible(true);
					
				} catch (SQLException | DisorderlyQueryException e) {
					e.printStackTrace();
				}
			}
			
		});
	}

}
