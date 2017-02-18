package spring.ioc_practice.annotations.entity;

/**
 * Created by IEvgen Boldyr on 18.02.17.
 */
public class CarImpl implements CarAn {

    private String model;

    public CarImpl(String model) {
        this.model = model;
    }

    @Override
    public void model() {
        System.out.println(model);
    }
}
