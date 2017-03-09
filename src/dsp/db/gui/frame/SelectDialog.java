package dsp.db.gui.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

/**
 * The {@link SelectDialog}.
 * 
 * TODO comment.
 * 
 * @author Ryan Conrad
 */
public class SelectDialog extends JDialog {
	private static final long serialVersionUID = -4028408695149958085L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField selectTextField;
	private JTextField fromTextField;
	private JTextField whereAttributeTextField;
	private JLabel selectLabel;
	private JLabel fromLabel;
	private JLabel whereLabel;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel whereEqualsLabel;
	private JTextField whereValueTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectDialog dialog = new SelectDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel selectGridPanel = new JPanel();
			contentPanel.add(selectGridPanel);
			GridBagLayout gbl_selectGridPanel = new GridBagLayout();
			gbl_selectGridPanel.columnWidths = new int[] {0};
			gbl_selectGridPanel.rowHeights = new int[] {0};
			gbl_selectGridPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0};
			gbl_selectGridPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
			selectGridPanel.setLayout(gbl_selectGridPanel);
			{
				selectLabel = new JLabel("SELECT");
				GridBagConstraints gbc_selectLabel = new GridBagConstraints();
				gbc_selectLabel.anchor = GridBagConstraints.WEST;
				gbc_selectLabel.insets = new Insets(0, 0, 5, 5);
				gbc_selectLabel.gridx = 0;
				gbc_selectLabel.gridy = 0;
				selectGridPanel.add(selectLabel, gbc_selectLabel);
			}
			{
				selectTextField = new JTextField();
				GridBagConstraints gbc_selectTextField = new GridBagConstraints();
				gbc_selectTextField.gridwidth = 3;
				gbc_selectTextField.insets = new Insets(0, 0, 5, 0);
				gbc_selectTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_selectTextField.gridx = 1;
				gbc_selectTextField.gridy = 0;
				selectGridPanel.add(selectTextField, gbc_selectTextField);
				selectTextField.setColumns(10);
			}
			{
				fromLabel = new JLabel("FROM");
				GridBagConstraints gbc_fromLabel = new GridBagConstraints();
				gbc_fromLabel.anchor = GridBagConstraints.WEST;
				gbc_fromLabel.insets = new Insets(0, 0, 5, 5);
				gbc_fromLabel.gridx = 0;
				gbc_fromLabel.gridy = 1;
				selectGridPanel.add(fromLabel, gbc_fromLabel);
			}
			{
				fromTextField = new JTextField();
				GridBagConstraints gbc_fromTextField = new GridBagConstraints();
				gbc_fromTextField.gridwidth = 3;
				gbc_fromTextField.insets = new Insets(0, 0, 5, 0);
				gbc_fromTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_fromTextField.gridx = 1;
				gbc_fromTextField.gridy = 1;
				selectGridPanel.add(fromTextField, gbc_fromTextField);
				fromTextField.setColumns(10);
			}
			{
				whereLabel = new JLabel("WHERE");
				GridBagConstraints gbc_whereLabel = new GridBagConstraints();
				gbc_whereLabel.anchor = GridBagConstraints.WEST;
				gbc_whereLabel.insets = new Insets(0, 0, 0, 5);
				gbc_whereLabel.gridx = 0;
				gbc_whereLabel.gridy = 2;
				selectGridPanel.add(whereLabel, gbc_whereLabel);
			}
			{
				whereAttributeTextField = new JTextField();
				GridBagConstraints gbc_whereAttributeTextField = new GridBagConstraints();
				gbc_whereAttributeTextField.insets = new Insets(0, 0, 0, 5);
				gbc_whereAttributeTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_whereAttributeTextField.gridx = 1;
				gbc_whereAttributeTextField.gridy = 2;
				selectGridPanel.add(whereAttributeTextField, gbc_whereAttributeTextField);
				whereAttributeTextField.setColumns(10);
			}
			{
				whereEqualsLabel = new JLabel("=");
				GridBagConstraints gbc_whereEqualsLabel = new GridBagConstraints();
				gbc_whereEqualsLabel.insets = new Insets(0, 0, 0, 5);
				gbc_whereEqualsLabel.gridx = 2;
				gbc_whereEqualsLabel.gridy = 2;
				selectGridPanel.add(whereEqualsLabel, gbc_whereEqualsLabel);
			}
			{
				whereValueTextField = new JTextField();
				GridBagConstraints gbc_whereValueTextField = new GridBagConstraints();
				gbc_whereValueTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_whereValueTextField.gridx = 3;
				gbc_whereValueTextField.gridy = 2;
				selectGridPanel.add(whereValueTextField, gbc_whereValueTextField);
				whereValueTextField.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JLabel getSelectLabel() {
		return selectLabel;
	}
	public JTextField getSelectTextField() {
		return selectTextField;
	}
	public JLabel getFromLabel() {
		return fromLabel;
	}
	public JTextField getFromTextField() {
		return fromTextField;
	}
	public JLabel getWhereLabel() {
		return whereLabel;
	}
	public JTextField getWhereAttributeTextField() {
		return whereAttributeTextField;
	}
	public JTextField getWhereValueTextField() {
		return whereValueTextField;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
}
