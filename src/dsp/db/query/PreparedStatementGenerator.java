package dsp.db.query;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PreparedStatementGenerator {
	public ResultSet executeQuery() throws SQLException;
}
