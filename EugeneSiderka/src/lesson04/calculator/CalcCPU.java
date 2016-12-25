package lesson04.calculator;

/**
 * Created by snx on 12/25/16.
 */
public class CalcCPU {
    private CalcCPU() {}

    public static Integer calc(Integer leftOperand, String operationSign, Integer rightOperand) {
        switch (operationSign) {
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
