package dsp.main;

import dsp.db.setup.DBConnection;
import dsp.db.setup.DBPasswordManager;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hey!");
		
		new DBConnection().getConnection(
				new DBPasswordManager().getPassword());
	}
}

