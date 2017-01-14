package hw2.task2;

public class Main_Parking_hw2_2 {

    public static void main(String[] args) throws ParkFullException, ParkFreeException {

        Car car1 = new Car("Ann", 5);
        Car car2 = new Car("Bet", 3);
        Car car3 = new Car("Luci", 4);
        Car car4 = new Car("Ron", 2);

        Parking parking = new Parking(3);
        System.out.println(parking.park(car1));
        System.out.println(parking.park(car2));
        System.out.println(parking.park(car3));
        //System.out.println(parking.park(car4));

        parking.leave(1);
        parking.leave(0);
        System.out.println(parking.park(car3));
        System.out.println(parking.park(car4));


    }
}