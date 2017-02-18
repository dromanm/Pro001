package spring.ioc_practice.xml;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class Car {

    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}
