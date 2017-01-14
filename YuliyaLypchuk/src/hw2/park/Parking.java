package hw2.park;

/**
 * Created by JL on 04.01.2017.
 */
public class Parking {

    private int maxPlaceNumber = 10;
    private Car[] parkPlaces = new Car[maxPlaceNumber];

    public int park (Car car) throws ParkFullException{
        for ( int i = 0; i < maxPlaceNumber; i++) {
            if (parkPlaces[i] == null) {
                parkPlaces[i] = car;
                return i;
            }
        }
        throw new ParkFullException();
    }

    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        if ((placeNumber < maxPlaceNumber) && (placeNumber >= 0)) {
            if (parkPlaces[placeNumber] != null) {
                Car tempCar = parkPlaces[placeNumber];
                parkPlaces[placeNumber] = null;
                System.out.println("The car has gone out from place number " + placeNumber);
                return  tempCar;
            } else {
                System.out.println("Place " + placeNumber +" isn't busy!");
                return null;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
