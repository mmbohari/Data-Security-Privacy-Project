package dsp.db.query;

import java.sql.SQLException;

public interface PreparedStatementGenerator {
	public ResultSetController executeQuery() throws SQLException;
}
