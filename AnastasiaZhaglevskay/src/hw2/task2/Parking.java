package hw2.task2;

public class Parking {

    private Car[] parking;
    private int size;

    public Parking(int size) {
        this.size = 0;
        parking = new Car[size];
    }

    public int park(Car car) throws ParkFullException{
        for (int i = 0; i < 4; i++) {
            if (parking[i] == null) {
                parking[i] = car;

                return i + 1;
            }
        }
        throw new ParkFullException("We have only 4 places ", size);
    }

    public Car leave(int places) throws ParkFreeException{
        if (parking[places] != null) {
            Car leaveCar = parking[places];

            System.out.println(parking[places].whoseCar + " is leaving; -> Parking place N." + places + " is free");
            parking[places] = null;

            return leaveCar;
        }
        throw new ParkFreeException("This place is already free");
    }


}
