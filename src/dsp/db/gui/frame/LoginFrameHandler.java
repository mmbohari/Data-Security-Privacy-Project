package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dsp.db.gui.ComponentHandler;
import dsp.db.query.DisorderlyQueryException;
import dsp.db.query.PreparedUserStatementGenerator;
import dsp.db.setup.ConnectionController;
import dsp.util.StringUtils;

public class LoginFrameHandler extends ComponentHandler {

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
				loginFrame.getLoginUsernameField().getText();
				loginFrame.getLoginPasswordField().getPassword();
				
				// TODO Authentication
				loginFrame.dispose();
				
				MainFrame mainFrame = new MainFrame();
				new MainFrameHandler(mainFrame, connectionController);
				mainFrame.setVisible(true);
			}
			
		});
		loginFrame.getRegisterButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PreparedUserStatementGenerator gen = new PreparedUserStatementGenerator(
						connectionController);
				
				try {
					gen.createUser(loginFrame.getRegUsernameField().getText());
					gen.identifiedBy(loginFrame.getRegPasswordField().getPassword());
					gen.executeUpdate();
					

					JOptionPane.showMessageDialog(
							null,
							"User " + loginFrame.getRegUsernameField().getText()
							+ " has been registered! Wait for the database administrator"
							+ " to grant login access.",
							"Success!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (DisorderlyQueryException | SQLException e) {
					JOptionPane.showMessageDialog(
							null,
							"Bad SQL query.",
							"Error!",
							JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Authentication
			}
			
		});
		loginFrame.getRegisterButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loginFrame.getRegUsernameField().getText();
				loginFrame.getRegPasswordField().getPassword();
			}
			
		});
	}

}
