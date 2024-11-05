package ch.nb.persistence.utils;

import ch.nb.logging.SimpleLogger;
import ch.nb.utils.PropertiesLoader;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection connection;

    private static PropertiesLoader propertiesLoader = new PropertiesLoader("database.properties");

    private static final String DB_URL = propertiesLoader.getProperty("db.url");
    private static final String DB_USER = propertiesLoader.getProperty("db.user");
    private static final String DB_PASSWORD = propertiesLoader.getProperty("db.password");

    public static Connection getConnection() {
        if (connection == null) {
            // Create a new connection
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                SimpleLogger.info("Connection established!");
            } catch (Exception e) {
                SimpleLogger.error("Failed to connect to database");
                throw new RuntimeException("Failed to connect to database", e);            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (Exception e) {
                throw new RuntimeException("Failed to close database connection", e);
            }
        }
    }
}
