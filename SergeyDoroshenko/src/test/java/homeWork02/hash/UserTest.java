package homeWork02.hash;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Prigovor on 07.01.2017.
 */
public class UserTest {

    private User user1;
    private User user2;
    private User user3;

    @Before
    public void setUp() {
        user1 = new User("Petia", "Petia", "23.04.2009", 0.3, "men");
        user2 = new User("Petia", "Petia", "23.04.2009", 0.3, "men");
        user3 = new User("Vasia", "Vasia", "12.09.2013", 0.1, "men");
    }

    @Test
    public void equalsTest() {

    }

    @Test
    public void hashTest() {
        assertTrue("True", user1.hashCode() == user2.hashCode());
        assertFalse("True", user1.hashCode() == user3.hashCode());
    }
}