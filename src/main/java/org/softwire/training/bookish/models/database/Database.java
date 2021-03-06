package org.softwire.training.bookish.models.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public static void initialise() {
        String hostname = getEnvOrDefault("DB_HOSTNAME", "localhost");
        String database = "bookish_schema";
        String user = "root";
        String password = getEnvOrDefault("DB_PASSWORD", SecureInformation.PASSWORD);
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void cleanUp() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static String getEnvOrDefault(String env, String defaultValue) {
        String value = System.getenv(env);
        return (value != null) ? value : defaultValue;
    }
}
