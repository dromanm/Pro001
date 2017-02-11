package hiberannotations.hibernate_onetomany.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by IEvgen Boldyr on 29.01.17.
 */

//Шаблон проектирования Singleton
public class HibernateUtil {

    private static final SessionFactory factory = build();

    private static SessionFactory build() {
        Configuration config = new Configuration();
        config.configure("hiberannotations/hibernate_onetomany/hibernate.cfg.xml");
        return config.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
