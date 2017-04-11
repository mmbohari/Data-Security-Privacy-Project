package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.actions.CancelDialogAction;
import dsp.db.gui.library.HidableJComboBox;
import dsp.db.gui.text.TextItem;
import dsp.db.gui.text.TextItemListCellRenderer;
import dsp.db.query.DisorderlyQueryException;
import dsp.db.query.PreparedSelectStatementGenerator;
import dsp.db.query.ResultSetController;
import dsp.db.setup.ConnectionController;
import dsp.db.table.DBAttribute;
import dsp.db.table.DBTable;
import dsp.db.table.set.DBTables;
import dsp.util.GUIUtils;
import dsp.util.StringUtils;

/**
 * The {@link SelectDialogHandler}.
 * 
 * TODO comment.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class SelectDialogHandler extends ComponentHandler {
	
	private SelectDialog selectDialog;
	private ConnectionController connectionController;

	public SelectDialogHandler(
			SelectDialog selectDialog,
			ConnectionController connectionController) {
		super(selectDialog);
		
		this.selectDialog = selectDialog;
		this.connectionController = connectionController;
		
		initializeGUI();
	}

	@Override
	protected void setup() {

		addListenerToSelectComboBox(
				selectDialog.reinitSelectComboBoxes());
		
		selectDialog.getFromComboBox().setRenderer(
				new TextItemListCellRenderer());

		
		if("doctor".equals(connectionController.getRole())) {
			for(DBTable table : DBTables.getDoctorTables()) {
				selectDialog.getFromComboBox().addItem(table);
			}
		}
		else {
			for(DBTable table : DBTables.getTables()) {
				selectDialog.getFromComboBox().addItem(table);
			}
		}
		
		refreshAttributes();
		
		selectDialog.getCancelButton().setAction(
				new CancelDialogAction(
						selectDialog));
		
		selectDialog.getAddSelectButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HidableJComboBox<TextItem> comboBox =
						selectDialog.addNewSelectComboBox();
				refreshAttributes();
				GUIUtils.hideDuplicateItems(
						selectDialog.getSelectComboBoxes());
				addListenerToSelectComboBox(comboBox);
			}
		});
	}

	@Override
	protected void initializeListeners() {
		selectDialog.getOkButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSetController rsc = new PreparedSelectStatementGenerator(
							connectionController)
						.select(getCommaSeparatedSelect())
						.from(selectDialog.getFromComboBox().getSelectedItem().toString())
						.where(selectDialog.getWhereAttributeTextField().getText(),
								selectDialog.getWhereValueTextField().getText())
						.executeQuery();
					
					ResultsDialog rd = new ResultsDialog();
					new ResultsDialogHandler(rd,rsc);
					rd.setVisible(true);
					
				} catch (SQLException | DisorderlyQueryException e) {
					// Show an error message
					JOptionPane.showMessageDialog(
							null,
							"Bad SQL query.",
							"Error!",
							JOptionPane.ERROR_MESSAGE);
					
					// TODO auditing
					
					e.printStackTrace();
				}
			}
			
		});
		
		selectDialog.getFromComboBox().addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				addListenerToSelectComboBox(
						selectDialog.reinitSelectComboBoxes());
				refreshAttributes();
			}
		});
	}
	
	private void refreshAttributes() {
		
		int i = 0;
		for(JComboBox<TextItem> comboBox :
				selectDialog.getSelectComboBoxes()) {
			comboBox.removeAllItems();
			DBTable selectedTable;

			if("doctor".equals(connectionController.getRole())) {
				selectedTable = DBTables.getDoctorTablesAsMap().get(
						selectDialog.getFromComboBox().getSelectedItem());
			}
			else {
				selectedTable = DBTables.getTablesAsMap().get(
						selectDialog.getFromComboBox().getSelectedItem());
			}
			for(DBAttribute dba : selectedTable.getAttributes()) {
				comboBox.addItem(dba);
			}
			if(i >= selectedTable.getAttributes().size()) {
				comboBox.setSelectedIndex(0);
			}
			else {
				comboBox.setSelectedIndex(i++);
			}
			
			selectDialog.getAddSelectButton().setEnabled(
					i < selectedTable.getAttributes().size());
		}
	}

	private String getCommaSeparatedSelect() {
		Collection<HidableJComboBox<TextItem>> comboBoxes =
				selectDialog.getSelectComboBoxes();
		String[] items = new String[selectDialog.getSelectComboBoxes().size()];
		
		int i = 0;
		for(JComboBox<TextItem> comboBox : comboBoxes) {
			items[i++]  = comboBox.getSelectedItem().toString();
		}
		
		return StringUtils.commaSeparated(items);
	}
	
	private void addListenerToSelectComboBox(
			JComboBox<TextItem> comboBox) {
		comboBox.addItemListener(new ItemListener() {
			
			private Object prevItem = comboBox.getSelectedItem();

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
					for(HidableJComboBox<TextItem> comboBox :
						selectDialog.getSelectComboBoxes()) {
						if(comboBox != arg0.getSource()) {
							if(prevItem instanceof TextItem) {
								comboBox.unhide((TextItem) prevItem);
							}
							if(arg0.getItem() instanceof TextItem
									&& !arg0.getItem().equals(
											comboBox.getSelectedItem())) {
								comboBox.hide((TextItem) arg0.getItem());
							}
						}
					}
					prevItem = arg0.getItem();
				}
			}
			
		});
	}
}
