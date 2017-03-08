package dsp.db.setup;

/**
 * A {@link ModelLauncher} is a singleton that contains a
 * {@link ConnectionController}.
 * 
 * @author Ryan Conrad
 */
public class ModelLauncher {
	
	/**
	 * Boolean that prevents multiple instances.
	 */
	private static boolean hasLaunched = false;
	
	/**
	 * The singleton object.
	 */
	private static ModelLauncher modelLauncher;
	
	/**
	 * The connection controller.
	 */
	private final ConnectionController connectionController;
	
	/**
	 * Creates a new {@link ModelLauncher}.
	 */
	public ModelLauncher() {
		
		// Create the controller and connect automatically
		connectionController = new ConnectionController();
		connectionController.connect(new DBPasswordManager().getPassword());
	}
	
	/**
	 * Returns the model launcher instance.
	 * 
	 * @return The model launcher instance
	 */
	public synchronized static ModelLauncher getInstance() {
		// Only create the singleton if it hasn't been created yet
		if(!hasLaunched) {
			hasLaunched = true;
			modelLauncher = new ModelLauncher();
		}
		
		return modelLauncher;
	}
	
	/**
	 * Returns the connection controller.
	 * 
	 * @return the connection controller
	 */
	public ConnectionController getConnectionController() {
		return connectionController;
	}
}
