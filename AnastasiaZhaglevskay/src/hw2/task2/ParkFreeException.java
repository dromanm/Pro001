package hw2.task2;

public class ParkFreeException extends Exception{

    public ParkFreeException(String message) {
        super(message);
    }

    public String toString(){
        return "ParkFreeException";
    }

}
