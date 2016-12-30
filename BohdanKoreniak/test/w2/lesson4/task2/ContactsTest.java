package w2.lesson4.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import w2.lesson4.task2.Contacts;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class ContactsTest extends Assert
{
    private Contacts contacts;

    //Preparing data for tests, it calls before each test method call
    @Before
    public void initial()
    {
        contacts = new Contacts();
    }

    @Test
    public void initContactTest()
    {
        assertNull(contacts.getContact());
        contacts.initContact();
        assertNotNull(contacts.getContact());
    }
}
