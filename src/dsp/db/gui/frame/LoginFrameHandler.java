package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dsp.db.gui.ComponentHandler;
import dsp.db.query.DisorderlyQueryException;
import dsp.db.query.PreparedProcedureStatementGenerator;
import dsp.db.query.PreparedUserStatementGenerator;
import dsp.db.setup.ConnectionController;

public class LoginFrameHandler extends ComponentHandler {
	
	public static final String DATABASE_NAME = "Healthcare";

	private LoginFrame loginFrame;
	private ConnectionController connectionController;
	
	public LoginFrameHandler(LoginFrame loginFrame, ConnectionController connectionController) {
		super(loginFrame);
		
		this.loginFrame = loginFrame;
		this.connectionController = connectionController;
		
		initializeGUI();
	}

	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeListeners() {
		loginFrame.getLoginButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(connectionController.connect(
						DATABASE_NAME,
						loginFrame.getLoginUsernameField().getText(),
						new String(loginFrame.getLoginPasswordField().getPassword())))
				{
					loginFrame.dispose();
					
					MainFrame mainFrame = new MainFrame();
					new MainFrameHandler(mainFrame, connectionController);
					mainFrame.setVisible(true);
				}
			}
			
		});
		loginFrame.getRegisterButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PreparedUserStatementGenerator gen = new PreparedUserStatementGenerator(
						connectionController);
				
				PreparedProcedureStatementGenerator gen2 = new PreparedProcedureStatementGenerator(connectionController);
				
				try {
					gen.createUser();
					gen.ifNotExists();
					gen.username(loginFrame.getRegUsernameField().getText());
					gen.identifiedBy(loginFrame.getRegPasswordField().getPassword());
					int retValue = gen.executeUpdate();
					System.out.println(retValue);
					
					gen2.call("Healthcare.give_doctor_to_user");
					gen2.params("'" + loginFrame.getRegUsernameField().getText() + "'");
					gen2.end();
					int retValue2 = gen2.executeUpdate();
					System.out.println(retValue2);

					JOptionPane.showMessageDialog(
							null,
							"User " + loginFrame.getRegUsernameField().getText()
							+ " has been registered (as a doctor)!",
							"Success!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (DisorderlyQueryException | SQLException e) {
					JOptionPane.showMessageDialog(
							null,
							"Bad SQL query.",
							"Error!",
							JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
				// TODO Authentication
			}
			
		});
	}

}
