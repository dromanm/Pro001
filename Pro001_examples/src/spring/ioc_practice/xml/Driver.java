package spring.ioc_practice.xml;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class Driver {

    private String name;
    private String surname;
    private Car car;

    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
