package dsp.db.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * A {@link MultiAction} stores a series of actions and fires them
 * in order.
 * 
 * @author Ryan Conrad
 */
public class MultiAction extends AbstractAction {
	
	private static final long serialVersionUID = -3052912860229356476L;
	
	/**
	 * The actions to fire (in order).
	 */
	private Action[] actions;

	/**
	 * Constructs a new {@link MultiAction}.
	 * 
	 * @param actions The actions to fire (in order)
	 */
	public MultiAction(Action... actions) {
		
		// Store the actions
		this.actions = actions;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Fire the actions in order, with the same action event
		for(Action action : actions) {
			action.actionPerformed(e);
		}
	}
}
