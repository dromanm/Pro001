package w5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 21.01.2017.
 */
public class InsertJDBCExample
{
    private static String url = "jdbc:mysql://localhost:3306/test_database";
    private static String login = "root";
    private static String password = "8953900";

    public static void main(String[] args)
    {
        try (Connection connection = DriverManager.getConnection(url, login, password))
        {
            User user = new User(454, "Jane", "1111", "", "");
            User user1 = new User(858, "Jane1", "1111", "", "");
            User user2 = new User(959, "Jane2", "1111", "", "");

            List<User> listUsers = new ArrayList<>();

            listUsers.add(user);
            listUsers.add(user1);
            listUsers.add(user2);

            String query = "INSERT INTO USERS (id, login, password, name, surname) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            listUsers.forEach(userEntry ->
            {
                try
                {
                    preparedStatement.setInt(1, userEntry.getId());
                    preparedStatement.setString(2, userEntry.getLogin());
                    preparedStatement.setString(3, userEntry.getPassword());
                    preparedStatement.setString(4, userEntry.getName());
                    preparedStatement.setString(5, userEntry.getSurname());

                    preparedStatement.execute();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            });
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
