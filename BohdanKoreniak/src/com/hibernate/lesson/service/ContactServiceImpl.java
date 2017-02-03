package com.hibernate.lesson.service;

import com.hibernate.lesson.entity.Contact;
import com.hibernate.lesson.dao.ContactDAO;
import com.hibernate.lesson.dao.ContactDAOImpl;

import java.util.List;

/**
 * Created by Bohdan on 29.01.2017.
 */
public class ContactServiceImpl implements ContactService
{
    private ContactDAO contactDAO;

    public ContactServiceImpl()
    {
        contactDAO = new ContactDAOImpl();
    }

    @Override
    public void createContact(Contact contact)
    {
        Long id = contactDAO.createContact(contact);
        contact.setId(id);
    }

    @Override
    public List<Contact> findAll()
    {
        return contactDAO.findAll();
    }
}
