package lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by IEvgen Boldyr on 25.12.16.
 */
public class ContactTest extends Assert {

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    @Before
    public void initial() {
        contact1 = new Contact("test1", "test1", 50, 1234567);
        contact2 = new Contact("test1", "test1", 50, 1234567);
        contact3 = new Contact("test2", "test2", 45, 7654321);
    }

    @Test
    public void contactEqualsTest() {
        assertTrue("Сравнение контактов (равны)",
                contact1.equals(contact2));
        assertFalse("Сравнение контактов (не равны)",
                contact1.equals(contact3));
    }

    @Test
    @Ignore // в случае такой пометки тест не учитывается
    public void contactHashCodeTest() {
        assertTrue("Сравнение хеш-кода контактов (равны)",
                contact1.hashCode() == contact2.hashCode());
        assertFalse("Сравнение хеш-кода контактов (не равны)",
                contact1.hashCode() == contact3.hashCode());
    }
}
