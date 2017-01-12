package hw2.authentication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bohdan on 12.01.2017.
 */
public class AuthTest extends Assert
{
    private Auth auth;

    private String login;
    private String password;

    @Before
    public void initAuth()
    {
        auth = new Auth();

        login = "Sauron";
        password = "Hobbits_are_bastards";

        auth.getMapRegisteredUsers().put(login, password);
    }

    @Test
    public void authenticationTest()
    {
        assertEquals(true, auth.authentication(login, password));
        assertEquals(false, auth.authentication(login, "I_see_you"));
    }

    @Test
    public void addTest()
    {
        auth.add("Smaug", "I_like_swimming");
        assertEquals(true, auth.authentication("Smaug", "I_like_swimming"));
    }

    @Test
    public void removeTest()
    {
        auth.remove(login);
        assertEquals(false, auth.authentication(login, password));
    }
}
