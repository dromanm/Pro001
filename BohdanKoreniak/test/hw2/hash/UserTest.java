package hw2.hash;

import hw2.hash.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Created by Bohdan on 11.01.2017.
 */
public class UserTest extends Assert
{
    private User user;
    private User user1;
    private User user2;
    private User user3;

    @Before
    public void initUsers()
    {
        user = new User("Kesha", "Freedom_for_the_parrots", LocalDate.of(2017, 1, 1), 45.3, true);
        user1 = new User("Masha", "Dont_eat_me", LocalDate.of(2020, 9, 12), 78.6, false);
        user2 = new User("Masha", "Dont_eat_me", LocalDate.of(2020, 9, 12), 78.6, false);
        user3 = new User("Billy", "I_hate_those_apples", LocalDate.of(2019, 7, 24), 56.9, true);
    }

    @Test
    public void userEqualsTest()
    {
        assertTrue("Are users equal", user1.equals(user2));
        assertFalse("Are users not equal", user.equals(user3));
        assertFalse("Are users not equal", user3.equals(user1));
    }

    @Test
    public void userHashCodeTest()
    {
        assertTrue("Are users hash codes equal", user1.hashCode() == user2.hashCode());
        assertFalse("Are users hash codes not equal", user.hashCode() == user3.hashCode());
        assertFalse("Are users hash codes not equal", user3.hashCode() == user1.hashCode());
    }
}
