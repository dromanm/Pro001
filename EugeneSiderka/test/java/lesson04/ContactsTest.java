package lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by snx on 12/25/16.
 */
public class ContactsTest extends Assert {
    private Contacts contacts;

    // This metho will be called before each @Test menthod
    @Before
    public void initialize() {
        this.contacts = new Contacts();
    }

    // Testing void methods example
    @Test
    public void initContactTest() {
        assertNull("Empty variable", this.contacts.contact);
        this.contacts.initContact();
        assertNotNull("Not empty variable", this.contacts.contact);
    }
}
