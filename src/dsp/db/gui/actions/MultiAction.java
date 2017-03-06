package dsp.db.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class MultiAction extends AbstractAction {
	private static final long serialVersionUID = -3052912860229356476L;
	
	private Action[] actions;

	public MultiAction(Action... actions) {
		this.actions = actions;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(Action action : actions) {
			action.actionPerformed(e);
		}
	}
}
