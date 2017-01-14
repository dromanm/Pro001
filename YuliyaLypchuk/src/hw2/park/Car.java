package hw2.park;

/**
 * Created by JL on 04.01.2017.
 */
public class Car {
    private String model;
    private Long serialNumber;

    public Car(String model, Long serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }
}
