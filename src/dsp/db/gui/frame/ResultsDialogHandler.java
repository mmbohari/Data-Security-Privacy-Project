package dsp.db.gui.frame;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dsp.db.gui.ComponentHandler;
import dsp.db.gui.actions.CancelDialogAction;
import dsp.db.gui.actions.OkDialogAction;
import dsp.db.query.ResultSetController;

/**
 * The {@link ResultsDialogHandler}.
 * 
 * TODO comment.
 * 
 * @author Ryan Conrad
 * @author Imran Iqubal Bohari
 * @author Fynn Dallmeier
 */
public class ResultsDialogHandler extends ComponentHandler {
	
	private ResultsDialog resultsDialog;
	private ResultSetController rsc;

	protected ResultsDialogHandler(
			ResultsDialog resultsDialog,
			ResultSetController rsc) {
		super(resultsDialog);
		
		this.resultsDialog = resultsDialog;
		this.rsc = rsc;
		
		initializeGUI();
	}

	@Override
	protected void setup() {
		resultsDialog.getCancelButton().setAction(
				new CancelDialogAction(
						resultsDialog));

		resultsDialog.getOkButton().setAction(
				new OkDialogAction(
						resultsDialog));
		try {
			if(rsc.hasResults()) {

				ResultSetMetaData rsmd = rsc.getResultSet().getMetaData();
				
				Vector<String> columnNames = new Vector<String>();
				for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
					columnNames.add(rsmd.getColumnName(i));
				}
		
		
			    // data of the table
			    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			    while (rsc.getResultSet().next()) {
			        Vector<Object> vector = new Vector<Object>();
			        for (int columnIndex = 1; columnIndex <= rsmd.getColumnCount(); columnIndex++) {
			            vector.add(rsc.getResultSet().getObject(columnIndex));
			        }
			        data.add(vector);
			    }
				
				TableModel tm = new DefaultTableModel(data, columnNames);
				resultsDialog.getResultTable().setModel(tm);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void initializeListeners() {
		// TODO Auto-generated method stub
		
	}
}
