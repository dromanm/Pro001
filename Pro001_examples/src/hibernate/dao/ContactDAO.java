package hibernate.dao;

import hibernate.entity.Contact;

import java.util.List;

/**
 * Created by IEvgen Boldyr on 29.01.17.
 */
public interface ContactDAO {

    Long createContact(Contact contact);

    Contact readContact(Long id);

    void updateContact(Contact contact);

    void deleteContact(Contact contact);

    List<Contact> findAll();

}
