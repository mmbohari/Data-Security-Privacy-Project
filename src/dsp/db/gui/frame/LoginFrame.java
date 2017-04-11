package dsp.db.gui.frame;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * A {@link LoginFrame}.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4511767585977326185L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField loginUsernameField;
	private JPasswordField loginPasswordField;
	private JTextField regUsernameField;
	private JPasswordField regPasswordField;
	private JButton loginButton;
	private JButton registerButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginFrame dialog = new LoginFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {0};
		gbl_contentPanel.rowHeights = new int[] {0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{1.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel registerPanel = new JPanel();
			GridBagConstraints gbc_registerPanel = new GridBagConstraints();
			gbc_registerPanel.anchor = GridBagConstraints.WEST;
			gbc_registerPanel.fill = GridBagConstraints.VERTICAL;
			gbc_registerPanel.insets = new Insets(0, 0, 0, 5);
			gbc_registerPanel.gridx = 2;
			gbc_registerPanel.gridy = 0;
			contentPanel.add(registerPanel, gbc_registerPanel);
			GridBagLayout gbl_registerPanel = new GridBagLayout();
			gbl_registerPanel.columnWidths = new int[] {0};
			gbl_registerPanel.rowHeights = new int[] {0};
			gbl_registerPanel.columnWeights = new double[]{0.0, 1.0};
			gbl_registerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
			registerPanel.setLayout(gbl_registerPanel);
			{
				JLabel registerLabel = new JLabel("Register");
				GridBagConstraints gbc_registerLabel = new GridBagConstraints();
				gbc_registerLabel.insets = new Insets(0, 0, 5, 0);
				gbc_registerLabel.gridwidth = 2;
				gbc_registerLabel.gridx = 0;
				gbc_registerLabel.gridy = 0;
				registerPanel.add(registerLabel, gbc_registerLabel);
			}
			{
				JLabel regUsernameLabel = new JLabel("Username");
				GridBagConstraints gbc_regUsernameLabel = new GridBagConstraints();
				gbc_regUsernameLabel.insets = new Insets(0, 0, 5, 5);
				gbc_regUsernameLabel.anchor = GridBagConstraints.EAST;
				gbc_regUsernameLabel.gridx = 0;
				gbc_regUsernameLabel.gridy = 1;
				registerPanel.add(regUsernameLabel, gbc_regUsernameLabel);
			}
			{
				regUsernameField = new JTextField();
				GridBagConstraints gbc_regUsernameField = new GridBagConstraints();
				gbc_regUsernameField.insets = new Insets(0, 0, 5, 5);
				gbc_regUsernameField.fill = GridBagConstraints.HORIZONTAL;
				gbc_regUsernameField.gridx = 1;
				gbc_regUsernameField.gridy = 1;
				registerPanel.add(regUsernameField, gbc_regUsernameField);
				regUsernameField.setColumns(10);
			}
			{
				JLabel regPasswordLabel = new JLabel("Password");
				GridBagConstraints gbc_regPasswordLabel = new GridBagConstraints();
				gbc_regPasswordLabel.insets = new Insets(0, 0, 5, 5);
				gbc_regPasswordLabel.anchor = GridBagConstraints.EAST;
				gbc_regPasswordLabel.gridx = 0;
				gbc_regPasswordLabel.gridy = 2;
				registerPanel.add(regPasswordLabel, gbc_regPasswordLabel);
			}
			{
				regPasswordField = new JPasswordField();
				GridBagConstraints gbc_regPasswordField = new GridBagConstraints();
				gbc_regPasswordField.insets = new Insets(0, 0, 5, 5);
				gbc_regPasswordField.fill = GridBagConstraints.HORIZONTAL;
				gbc_regPasswordField.gridx = 1;
				gbc_regPasswordField.gridy = 2;
				registerPanel.add(regPasswordField, gbc_regPasswordField);
				regPasswordField.setColumns(10);
			}
			{
				registerButton = new JButton("Register");
				GridBagConstraints gbc_registerButton = new GridBagConstraints();
				gbc_registerButton.gridwidth = 2;
				gbc_registerButton.insets = new Insets(0, 0, 0, 5);
				gbc_registerButton.gridx = 0;
				gbc_registerButton.gridy = 3;
				registerPanel.add(registerButton, gbc_registerButton);
			}
		}
		{
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.fill = GridBagConstraints.BOTH;
			gbc_separator.insets = new Insets(0, 10, 0, 10);
			gbc_separator.gridx = 1;
			gbc_separator.gridy = 0;
			contentPanel.add(separator, gbc_separator);
		}
		{
			JPanel loginPanel = new JPanel();
			GridBagConstraints gbc_loginPanel = new GridBagConstraints();
			gbc_loginPanel.anchor = GridBagConstraints.WEST;
			gbc_loginPanel.fill = GridBagConstraints.VERTICAL;
			gbc_loginPanel.gridx = 0;
			gbc_loginPanel.gridy = 0;
			contentPanel.add(loginPanel, gbc_loginPanel);
			GridBagLayout gbl_loginPanel = new GridBagLayout();
			gbl_loginPanel.columnWidths = new int[] {0};
			gbl_loginPanel.rowHeights = new int[] {0};
			gbl_loginPanel.columnWeights = new double[]{0.0, 0.0};
			gbl_loginPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
			loginPanel.setLayout(gbl_loginPanel);
			{
				JLabel loginLabel = new JLabel("Login");
				GridBagConstraints gbc_loginLabel = new GridBagConstraints();
				gbc_loginLabel.gridwidth = 2;
				gbc_loginLabel.insets = new Insets(0, 0, 5, 5);
				gbc_loginLabel.gridx = 0;
				gbc_loginLabel.gridy = 0;
				loginPanel.add(loginLabel, gbc_loginLabel);
			}
			{
				JLabel loginUsernameLabel = new JLabel("Username");
				GridBagConstraints gbc_loginUsernameLabel = new GridBagConstraints();
				gbc_loginUsernameLabel.anchor = GridBagConstraints.WEST;
				gbc_loginUsernameLabel.insets = new Insets(0, 0, 5, 5);
				gbc_loginUsernameLabel.gridx = 0;
				gbc_loginUsernameLabel.gridy = 1;
				loginPanel.add(loginUsernameLabel, gbc_loginUsernameLabel);
			}
			{
				loginUsernameField = new JTextField();
				GridBagConstraints gbc_loginUsernameField = new GridBagConstraints();
				gbc_loginUsernameField.insets = new Insets(0, 0, 5, 5);
				gbc_loginUsernameField.anchor = GridBagConstraints.NORTHWEST;
				gbc_loginUsernameField.gridx = 1;
				gbc_loginUsernameField.gridy = 1;
				loginPanel.add(loginUsernameField, gbc_loginUsernameField);
				loginUsernameField.setColumns(10);
			}
			{
				JLabel loginPasswordLabel = new JLabel("Password");
				GridBagConstraints gbc_loginPasswordLabel = new GridBagConstraints();
				gbc_loginPasswordLabel.anchor = GridBagConstraints.WEST;
				gbc_loginPasswordLabel.insets = new Insets(0, 0, 5, 5);
				gbc_loginPasswordLabel.gridx = 0;
				gbc_loginPasswordLabel.gridy = 2;
				loginPanel.add(loginPasswordLabel, gbc_loginPasswordLabel);
			}
			{
				loginPasswordField = new JPasswordField();
				GridBagConstraints gbc_loginPasswordField = new GridBagConstraints();
				gbc_loginPasswordField.insets = new Insets(0, 0, 5, 5);
				gbc_loginPasswordField.anchor = GridBagConstraints.NORTHWEST;
				gbc_loginPasswordField.gridx = 1;
				gbc_loginPasswordField.gridy = 2;
				loginPanel.add(loginPasswordField, gbc_loginPasswordField);
				loginPasswordField.setColumns(10);
			}
			{
				loginButton = new JButton("Login");
				GridBagConstraints gbc_loginButton = new GridBagConstraints();
				gbc_loginButton.gridwidth = 2;
				gbc_loginButton.insets = new Insets(0, 0, 0, 5);
				gbc_loginButton.gridx = 0;
				gbc_loginButton.gridy = 3;
				loginPanel.add(loginButton, gbc_loginButton);
			}
		}
	}

	public JButton getLoginButton() {
		return loginButton;
	}
	public JButton getRegisterButton() {
		return registerButton;
	}
	public JTextField getLoginUsernameField() {
		return loginUsernameField;
	}
	public JPasswordField getLoginPasswordField() {
		return loginPasswordField;
	}
	public JTextField getRegUsernameField() {
		return regUsernameField;
	}
	public JPasswordField getRegPasswordField() {
		return regPasswordField;
	}
}
