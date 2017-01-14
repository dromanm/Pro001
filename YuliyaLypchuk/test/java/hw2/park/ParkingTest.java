package hw2.park;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by JL on 04.01.2017.
 *
 */
public class ParkingTest extends Assert {

    private Parking parking = new Parking();
    Car car1;
    Car car2;
    Car car3;

    @Before
    public void init() {
        car1 = new Car("ford", 12345L);
        car2 = new Car("nissan", 23456L);
        car3 = new Car("opel", 34567L);
    }

    @Test
    public void testParkingPark() throws ParkFullException {
        assertEquals("", 0, (int)parking.park(car1));
        assertEquals("", 1, (int)parking.park(car2));
        assertNotEquals("", 0, (int)parking.park(car3));
    }

    @Test
    public void testParkLeave() throws IndexOutOfBoundsException, ParkFullException {
        parking.park(car1);
        assertEquals("", car1, parking.leave(0));
        assertNotEquals("", car1, parking.leave(0));
        assertEquals("", null, parking.leave(0));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBounds() throws IndexOutOfBoundsException {
        parking.leave(-1);
    }

}

