package homeWork02.park;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Prigovor on 09.01.2017.
 */
public class ParkingTest {

    private Parking parking;
    private Car car1;
    private Car car2;
    private Car car3;

    @Before
    public void setUp() throws Exception {
        parking = new Parking();
        car1 = new Car();
        car2 = new Car();
        car3 = new Car();
    }

    @Test
    public void testPark() throws Exception {
        assertEquals("Put the car.", 0, parking.park(car1));
        assertEquals("Put the car.", 1, parking.park(car2));
        assertEquals("Put the car.", 2, parking.park(car3));
    }

    @Test(expected = ParkFullException.class)
    public void testParkFullException() throws Exception {
        testPark();
        parking.park(car3);
    }

    @Test
    public void testLeave() throws Exception {
        testPark();
        assertTrue("Remove the machine", parking.leave(0).equals(car1));
        assertTrue("Remove the machine", parking.leave(1).equals(car2));
        assertTrue("Remove the machine", parking.leave(2).equals(car3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLeaveIndexOutOfBoundsException() throws Exception {
        testLeave();
        parking.leave(0);
        parking.leave(7);
    }
}