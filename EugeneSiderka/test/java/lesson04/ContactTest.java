package lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by snx on 12/25/16.
 */
public class ContactTest extends Assert {
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    @Before
    public void init() {
        this.contact1 = new Contact("f", "l", 100, 100);
        this.contact2 = new Contact("f", "l", 100, 100);
        this.contact3 = new Contact("fn", "ln", 200, 200);
    }

    @Test
    public void contactEqualsTest() {
        assertTrue("Contacts comparsion", this.contact1.equals(this.contact2));
        assertFalse("Contacts comparsion", this.contact1.equals(this.contact3));
    }

    // Ignored test - useful if test must be temporary ignored
    @Test
    @Ignore
    public void contactHashCode() {
        assertTrue("Contacts hash comparsion", this.contact1.hashCode() == this.contact2.hashCode());
        assertFalse("Contacts hash comparsion", this.contact1.hashCode() == this.contact3.hashCode());
    }
}
