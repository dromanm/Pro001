package homeWork02.park;

/**
 * Created by Prigovor on 08.01.2017.
 */
public class Parking {

    private Car[] parkingPlaces;

    public Parking() {
        parkingPlaces = new Car[3];
    }

    public int park(Car car) throws ParkFullException {
        for (int i = 0; i < parkingPlaces.length; i++) {
            if (parkingPlaces[i] == null) {
                parkingPlaces[i] = car;
                car.setPlaceNumber(i);
                return car.getPlaceNumber();
            }
        }
        throw new ParkFullException();
    }

    public Car leave(int placeNumber) {
        Car tmp = parkingPlaces[placeNumber];
        if (placeNumber >= 0 & placeNumber < parkingPlaces.length) {
            if (parkingPlaces[placeNumber] == null) {
                throw new IndexOutOfBoundsException("Парковочное место уже пустое!");
            } else {
                parkingPlaces[placeNumber] = null;
                return tmp;
            }
        } else {
            throw new IndexOutOfBoundsException("Такого парковочного места на стоянке нет!");
        }
    }
}
