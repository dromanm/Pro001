package spring.ioc_hiber.service;

import spring.ioc_hiber.entity.Car;

/**
 * Created by IEvgen Boldyr on 19.02.17.
 */
public interface CarService {

    void create(Car car);

    Car read(Long id);

}
