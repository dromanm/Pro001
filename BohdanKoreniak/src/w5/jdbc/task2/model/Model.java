package w5.jdbc.task2.model;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class Model
{
    private static String url = "jdbc:mysql://localhost:3306/test_database";
    private static String login = "root";
    private static String password = "8953900";

    public List<Contact> getAllContacts()
    {
        List<Contact> listContacts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, login, password))
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CONTACTS");

            while (resultSet.next())
            {
                Contact contact = new Contact(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getInt("phone"));

                listContacts.add(contact);
            }
        }
        catch (SQLException e)
        {

        }

        return listContacts;
    }

    public void insertNewContact(Contact contact)
    {
        try (Connection connection = DriverManager.getConnection(url, login, password))
        {
            String query = "INSERT INTO CONTACTS (id, name, surname, age, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            Field[] fields = contact.getClass().getDeclaredFields();

            for (int i = 1; i <= fields.length; i++)
            {
                Field field = contact.getClass().getDeclaredField(fields[i - 1].getName());

                if (field.getType() == Integer.class)
                {
                    preparedStatement.setInt(i, (Integer) field.get(contact));
                }
                if (field.getType() == String.class)
                {
                    preparedStatement.setString(i, (String) field.get(contact));
                }
            }

            preparedStatement.execute();
        }
        catch (SQLException | IllegalAccessException | NoSuchFieldException e)
        {

        }
    }

    public void deleteContact(Contact contact)
    {
        try (Connection connection = DriverManager.getConnection(url, login, password))
        {
            String query = "INSERT INTO CONTACTS (id, name, surname, age, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);



            preparedStatement.execute();
        }
        catch (SQLException e)
        {

        }
    }
}
