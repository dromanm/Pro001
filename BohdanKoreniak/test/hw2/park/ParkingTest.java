package hw2.park;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bohdan on 11.01.2017.
 */
public class ParkingTest extends Assert
{
    private Parking parking;

    private Car car;
    private Car car1;

    @Before
    public void initParking()
    {
        parking = new Parking(5);

        car = new Car("Lada Kalina");
        car1 = new Car("Lada Malina");

        try
        {
            parking.park(car);
            parking.park(car1);
        }
        catch (ParkFullException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void parkTest()
    {
        try
        {
            assertEquals(2, parking.park(new Car("Lada Smorodina")));
            assertEquals(3, parking.park(new Car("Lada Vinogradina")));
        }
        catch (ParkFullException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void leaveTest()
    {
        assertEquals(car, parking.leave(0));
        assertEquals(car1, parking.leave(1));

        assertNotEquals(car, parking.leave(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void wrongParkingPlaceLeaveTest()
    {
        parking.leave(34);
    }

    @Test(expected = ParkFullException.class)
    public void parkFullTest() throws ParkFullException
    {
        for (int i = 0; i < 10; i++)
        {
            parking.park(new Car());
        }
    }
}
