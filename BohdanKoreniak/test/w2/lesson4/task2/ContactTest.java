package w2.lesson4.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bohdan on 30.12.2016.
 */
public class ContactTest extends Assert
{
    private Contact contact;
    private Contact contact1;
    private Contact contact2;

    @Before
    public void initContacts()
    {
        contact = new Contact("Alise", "MacGregor", 22, 99011);
        contact1 = new Contact("Alise", "MacGregor", 22, 99011);
        contact2 = new Contact("Poll", "Luis", 23, 12412);
    }

    @Test
    public void contactEqualsTest()
    {
        assertTrue("Are contacts equal", contact.equals(contact1));
        assertFalse("Are contacts not equal", contact.equals(contact2));
    }

    @Test
    public void contactHashCodeTest()
    {
        assertTrue("Are contacts hash codes equal", contact.hashCode() == contact1.hashCode());
        assertFalse("Are contacts hash codes not equal", contact.hashCode() == contact2.hashCode());
    }
}
