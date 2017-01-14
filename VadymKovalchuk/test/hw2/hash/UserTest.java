package hw2.hash;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class UserTest extends Assert {
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    User user6;


    @Before
    public void initialize() throws Exception {
        user1 = new User("qwerty777", new char[]{'$', '#', '1', 'g', '6'}, 7.786, true);
        user2 = new User("qwerty777", new char[]{'$', '#', '1', 'g', '6'}, 7.786, true);
        user3 = new User("qwerty777", new char[]{'$', '#', '1', 'g', '6'}, 7.7860000000001, true);
        user4 = new User("QWERTY777", new char[]{'$', '#', '1', 'G', '6'}, 7.786, true);
        user5 = new User("QWERTY777", new char[]{'t', 'r', '6', 'm', 'u'}, 5, false);
        user6 = new User("QWERTY777", new char[]{'t', 'r', '6', 'm', 'u'}, 5.0000000, false);
    }

    @Test
    public void equalsTest12() throws Exception {
        assertEquals("user1.equals(user2)", user1, user2);
    }

    @Test
    public void equalsTest21() throws Exception {
        assertEquals("user2.equals(user1)", user2, user1);
    }

    @Test
    public void equalsTest23() throws Exception {
        assertNotEquals("!user2.equals(user3)", user2, user3);
    }

    @Test
    public void equalsTest45() throws Exception {
        assertNotEquals("!user4.equals(user5)", user4, user5);
    }

    @Test
    public void equalsTest56() throws Exception {
        assertEquals("user5.equals(user6)", user5, user6);
    }

    @Test
    public void hashCodeTest12() throws Exception {
        assertEquals("user1.hashCode() == user2.hashCode()", user1.hashCode(), user2.hashCode());
    }

    @Test
    public void hashCodeTest23() throws Exception {
        assertNotEquals("user2.hashCode() != user3.hashCode()", user2.hashCode(), user3.hashCode());
    }

    @Test
    public void hashCodeTest45() throws Exception {
        assertNotEquals("user4.hashCode() != user5.hashCode()", user4.hashCode(), user5.hashCode());
    }

    @Test
    public void hashCodeTest56() throws Exception {
        assertEquals("user5.hashCode() == user6.hashCode()", user5.hashCode(), user6.hashCode());
    }

}