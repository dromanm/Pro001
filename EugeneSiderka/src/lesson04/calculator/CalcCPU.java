package lesson04.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by snx on 12/25/16.
 */
public class CalcCPU {
    public static Integer leftOperand;
    public static Integer rightOperand;
    public static String operation;

    private CalcCPU() {}

    public static void parse(String expression) {
        Scanner scanner = new Scanner(expression);
        CalcCPU.leftOperand = scanner.nextInt();
        CalcCPU.operation = scanner.next();
        CalcCPU.rightOperand = scanner.nextInt();

        if (!Arrays.asList("+", "-", "*", "/").contains(CalcCPU.operation)) {
            CalcCPU.leftOperand = CalcCPU.rightOperand = null;
            CalcCPU.operation = null;
        }
    }

    public static Integer calc() {
        if (CalcCPU.leftOperand == null || CalcCPU.rightOperand == null || CalcCPU.operation == null) {
            return null;
        }

        Integer result = null;

        switch (CalcCPU.operation) {
            case "+":
                result = CalcCPU.leftOperand + CalcCPU.rightOperand;
                break;
            case "-":
                result = CalcCPU.leftOperand - CalcCPU.rightOperand;
                break;
            case "*":
                result = CalcCPU.leftOperand * CalcCPU.rightOperand;
                break;
            case "/":
                if (CalcCPU.leftOperand != 0 && CalcCPU.rightOperand != 0) {
                    result = (int)(CalcCPU.leftOperand / CalcCPU.rightOperand);
                }

//                return (int)Math.floor(CalcCPU.leftOperand / CalcCPU.rightOperand);
                break;
        }

        return result;
    }
}
