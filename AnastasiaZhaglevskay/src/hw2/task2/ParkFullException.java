package hw2.task2;

public class ParkFullException extends Exception{

    private int num;

    public ParkFullException(String message, int num){
        super(message);
        this.num = num;
    }

    public String toString(){
        return "ParkFullException " + num;
    }

}
