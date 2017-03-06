package dsp.db.setup;

import java.sql.Connection;

public class ModelLauncher {
	private static boolean hasLaunched = false;

	private static ModelLauncher modelLauncher;

	private Connection connection;
	
	public ModelLauncher() {
		connection = new DBConnection().getConnection(
				new DBPasswordManager().getPassword());
	}
	
	public synchronized static ModelLauncher getInstance() {
		if(!hasLaunched) {
			hasLaunched = true;
			
			modelLauncher = new ModelLauncher();
		}
		
		return modelLauncher;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
