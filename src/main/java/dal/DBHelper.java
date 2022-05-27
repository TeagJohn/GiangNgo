package dal;

import java.sql.*;

public class DBHelper {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection != null) return connection;
        String url = "jdbc:mysql://localhost:3306/time_table";
        connection = DriverManager.getConnection(url);
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        ResultSet resultSet;
        PreparedStatement statement = connection.prepareStatement(query);
        resultSet = statement.executeQuery();

        return resultSet;
    }
}
