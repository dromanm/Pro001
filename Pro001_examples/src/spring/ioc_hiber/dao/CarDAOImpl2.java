package spring.ioc_hiber.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.ioc_hiber.entity.Car;

/**
 * Created by IEvgen Boldyr on 19.02.17.
 */

@Repository
public class CarDAOImpl2 implements CarDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public Long create(Car car) {
        return (Long) factory.getCurrentSession().save(car);
    }

    @Override
    public Car read(Long id) {
        return new Car("FORD", "WHITE");
//        throw new RuntimeException();
    }
}
