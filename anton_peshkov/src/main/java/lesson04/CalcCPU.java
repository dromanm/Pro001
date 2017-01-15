package lesson04;

/**
 * Created by admin on 25.12.16.
 */
public class CalcCPU {

    private CalcCPU(){
    }

    public static int calc(Integer int1, String s1, Integer int2){
        switch (s1){
            case "+": return (int1 + int2);
            case "-": return (int1 - int2);
            case "*": return (int1 * int2);
            case "/": return (int1 / int2);
        }
        return -1;
    }

}
