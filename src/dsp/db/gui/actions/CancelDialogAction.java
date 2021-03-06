package dsp.db.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;

/**
 * A {@link CancelDialogAction} cancels a dialog by setting it to
 * be invisible.
 * 
 * @author Ryan Conrad
 */
public class CancelDialogAction extends AbstractAction {
	
	private static final long serialVersionUID = -7903746493155254943L;
	
	/**
	 * The dialog.
	 */
	private JDialog dialog;
	
	/**
	 * Constructs a new {@link CancelDialogAction}.
	 * 
	 * @param dialog The dialog
	 */
	public CancelDialogAction(JDialog dialog) {
		
		// Store the dialog
		this.dialog = dialog;
		
		// Set the name
		this.putValue(Action.NAME, "Cancel");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Make the dialog invisible
		dialog.setVisible(false);
	}
}
