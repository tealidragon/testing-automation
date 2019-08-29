package clubo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDb {

    static String postgresEarlyAccessConnection =
            "jdbc:postgresql://earlyaccess.cluboautomation.test.ostk.com:5432/clubo-early-access-product-ws-db?user=sqladmin&password=secret";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            System.out.println("Connecting to Postgres Db.");
            connection = DriverManager.getConnection(postgresEarlyAccessConnection);
            DriverManager.registerDriver(new org.postgresql.Driver());
            System.out.println(String.format("Connection to %s was successful.", postgresEarlyAccessConnection));
        } catch (SQLException e) {
            System.out.println(String.format("Cannot connect to %s. \nThe connection attempt failed.", postgresEarlyAccessConnection));
            e.printStackTrace();
        }
        return connection;
    }
}
