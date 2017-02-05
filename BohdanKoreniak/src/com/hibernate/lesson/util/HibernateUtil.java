package com.hibernate.lesson.util;

/**
 * Created by Bohdan on 29.01.2017.
 */
public class HibernateUtil
{
    private static final SessionFactory factory = build();
    private static StandardServiceRegistry registry;

    private static SessionFactory build()
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        registry = builder.build();

        return configuration.configure().buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory()
    {
        return factory;
    }
}
