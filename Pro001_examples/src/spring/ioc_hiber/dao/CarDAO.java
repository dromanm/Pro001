package spring.ioc_hiber.dao;

import spring.ioc_hiber.entity.Car;

/**
 * Created by IEvgen Boldyr on 19.02.17.
 */
public interface CarDAO {

    Long create(Car car);

    Car read(Long id);

}
