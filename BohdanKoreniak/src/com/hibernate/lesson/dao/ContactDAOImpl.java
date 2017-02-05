package com.hibernate.lesson.dao;

import com.hibernate.lesson.entity.Contact;
import com.hibernate.lesson.util.HibernateUtil;

import java.util.List;

/**
 * Created by Bohdan on 29.01.2017.
 */
public class ContactDAOImpl implements ContactDAO
{
    private SessionFactory sessionFactory;

    public ContactDAOImpl()
    {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long createContact(Contact contact)
    {
        try (Session session = sessionFactory.openSession())
        {
            try
            {
                session.beginTransaction();
                Long id = (Long) session.save(contact);
                session.getTransaction().commit();
                return id;
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }

        }
        return null;
    }

    @Override
    public Contact readContact(Long id)
    {
        return null;
    }

    @Override
    public void updateContact(Contact contact)
    {

    }

    @Override
    public void deleteContact(Contact contact)
    {

    }

    @Override
    public List<Contact> findAll()
    {
        return sessionFactory.openSession().createCriteria(Contact.class).list();
    }
}
