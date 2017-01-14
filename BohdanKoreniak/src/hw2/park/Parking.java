package hw2.park;

/**
 * Created by Bohdan on 09.01.2017.
 */
public class Parking
{
    private Car[] cars;

    public Parking(int maxCarsAmount)
    {
        this.cars = new Car[maxCarsAmount];
    }

    public int park(Car car) throws ParkFullException
    {
        for (int i = 0; i < cars.length; i++)
        {
            if (cars[i] == null)
            {
                cars[i] = car;
                return i;
            }
        }

        throw new ParkFullException();
    }

    public Car leave(int placeNumber)
    {
        if (placeNumber < 0 || placeNumber > cars.length - 1)
        {
            throw new IndexOutOfBoundsException();
        }

        Car carToReturn = null;

        for (int i = 0; i < cars.length; i++)
        {
            if (i == placeNumber)
            {
                carToReturn = cars[i];
                cars[i] = null;
            }
        }

        return carToReturn;
    }
}
