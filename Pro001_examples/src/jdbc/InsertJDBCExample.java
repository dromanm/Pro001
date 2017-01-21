package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IEvgen Boldyr on 21.01.17.
 */
public class InsertJDBCExample {

    private static String url
            = "jdbc:mysql://localhost:3306/FirstDB";
    private static String login    = "root";
    private static String password = "root";

    public static void main(String[] args) {
        try {
            User user1 = new User(4, "test1", "test");
            User user2 = new User(5, "test2", "test");
            User user3 = new User(6, "test3", "test");
            List<User> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);
            users.add(user3);

            Connection connection = DriverManager.getConnection(url, login, password);
            String query = "INSERT INTO USERS (id, login, password) " +
                           "VALUES (?,?,?)";
            PreparedStatement statement
                    = connection.prepareStatement(query);
            for (User user : users) {
                statement.setInt(1, user.getId());
                statement.setString(2, user.getLogin());
                statement.setString(3, user.getPassword());
                statement.execute();
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
