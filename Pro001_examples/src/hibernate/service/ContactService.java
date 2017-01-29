package hibernate.service;

import hibernate.entity.Contact;

import java.util.List;

/**
 * Created by IEvgen Boldyr on 29.01.17.
 */
public interface ContactService {

    void createContact(Contact contact);

    List<Contact> findAll();

}
