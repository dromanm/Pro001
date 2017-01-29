package hibernate.service;

import hibernate.dao.ContactDAO;
import hibernate.dao.ContactDAOImpl;
import hibernate.entity.Contact;

import java.util.List;

/**
 * Created by IEvgen Boldyr on 29.01.17.
 */
public class ContactServiceImpl implements ContactService {

    private ContactDAO contactDAO;

    public ContactServiceImpl() {
        contactDAO = new ContactDAOImpl();
    }

    @Override
    public void createContact(Contact contact) {
        Long id = contactDAO.createContact(contact);
        contact.setId(id);
    }

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }
}
