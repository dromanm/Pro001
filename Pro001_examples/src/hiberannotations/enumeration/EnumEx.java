package hiberannotations.enumeration;

import hiberannotations.enumeration.dao.EmployeeDAO;
import hiberannotations.enumeration.dao.EmployeeDAOImpl;
import hiberannotations.enumeration.entity.Employee;
import hiberannotations.enumeration.enums.Gender;
import hiberannotations.enumeration.enums.Position;
import hiberannotations.enumeration.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by IEvgen Boldyr on 12.02.17.
 */
public class EnumEx {

    private static EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();

        Employee employee1 =
                new Employee("TEST1", 20, Gender.MALE, Position.ADMIN);
        Employee employee2 =
                new Employee("TEST2", 25, Gender.FEMALE, Position.CLIENT);
        Employee employee3 =
                new Employee("TEST3", 25, Gender.MALE, Position.MANAGER);
        Employee employee4 =
                new Employee("TEST2", 40, Gender.MALE, Position.MANAGER);

        session.beginTransaction();
        session.saveOrUpdate(employee1);
        session.saveOrUpdate(employee2);
        session.saveOrUpdate(employee3);
        session.saveOrUpdate(employee4);
        session.getTransaction().commit();

        List<Employee> list = employeeDAO.employeeByAge(20, 30);
        for (Employee employee : list) {
            System.out.println(employee);
        }


        HibernateUtil.getSessionFactory().close();
    }
}
