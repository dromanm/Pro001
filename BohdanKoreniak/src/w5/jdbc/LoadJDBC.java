package w5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Bohdan on 21.01.2017.
 */
public class LoadJDBC
{
    private static String url = "jdbc:mysql://localhost:3306/test_database";
    private static String login = "root";
    private static String password = "8953900";

    private Connection connection;

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver not found");
        }

        System.out.println("Driver is present");

        LoadJDBC loadJDBC = new LoadJDBC();
        try (Connection connection = DriverManager.getConnection(url, login, password))
        {
            loadJDBC.connection = connection;
            System.out.println("Connection established");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Error while connecting to database");
        }
    }
}
