package w2.lesson4.task2;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class Contacts
{
    private Contact contact;

    public void initContact()
    {
        contact = new Contact("test", "test", 99, 123456789);
    }

    public Contact getContact()
    {
        return contact;
    }
}
