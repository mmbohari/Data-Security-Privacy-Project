package dsp.db.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;

/**
 * A {@link CancelDialogAction} confirms a dialog by setting it to
 * be invisible.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class OkDialogAction extends AbstractAction {
	
	private static final long serialVersionUID = -3625214096192001377L;
	
	/**
	 * The dialog.
	 */
	private JDialog dialog;
	
	/**
	 * Constructs a new {@link OkDialogAction}.
	 * 
	 * @param dialog The dialog
	 */
	public OkDialogAction(JDialog dialog) {
		
		// Store the dialog
		this.dialog = dialog;
		
		// Set the name
		this.putValue(Action.NAME, "OK");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// Make the dialog invisible
		dialog.setVisible(false);
	}
}
