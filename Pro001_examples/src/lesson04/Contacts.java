package lesson04;

/**
 * Created by IEvgen Boldyr on 25.12.16.
 */

public class Contacts {

    private Contact contact = null;

    public void initContact() {
        contact = new Contact("test", "test", 99, 1234567);
    }

    public Contact getContact() {
        return contact;
    }
}
