package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDb {

    static String postgresConnection =
            "jdbc:postgresql://test.db:5432/test-db?user=user1&password=password";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            System.out.println("Connecting to Postgres Db.");
            connection = DriverManager.getConnection(postgresConnection);
            DriverManager.registerDriver(new org.postgresql.Driver());
            System.out.println(String.format("Connection to %s was successful.", postgresConnection));
        } catch (SQLException e) {
            System.out.println(String.format("Cannot connect to %s. \nThe connection attempt failed.", postgresConnection));
            e.printStackTrace();
        }
        return connection;
    }
}
