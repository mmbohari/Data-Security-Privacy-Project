package dsp.db.gui.frame.dev;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class DevDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textField;
	private JButton executeQueryButton;
	private JButton executeUpdateButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DevDialog dialog = new DevDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DevDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {0};
		gbl_contentPanel.rowHeights = new int[] {0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblQuery = new JLabel("Query:");
			GridBagConstraints gbc_lblQuery = new GridBagConstraints();
			gbc_lblQuery.anchor = GridBagConstraints.WEST;
			gbc_lblQuery.insets = new Insets(0, 0, 5, 5);
			gbc_lblQuery.gridx = 0;
			gbc_lblQuery.gridy = 0;
			contentPanel.add(lblQuery, gbc_lblQuery);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 0;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				textField = new JTextArea();
				textField.setRows(6);
				scrollPane.setViewportView(textField);
				textField.setColumns(10);
			}
		}
		{
			executeQueryButton = new JButton("Query");
			GridBagConstraints gbc_btnExecute = new GridBagConstraints();
			gbc_btnExecute.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnExecute.insets = new Insets(0, 0, 5, 0);
			gbc_btnExecute.gridx = 2;
			gbc_btnExecute.gridy = 0;
			contentPanel.add(executeQueryButton, gbc_btnExecute);
		}
		{
			executeUpdateButton = new JButton("Update");
			GridBagConstraints gbc_executeUpdateButton = new GridBagConstraints();
			gbc_executeUpdateButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_executeUpdateButton.insets = new Insets(0, 0, 0, 5);
			gbc_executeUpdateButton.gridx = 2;
			gbc_executeUpdateButton.gridy = 1;
			contentPanel.add(executeUpdateButton, gbc_executeUpdateButton);
		}
	}

	public JTextArea getQueryTextField() {
		return textField;
	}
	public JButton getExecuteQueryButton() {
		return executeQueryButton;
	}
	public JButton getExecuteUpdateButton() {
		return executeUpdateButton;
	}
}
