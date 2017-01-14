package homeWork02.park;

/**
 * Created by Prigovor on 09.01.2017.
 */
public class ParkFullException extends Exception {
    public ParkFullException() {
        super("На парковке нет свободных мест!");
    }
}
