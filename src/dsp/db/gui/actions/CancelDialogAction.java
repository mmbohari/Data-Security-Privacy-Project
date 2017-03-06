package dsp.db.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;

public class CancelDialogAction extends AbstractAction {
	private static final long serialVersionUID = -7903746493155254943L;
	
	JDialog dialog;
	
	public CancelDialogAction(JDialog dialog) {
		this.dialog = dialog;
		
		this.putValue(Action.NAME, "Cancel");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		dialog.setVisible(false);
	}
}
