package homeWork02.park;

/**
 * Created by Prigovor on 09.01.2017.
 */
public class Car {

    private Integer placeNumber;

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        return getPlaceNumber().equals(car.getPlaceNumber());
    }
}
