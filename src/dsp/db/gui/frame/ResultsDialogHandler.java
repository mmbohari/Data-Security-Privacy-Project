package dsp.db.gui.frame;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dsp.db.gui.ComponentHandler;

public class ResultsDialogHandler extends ComponentHandler {
	
	private ResultsDialog resultsDialog;
	private ResultSet resultSet;

	protected ResultsDialogHandler(
			ResultsDialog resultsDialog,
			ResultSet resultSet) {
		super(resultsDialog);
		
		this.resultsDialog = resultsDialog;
		this.resultSet = resultSet;
		
		initializeGUI();
	}

	@Override
	protected void setup() {
		try {
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			Vector<String> columnNames = new Vector<String>();
			for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
				columnNames.add(rsmd.getColumnName(i));
			}
	
	
		    // data of the table
		    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		    while (resultSet.next()) {
		        Vector<Object> vector = new Vector<Object>();
		        for (int columnIndex = 1; columnIndex <= rsmd.getColumnCount(); columnIndex++) {
		            vector.add(resultSet.getObject(columnIndex));
		        }
		        data.add(vector);
		    }
			
			TableModel tm = new DefaultTableModel(data, columnNames);
			resultsDialog.getResultTable().setModel(tm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void initializeListeners() {
		// TODO Auto-generated method stub
		
	}
}
