package hiberannotations.enumeration;

import hiberannotations.enumeration.entity.Employee;
import hiberannotations.enumeration.enums.Gender;
import hiberannotations.enumeration.enums.Position;
import hiberannotations.enumeration.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by IEvgen Boldyr on 12.02.17.
 */
public class EnumEx {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();

        Employee employee1 =
                new Employee("TEST1", Gender.MALE, Position.ADMIN);
        Employee employee2 =
                new Employee("TEST2", Gender.FEMALE, Position.CLIENT);
        Employee employee3 =
                new Employee("TEST3", Gender.MALE, Position.MANAGER);

        session.beginTransaction();
        session.saveOrUpdate(employee1);
        session.saveOrUpdate(employee2);
        session.saveOrUpdate(employee3);
        session.getTransaction().commit();

        HibernateUtil.getSessionFactory().close();
    }
}
