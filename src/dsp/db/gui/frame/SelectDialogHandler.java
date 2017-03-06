package dsp.db.gui.frame;

import java.sql.Connection;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.actions.CancelDialogAction;

public class SelectDialogHandler extends ComponentHandler {
	
	private SelectDialog selectDialog;
	private Connection connection;

	public SelectDialogHandler(
			SelectDialog selectDialog,
			Connection connection) {
		super(selectDialog);
		
		this.selectDialog = selectDialog;
		this.connection = connection;
		
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
	}

}
