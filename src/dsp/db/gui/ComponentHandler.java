package dsp.db.gui;

import java.awt.Component;

/**
 * The {@link ComponentHandler}.
 * 
 * TODO comment
 * 
 * @author Ryan Conrad
 */
public abstract class ComponentHandler {
	private Component component;
	
	protected ComponentHandler(Component component) {
		this.component = component;
	}
	
	protected void initializeGUI() {
		setup();
		initializeListeners();
	}
	
	protected abstract void setup();
	
	protected abstract void initializeListeners();
	
	protected Component getComponent() {
		return this.component;
	}
}
