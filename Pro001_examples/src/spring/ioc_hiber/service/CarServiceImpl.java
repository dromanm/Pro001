package spring.ioc_hiber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring.ioc_hiber.dao.CarDAO;
import spring.ioc_hiber.entity.Car;

/**
 * Created by IEvgen Boldyr on 19.02.17.
 */

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO dao;

    @Override
    public void create(Car car) {
        if (car != null) {
            car.setId(dao.create(car));
        }
    }

    @Override
    public Car read(Long id) {
        return dao.read(id);
    }

}
