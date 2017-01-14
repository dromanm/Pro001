package hw2.authentication;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Comfy on 05.01.2017.
 */
public class AuthTest extends Assert {

    Auth users = new Auth();
    @Test
    @Ignore
    public void authAuthenticateTest() {
        users.add("user1", "test1");
        assertEquals(true, users.authenticate("user1", "test1"));
        assertEquals(false, users.authenticate("user1", "12345"));
        assertNotEquals(true, users.authenticate("user1", "12345"));
        assertNotEquals(true, users.authenticate("user123", "test1"));
    }
    @Test
    public void authAddTest() {
        users.add("user1", "test1");
        assertEquals(true, users.authenticate("user1", "test1"));
    }

    @Test
    public void authRemoveTest() {
        users.add("user1", "test1");
        users.remove("user1");
        assertEquals(false, users.authenticate("user1", "test1"));

        users.add("user1", "test0");
        users.remove("user1");
        assertNotEquals(true, users.authenticate("user1", "test1"));
    }

}
