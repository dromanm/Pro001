package hw2.park;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class ParkingTest {
    public Parking parking;
    Car[] cars;
    int capacity = 100;

    @Before
    public void initialize() throws Exception {
        parking = new Parking(capacity);
        cars = new Car[capacity + 1];
        for (int i = 0; i < capacity + 1; i++) {
            cars[i] = new Car();
        }
    }


    @Test
    public void parkTest() throws Exception {
        for (int i = 0; i < capacity; i++) {
            assertEquals(parking.park(cars[i]), i + 1);
        }
    }

    @Test(expected = Parking.ParkFullException.class)
    public void parkFullExceptionTest() throws Exception {
        for (int i = 0; i < capacity; i++) {
            assertEquals(parking.park(cars[i]), i + 1);
        }
        parking.park(cars[capacity]);
    }

    @Test
    public void leaveTest() throws Exception {
        for (int i = 0; i < capacity; i++) {
            parking.park(cars[i]);
        }

        assertEquals(parking.leave(20), cars[19]);
        assertEquals(parking.leave(57), cars[56]);
        assertEquals(parking.leave(57), null);
        assertEquals(parking.leave(79), cars[78]);

        assertEquals(parking.park(cars[19]), 20);
        assertEquals(parking.park(cars[56]), 57);
        assertEquals(parking.park(cars[78]), 79);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOutOfBoundExceptionTest1() throws Exception {
        for (int i = 0; i < capacity; i++) {
            parking.park(cars[i]);
        }
        parking.leave(-9);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void indexOutOfBoundExceptionTest2() throws Exception {
        for (int i = 0; i < capacity; i++) {
            parking.park(cars[i]);
        }
        parking.leave(capacity + 1);
    }

}