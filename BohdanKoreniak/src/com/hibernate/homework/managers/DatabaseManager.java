package com.hibernate.homework.managers;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Bohdan on 03.02.2017.
 */
public class DatabaseManager
{
    private SessionFactory sessionFactory;

    public DatabaseManager(Class ...annotatedClasses)
    {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        for (Class annotatedClass : annotatedClasses)
        {
            configuration.addAnnotatedClass(annotatedClass);
        }

        sessionFactory = configuration.buildSessionFactory();
    }

    public int saveEntry(Object entry)
    {
        int id = 0;
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                id = (int) session.save(entry);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return id;
    }

    public void updateEntry(Object entry)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                session.update(entry);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }
    }

    public void deleteEntry(int id, Class entityClass)
    {
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                session.delete(session.load(entityClass, id));
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }
    }

    public <T> T getEntry(int id, Class<T> entityClass)
    {
        T entry = null;

        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                entry = session.get(entityClass, id);
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return entry;
    }

    public <T> List<T> getEntries(Class<T> entityClass)
    {
        List<T> list = null;
        try (Session session = sessionFactory.getCurrentSession())
        {
            try
            {
                session.beginTransaction();
                list = session.createQuery("From " + entityClass.getName()).list();
                session.getTransaction().commit();
            }
            catch (HibernateException e)
            {
                session.getTransaction().rollback();
            }
        }

        return list;
    }
}
