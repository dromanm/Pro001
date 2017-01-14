package hw2.authentication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class AuthTest {
    Auth auth;

    @Before
    public void initialize() throws Exception {
        auth = new Auth();
    }

    @Test
    public void authenticateTest() throws Exception {
        initUsers();

        assertTrue(auth.authenticate("qwerty1", "qqq"));
        assertTrue(auth.authenticate("qwerty2", "aaa"));
        assertTrue(auth.authenticate("qwerty3", "zzz"));
        assertFalse(auth.authenticate("qwerty3", "zzzz"));

        assertFalse(auth.authenticate("qwerty1", null));
        assertFalse(auth.authenticate(null, null));

        auth.remove("qwerty1");
        assertFalse(auth.authenticate("qwerty1", "qqq"));

        assertTrue(auth.authenticate("qwerty2", "aaa"));
    }

    @Test
    public void addTest() throws Exception {
        assertTrue(auth.add("qwerty1", "qqq"));
        assertTrue(auth.add("qwerty2", "aaa"));
        assertTrue(auth.add("qwerty3", "zzz"));
    }

    @Test
    public void removeTest() throws Exception {
        initUsers();
        assertTrue(auth.remove("qwerty1"));
        assertFalse(auth.remove("qwerty11"));
    }

    public void initUsers() {
        auth.add("qwerty1", "qqq");
        auth.add("qwerty2", "aaa");
        auth.add("qwerty3", "zzz");
    }

}