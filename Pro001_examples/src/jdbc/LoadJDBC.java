package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by IEvgen Boldyr on 21.01.17.
 */

public class LoadJDBC {

    private static String url
            = "jdbc:mysql://localhost:3306/FirstDB";
    private static String login    = "root";
    private static String password = "root";

    private static Connection connection;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
        }

        System.out.println("Driver upload...");

        try {
            connection =
                    DriverManager
                            .getConnection(url
                                            /*+ "?verifyServerCertificate=false"
                                            + "&useSSL=true"
                                            + "&requireSSL=true"*/,
                                    login, password);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
        } finally {
            if (connection != null) {
                try {
                    System.out.println("Connection success!");
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
