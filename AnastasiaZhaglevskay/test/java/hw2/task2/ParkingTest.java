package java.hw2.task2;

import hw2.task2.Car;
import hw2.task2.ParkFreeException;
import hw2.task2.ParkFullException;
import hw2.task2.Parking;
import org.junit.Assert;
import org.junit.Test;

public class ParkingTest extends Assert {

    @Test
    public void parseParkFull(){
        Parking parking = new Parking(2);
        Car car1 = new Car("Ann", 3);
        Car car2 = new Car("Ann", 3);
        Car car3 = new Car("Ann", 3);

        try{
            parking.park(car1);
            parking.park(car2);
            //parking.park(car3);
        }catch (ParkFullException exp){
            fail("We have only 2 places ");
        }
    }

    @Test
    public void parseParkNotCar(){
        Car car = new Car("Ann", 3);

        assertEquals("whoseCar", "Ann", car.getWhoseCar());
        assertNotEquals("whoseCar", 4, car.getWhoseCar());
        assertNotEquals("whoseCar", "four", car.getWhoseCar());

        assertEquals("whoseCar", 3, car.getHour());
        assertNotEquals("whoseCar", "tree", car.getHour());
        assertNotEquals("whoseCar", "Ann", car.getHour());
    }

    @Test
    public void parseParkFree(){
        Parking parking = new Parking(2);
        Car car1 = new Car("Ann", 3);
        Car car2 = new Car("Ann", 3);

        try{
            parking.park(car1);
            parking.park(car2);
        }catch (ParkFullException exp){
            fail("We have only 2 places ");
        }

        try{
            parking.leave(0);
            parking.leave(1);
            //parking.leave(1);
        }catch (ParkFreeException exp){
            fail("This place is already free");
        }
    }

    @Test
    public void parseLeaveReturnNotCar(){
        Parking parking = new Parking(2);
        Car car1 = new Car("Ann1", 2);
        Car car2 = new Car("Ann2", 3);

        try{
            parking.park(car1);
            parking.park(car2);
        }catch (ParkFullException exp){
            fail("We have only 2 places ");
        }

        try{
            assertEquals("Expect car1", car1, parking.leave(0));
            //assertNotEquals("Expect car1", car2, parking.leave(0));
        }catch (ParkFreeException exp){
            fail("This place is already free");
        }
    }
}
