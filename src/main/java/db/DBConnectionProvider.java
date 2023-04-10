package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private static final DBConnectionProvider INSTANCE = new DBConnectionProvider();
    private static final String URL = "jdbc:mysql://localhost:3306/eshop?useUnicode=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    private DBConnectionProvider() {}

    public static DBConnectionProvider getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
