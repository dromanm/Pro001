package hw2.park;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by eriol4ik on 12/01/2017.
 */
public class Parking {
    private Car[] places;
    private Queue<Integer> freePlaces;
    private int amount = 0;
    private int capacity;

    public Parking(int capacity) throws IndexOutOfBoundsException {
        if (capacity <= 0) throw new IndexOutOfBoundsException("bad capacity");
        this.capacity = capacity;
        places = new Car[capacity];
        freePlaces = new PriorityQueue<>(capacity); // default Comparator - Integer::compareTo
        for (int i = 0; i < capacity; i++) {
            freePlaces.add(i);
        }
    }

    public int park(Car car) throws ParkFullException {
        if (freePlaces.isEmpty()) throw new ParkFullException("Parking is full");

        int position = freePlaces.remove();
        places[position] = car;

        return position + 1; // change for parking index
    }

    public Car leave(int placeNumber) throws IndexOutOfBoundsException {
        placeNumber--; // change for array index
        if (placeNumber < 0 || placeNumber >= capacity) throw new IndexOutOfBoundsException("bad place number");

        Car carToDelete = places[placeNumber];
        places[placeNumber] = null;
        if (carToDelete != null) {
            freePlaces.add(placeNumber);
        }

        return carToDelete;
    }

    @Override
    public String toString() {
        return Arrays.toString(places);
    }

    public class ParkFullException extends Exception {
        public ParkFullException(String message) {
            super(message);
        }
    }
}
