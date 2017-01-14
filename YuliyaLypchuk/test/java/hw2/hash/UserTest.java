package hw2.hash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by JL on 04.01.2017.
 */
public class UserTest extends Assert {
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void init() {
        user1 = new User("nick1", "test1", "31.12.2016", 0.01, "male");
        user2 = new User("nick1", "test1", "31.12.2016", 0.01, "male");
        user3 = new User("nick3", "test1", "31.12.2016", 0.01, "male");
    }

    @Test
    public void userEqualsTest() {
        assertTrue("Same users", user1.equals(user2));
        assertFalse("Different users", user1.equals(user3));
    }

    @Test
    public void userHashCodeTest() {
        assertTrue(user1.hashCode() == user2.hashCode());
        assertFalse(user1.hashCode() == user3.hashCode());
    }

}
