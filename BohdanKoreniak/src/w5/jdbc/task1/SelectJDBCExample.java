package w5.jdbc.task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class SelectJDBCExample
{

    private static String url = "jdbc:mysql://localhost:3306/test_database";
    private static String login = "root";
    private static String password = "8953900";

    public static void main(String[] args)
    {
        try (Connection connection = DriverManager.getConnection(url, login, password))
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            List<User> listUsers = new ArrayList<>();

            while (resultSet.next())
            {
                User user = new User(resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"));

                listUsers.add(user);
                System.out.println(user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
