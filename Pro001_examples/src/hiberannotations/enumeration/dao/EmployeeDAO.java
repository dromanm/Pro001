package hiberannotations.enumeration.dao;

import hiberannotations.enumeration.entity.Employee;

import java.util.List;

/**
 * Created by IEvgen Boldyr on 12.02.17.
 */

public interface EmployeeDAO {

    public List<Employee> employeeByName(String name, Integer age);

    public List<Employee> employeeByAge(Integer lowAge, Integer highAge);



}
