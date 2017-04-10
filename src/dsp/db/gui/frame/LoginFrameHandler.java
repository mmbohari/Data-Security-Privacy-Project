package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.frame.dev.DevDialog;
import dsp.db.gui.frame.dev.DevDialogHandler;
import dsp.db.query.DisorderlyQueryException;
import dsp.db.query.PreparedUserStatementGenerator;
import dsp.db.setup.ConnectionController;

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
				loginFrame.getRegUsernameField().getText();
				loginFrame.getRegPasswordField().getPassword();
			}
			
		});
		
		loginFrame.getDevModeButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DevDialog devDialog = new DevDialog();
				new DevDialogHandler(devDialog, connectionController);
				devDialog.setVisible(true);
			}
			
		});
	}

}
