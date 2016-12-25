package lesson04.calculator;

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
        leftOperand = scanner.nextInt();
        operation = scanner.next();
        rightOperand = scanner.nextInt();
    }

    public static Integer calc() {
        switch (operation) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
        }

        return null;
    }
}
