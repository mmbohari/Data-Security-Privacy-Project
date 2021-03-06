package dsp.db.table;

import java.util.ArrayList;
import java.util.Collection;

import dsp.db.gui.text.TextItem;

public class DBTable extends TextItem {
	
	private Collection<DBAttribute> attributes;
	
	public DBTable(String name, String displayText) {
		super(name, displayText);
		
		this.attributes = new ArrayList<DBAttribute>();
	}
	
	public void add(String name, String displayText) {
		attributes.add(new DBAttribute(name, displayText));
	}
	
	public Collection<DBAttribute> getAttributes()
	{
		return attributes;
	}
}
