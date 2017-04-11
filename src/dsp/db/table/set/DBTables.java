package dsp.db.table.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import dsp.db.table.DBTable;

public class DBTables {
	
	private static final DBTable DOCTOR_TABLE
			= new DBTable("Doctor", "Doctor");
	private static final DBTable HISTORY_TABLE
			= new DBTable("History", "History");
	private static final DBTable INSURANCE_POLICY_TABLE
			= new DBTable("Insurance_Policy", "Insurance Policy");
	private static final DBTable PATIENT_TABLE
			= new DBTable("Patient", "Patient");
	
	static {
		DOCTOR_TABLE.add(
				"fname", "First Name");
		DOCTOR_TABLE.add(
				"lname", "Last Name");
		DOCTOR_TABLE.add(
				"doc_type", "Doctor Type");
				
		HISTORY_TABLE.add(
				"date", "Date");
		HISTORY_TABLE.add(
				"incident", "Incident");
		HISTORY_TABLE.add(
				"medication", "Medication");
		HISTORY_TABLE.add(
				"status", "Status");
				
		INSURANCE_POLICY_TABLE.add(
				"insurance_company_name", "Insurance Company Name");
		INSURANCE_POLICY_TABLE.add(
				"plan", "Plan");
		INSURANCE_POLICY_TABLE.add(
				"premium", "Premium");
				
		PATIENT_TABLE.add(
				"fname", "First Name");
		PATIENT_TABLE.add(
				"lname", "Last Name");
		PATIENT_TABLE.add(
				"bdate", "Birthday");
		PATIENT_TABLE.add(
				"address", "Address");
		PATIENT_TABLE.add(
				"email", "E-Mail");
		PATIENT_TABLE.add(
				"contact", "Contact Information");
		PATIENT_TABLE.add(
				"gender", "Gender");
	}
	
	public static final Collection<DBTable> getTables() {
		Collection<DBTable> tables = new HashSet<DBTable>();
		tables.add(DOCTOR_TABLE);
		tables.add(HISTORY_TABLE);
		tables.add(INSURANCE_POLICY_TABLE);
		tables.add(PATIENT_TABLE);
		return tables;
	}
	
	public static final Collection<DBTable> getDoctorTables() {
		Collection<DBTable> tables = new HashSet<DBTable>();
		tables.add(DOCTOR_TABLE);
		tables.add(HISTORY_TABLE);
		tables.add(PATIENT_TABLE);
		return tables;
	}
	
	public static final Map<Object, DBTable> getTablesAsMap() {
		Map<Object, DBTable> tables = new HashMap<Object, DBTable>();
		tables.put(DOCTOR_TABLE, DOCTOR_TABLE);
		tables.put(HISTORY_TABLE, HISTORY_TABLE);
		tables.put(INSURANCE_POLICY_TABLE, INSURANCE_POLICY_TABLE);
		tables.put(PATIENT_TABLE, PATIENT_TABLE);
		return tables;
	}
	
	public static final Map<Object, DBTable> getDoctorTablesAsMap() {
		Map<Object, DBTable> tables = new HashMap<Object, DBTable>();
		tables.put(DOCTOR_TABLE, DOCTOR_TABLE);
		tables.put(HISTORY_TABLE, HISTORY_TABLE);
		tables.put(PATIENT_TABLE, PATIENT_TABLE);
		return tables;
	}
}
