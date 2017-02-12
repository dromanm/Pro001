package hiberannotations.enumeration.dao;

import hiberannotations.enumeration.entity.Employee;
import hiberannotations.enumeration.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by IEvgen Boldyr on 12.02.17.
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> employeeByName(String name, Integer age) {
        Session session = HibernateUtil.getSession();
        return session
                .createCriteria(Employee.class)
                .add(Restrictions.eq("name", name))
                .add(Restrictions.le("age", age))
                .list();
    }

    @Override
    public List<Employee> employeeByAge(
            Integer lowAge, Integer highAge) {
        Session session = HibernateUtil.getSession();
        return session
                .createCriteria(Employee.class)
                .add(Restrictions.between("age", lowAge, highAge))
                .list();
    }
}
