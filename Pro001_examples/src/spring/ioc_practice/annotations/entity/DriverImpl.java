package spring.ioc_practice.annotations.entity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class DriverImpl implements DriverAn {

    private String name;
    private String surname;

    @Autowired
    private CarAn car;

    public DriverImpl(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public void name() {
        System.out.println(name + " " + surname);
    }

    @Override
    public void car() {
        car.model();
    }
}
