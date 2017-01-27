package w5.chat;

import java.io.Serializable;

/**
 * Created by Bohdan on 22.01.2017.
 */
public class User implements Serializable
{
    private String login;

    public String getLogin()
    {
        return login;
    }

    public User(String login)
    {
        this.login = login;
    }

    @Override
    public String toString()
    {
        return login;
    }
}
