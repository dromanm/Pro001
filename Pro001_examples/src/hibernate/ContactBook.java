package hibernate;

import hibernate.entity.Contact;
import hibernate.service.ContactService;
import hibernate.service.ContactServiceImpl;
import hibernate.util.HibernateUtil;

import java.util.List;


/**
 * Created by IEvgen Boldyr on 29.01.17.
 */
public class ContactBook {

    public static void main(String[] args) {
        //HibernateUtil.getSessionFactory();

        ContactService contactService = new ContactServiceImpl();
        List<Contact> contacts = contactService.findAll();

        for (Contact contact : contacts) {
            System.out.println(contact);
        }

        Contact contact = new Contact("test3", "test3", "test3", "test3");
        contactService.createContact(contact);
        contacts.add(contact);

        for (Contact con : contacts) {
            System.out.println(con);
        }

        HibernateUtil.getSessionFactory().close();
    }
}
