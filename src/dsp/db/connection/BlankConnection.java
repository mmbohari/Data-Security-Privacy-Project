package dsp.db.connection;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class BlankConnection implements Connection {

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		System.out.println("BlankConnection");
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void clearWarnings() throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void close() throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void commit() throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Statement createStatement() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		System.out.println("BlankConnection");
		return false;
	}

	@Override
	public String getCatalog() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public int getHoldability() throws SQLException {
		System.out.println("BlankConnection");
		return 0;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		System.out.println("BlankConnection");
		return 0;
	}

	@Override
	public String getSchema() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		System.out.println("BlankConnection");
		return 0;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public boolean isClosed() throws SQLException {
		System.out.println("BlankConnection");
		return false;
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		System.out.println("BlankConnection");
		return false;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		System.out.println("BlankConnection");
		return false;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void rollback() throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		System.out.println("BlankConnection");
		return null;
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		System.out.println("BlankConnection");
		
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		System.out.println("BlankConnection");
		
	}
}
