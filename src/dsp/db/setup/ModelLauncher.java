package dsp.db.setup;

public class ModelLauncher {
	private static boolean hasLaunched = false;

	private static ModelLauncher modelLauncher;

	private ConnectionController connectionController;
	
	public ModelLauncher() {
		connectionController = new ConnectionController();
		connectionController.connect(new DBPasswordManager().getPassword());
	}
	
	public synchronized static ModelLauncher getInstance() {
		if(!hasLaunched) {
			hasLaunched = true;
			
			modelLauncher = new ModelLauncher();
		}
		
		return modelLauncher;
	}
	
	public ConnectionController getConnectionController() {
		return connectionController;
	}
}
