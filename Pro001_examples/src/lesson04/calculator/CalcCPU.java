package lesson04.calculator;

/**
 * Created by IEvgen Boldyr on 25.12.16.
 */
public class CalcCPU {

    private CalcCPU() {}

    public static Integer calc(Integer first,
                            String operation,
                            Integer second) {
        switch (operation) {
            case "+" : return first + second;
            case "-" : return first - second;
            case "*" : return first * second;
            case "/" : return first / second;
        }
        return null;
    }
}
