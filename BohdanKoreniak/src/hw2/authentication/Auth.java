package hw2.authentication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bohdan on 12.01.2017.
 */
public class Auth
{
    private Map<String, String> mapRegisteredUsers = new HashMap<>();

    public Map<String, String> getMapRegisteredUsers()
    {
        return mapRegisteredUsers;
    }

    public boolean authentication(String login, String password)
    {
        return mapRegisteredUsers.get(login) != null && mapRegisteredUsers.get(login).equals(password);
    }

    public boolean authenticate()
    {
        ConsoleManager.printText("Enter login, please");
        String login = ConsoleManager.readString();

        ConsoleManager.printText("Enter password, please");
        String password = ConsoleManager.readString();

        return mapRegisteredUsers.get(login) != null && mapRegisteredUsers.get(login).equals(password);
    }

    public void add(String login, String password)
    {
        mapRegisteredUsers.put(login, password);
    }

    public void remove(String login)
    {
        mapRegisteredUsers.remove(login);
    }

    public static void main(String[] args)
    {
        Auth auth = new Auth();
        auth.add("SS", "SS");
        auth.authenticate();
    }
}
