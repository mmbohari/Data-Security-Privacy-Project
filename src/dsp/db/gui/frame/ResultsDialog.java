package dsp.db.gui.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

/**
 * The {@link ResultsDialog}.
 * 
 * TODO comment.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class ResultsDialog extends JDialog {
	private static final long serialVersionUID = 725393573617079589L;
	
	private final JPanel contentPanel = new JPanel();
	private JTable resultTable;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ResultsDialog dialog = new ResultsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ResultsDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.EAST);
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
		{
			resultTable = new JTable();
			JScrollPane resultTableScrollPane = new JScrollPane(resultTable);
			getContentPane().add(resultTableScrollPane, BorderLayout.CENTER);
		}
	}

	public JTable getResultTable() {
		return resultTable;
	}
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
}
