package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IEvgen Boldyr on 22.01.17.
 */

public class SelectJDBCEx {

    private static String url
            = "jdbc:mysql://localhost:3306/FirstDB";
    private static String login    = "root";
    private static String password = "root";

    public static void main(String[] args) {
        //Подклчение и подготовка запроса
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            //Результатом выполнения SELECT запроса, является множество заначений
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                   resultSet.getInt("ID"),
                   resultSet.getString("LOGIN"),
                   resultSet.getString("PASSWORD")
                ));
            }

            for (User user : users) {
                System.out.println(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
