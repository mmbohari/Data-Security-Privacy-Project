package dsp.db.gui.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.actions.CancelDialogAction;
import dsp.db.gui.text.TextItem;
import dsp.db.gui.text.TextItemListCellRenderer;
import dsp.db.query.DisorderlyQueryException;
import dsp.db.query.PreparedSelectStatementGenerator;
import dsp.db.query.ResultSetController;
import dsp.db.setup.ConnectionController;
import dsp.db.table.DBAttribute;
import dsp.db.table.DBTable;
import dsp.db.table.set.DBTables;

/**
 * The {@link SelectDialogHandler}.
 * 
 * TODO comment.
 * 
 * @author Ryan Conrad
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
		
		selectDialog.getSelectComboBox().setRenderer(
				new TextItemListCellRenderer());
		selectDialog.getFromComboBox().setRenderer(
				new TextItemListCellRenderer());
		
		selectDialog.getSelectComboBox().addItem(new TextItem("*", "*"));
		
		for(DBTable table : DBTables.getTables()) {
			selectDialog.getFromComboBox().addItem(table);
		}
		
		refreshAttributes();
		
		selectDialog.getCancelButton().setAction(
				new CancelDialogAction(
						selectDialog));
	}

	@Override
	protected void initializeListeners() {
		selectDialog.getOkButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSetController rsc = new PreparedSelectStatementGenerator(
							connectionController)
						.select(selectDialog.getSelectComboBox().getSelectedItem().toString())
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
				refreshAttributes();
			}
		});
	}
	
	private void refreshAttributes() {
		selectDialog.getSelectComboBox().removeAllItems();
		DBTable selectedTable = DBTables.getTablesAsMap().get(
				selectDialog.getFromComboBox().getSelectedItem());
		for(DBAttribute dba : selectedTable.getAttributes()) {
			selectDialog.getSelectComboBox().addItem(dba);
		}
	}

}
