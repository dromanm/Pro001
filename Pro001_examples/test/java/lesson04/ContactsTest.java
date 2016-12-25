package lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IEvgen Boldyr on 25.12.16.
 */

public class ContactsTest extends Assert {

    private Contacts contacts;

    @Before
    public void initial() {
        contacts = new Contacts();
    }

    @Test
    public void initContactTest() {
        assertNull("Пустая переменная: ", contacts.getContact());
        contacts.initContact();
        assertNotNull("Не пустая переменная: ", contacts.getContact());
    }
}
