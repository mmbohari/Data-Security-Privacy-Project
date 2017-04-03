package dsp.db.gui.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dsp.db.gui.text.TextItem;
import dsp.db.gui.text.TextItemListCellRenderer;

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
	private List<JComboBox<TextItem>> selectComboBoxes;
	private JComboBox<TextItem> fromComboBox;
	private JTextField whereAttributeTextField;
	private JLabel selectLabel;
	private JLabel fromLabel;
	private JLabel whereLabel;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel whereEqualsLabel;
	private JTextField whereValueTextField;
	private JButton addSelectButton;
	private JPanel selectComboBoxPanel;

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
			gbl_selectGridPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0};
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
				selectComboBoxPanel = new JPanel();
				GridBagConstraints gbc_selectComboBoxPanel = new GridBagConstraints();
				gbc_selectComboBoxPanel.fill = GridBagConstraints.BOTH;
				gbc_selectComboBoxPanel.gridwidth = 3;
				gbc_selectComboBoxPanel.insets = new Insets(0, 0, 5, 5);
				gbc_selectComboBoxPanel.gridx = 1;
				gbc_selectComboBoxPanel.gridy = 0;
				selectGridPanel.add(selectComboBoxPanel, gbc_selectComboBoxPanel);
				selectComboBoxPanel.setLayout(new BoxLayout(selectComboBoxPanel, BoxLayout.Y_AXIS));
				{
					selectComboBoxes = new ArrayList<JComboBox<TextItem>>();
					addNewSelectComboBox();
				}
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
				fromComboBox = new JComboBox<TextItem>();
				GridBagConstraints gbc_fromTextField = new GridBagConstraints();
				gbc_fromTextField.gridwidth = 3;
				gbc_fromTextField.insets = new Insets(0, 0, 5, 5);
				gbc_fromTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_fromTextField.gridx = 1;
				gbc_fromTextField.gridy = 1;
				selectGridPanel.add(fromComboBox, gbc_fromTextField);
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
				addSelectButton = new JButton("+");
				GridBagConstraints gbc_btnAddSelect = new GridBagConstraints();
				gbc_btnAddSelect.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnAddSelect.insets = new Insets(0, 0, 5, 0);
				gbc_btnAddSelect.gridx = 4;
				gbc_btnAddSelect.gridy = 0;
				selectGridPanel.add(addSelectButton, gbc_btnAddSelect);
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
				gbc_whereValueTextField.insets = new Insets(0, 0, 0, 5);
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
	
	public void reinitSelectComboBoxes() {
		selectComboBoxPanel.removeAll();
		selectComboBoxes.clear();
		addNewSelectComboBox();
	}
	
	public void addNewSelectComboBox() {
		JComboBox<TextItem> comboBox = new JComboBox<TextItem>();
		comboBox.setRenderer(new TextItemListCellRenderer());
		selectComboBoxPanel.add(comboBox);
		selectComboBoxes.add(comboBox);
		
		revalidate();
		repaint();
	}

	public JLabel getSelectLabel() {
		return selectLabel;
	}
	public List<JComboBox<TextItem>> getSelectComboBoxes() {
		return selectComboBoxes;
	}
	public JButton getAddSelectButton() {
		return addSelectButton;
	}
	public JLabel getFromLabel() {
		return fromLabel;
	}
	public JComboBox<TextItem> getFromComboBox() {
		return fromComboBox;
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
