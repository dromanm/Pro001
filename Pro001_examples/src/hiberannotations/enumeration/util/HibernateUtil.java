package hiberannotations.enumeration.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by IEvgen Boldyr on 29.01.17.
 */

//Шаблон проектирования Singleton
public final class HibernateUtil {

    private static final SessionFactory factory = build();

    private HibernateUtil() {}

    private static SessionFactory build() {
        Configuration config = new Configuration();
        config.configure("hiberannotations/enumeration/hibernate.cfg.xml");
        return config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Session getSession() {
        return factory.openSession();
    }
}
