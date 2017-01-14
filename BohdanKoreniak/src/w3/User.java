package w3;

import java.io.Serializable;

/**
 * Created by Bohdan on 14.01.2017.
 */
public class User implements Moveable, Serializable
{
    public String name;

    private String login;
    private String password;

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin()
    {
        return login;
    }

    public String getPassword()
    {
        return password;
    }

    public void methodExample(String paramExample, int paramExample1)
    {

    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
