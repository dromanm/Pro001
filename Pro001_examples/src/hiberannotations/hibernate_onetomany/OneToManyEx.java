package hiberannotations.hibernate_onetomany;

import hiberannotations.hibernate_onetomany.domain.Car;
import hiberannotations.hibernate_onetomany.domain.Driver;
import hiberannotations.hibernate_onetomany.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by IEvgen Boldyr on 11.02.17.
 */

public class OneToManyEx {

    public static void main(String[] args) {
        Car car = new Car("TEST", "TEST");

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.saveOrUpdate(car);
        session.getTransaction().commit();

        Driver driver1 = new Driver("TEST1", "TEST2", car);
        Driver driver2 = new Driver("TEST2", "TEST2", car);

        session.beginTransaction();
        session.saveOrUpdate(driver1);
        session.saveOrUpdate(driver2);
        session.getTransaction().commit();
    }

}
