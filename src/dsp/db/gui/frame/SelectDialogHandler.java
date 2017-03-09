package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.actions.CancelDialogAction;
import dsp.db.query.DisorderlyQueryException;
import dsp.db.query.PreparedSelectStatementGenerator;
import dsp.db.query.ResultSetController;
import dsp.db.setup.ConnectionController;

/**
 * The {@link SelectDialogHandler}.
 * 
 * TODO comment.
 * 
 * @author Ryan Conrad
 */
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
		selectDialog.getCancelButton().setAction(
				new CancelDialogAction(
						selectDialog));
	}

	@Override
	protected void initializeListeners() {
		selectDialog.getOkButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSetController rsc = new PreparedSelectStatementGenerator(
							connectionController)
						.select(selectDialog.getSelectTextField().getText())
						.from(selectDialog.getFromTextField().getText())
						.where(selectDialog.getWhereAttributeTextField().getText(),
								selectDialog.getWhereValueTextField().getText())
						.executeQuery();
					
					ResultsDialog rd = new ResultsDialog();
					new ResultsDialogHandler(rd,rsc);
					rd.setVisible(true);
					
				} catch (SQLException | DisorderlyQueryException e) {
					// Show an error message
					JOptionPane.showMessageDialog(
							null,
							"Bad SQL query.",
							"Error!",
							JOptionPane.ERROR_MESSAGE);
					
					// TODO auditing
					
					e.printStackTrace();
				}
			}
			
		});
	}

}
