package dsp.db.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;

public class OkDialogAction extends AbstractAction {
	private static final long serialVersionUID = -3625214096192001377L;
	
	JDialog dialog;
	
	public OkDialogAction(JDialog dialog) {
		this.dialog = dialog;
		
		this.putValue(Action.NAME, "OK");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dialog.setVisible(false);
	}
}
