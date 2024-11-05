package ch.nb.persistence.utils;

import ch.nb.logging.SimpleLogger;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class StatementHelper {

    // Bind parameters to a prepared statement.
    public static void bindStatementParameters(PreparedStatement statement, Object... sqlParameters) {
        for (int i = 0; i < sqlParameters.length; i++) {
            Object parameter = sqlParameters[i];
            try {
                if (parameter instanceof Integer) {
                    statement.setInt(i + 1, (Integer) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(i + 1, (String) parameter);
                } else if (parameter instanceof Float) {
                    statement.setFloat(i + 1, (Float) parameter);
                } else if (parameter instanceof LocalDate) {
                    statement.setDate(i + 1, (Date) parameter);
                    // TODO Work in progress
                }

                else {
                    statement.setObject(i + 1, parameter);
                }
            } catch (SQLException e) {
                SimpleLogger.error("Error while binding statement: " + e.getMessage());
            }
        }
    }
}
