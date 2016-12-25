package lesson04.calculator;

import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 25.12.16.
 */
public class CalcCPU {

    public static Integer first;
    public static Integer second;
    public static String operation;

    private CalcCPU() {}

    public static void parse(String expression) {
        Scanner scanExp = new Scanner(expression);
        first  = scanExp.nextInt();
        operation = scanExp.next();
        second = scanExp.nextInt();
    }


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
