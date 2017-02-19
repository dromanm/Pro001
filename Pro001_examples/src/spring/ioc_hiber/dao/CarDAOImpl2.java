package spring.ioc_hiber.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.ioc_hiber.entity.Car;

/**
 * Created by IEvgen Boldyr on 19.02.17.
 */

@Repository("ver1")
public class CarDAOImpl2 implements CarDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Car car) {
        return null;
    }
}
