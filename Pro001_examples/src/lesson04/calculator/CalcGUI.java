package lesson04.calculator;

import java.util.Scanner;

/**
 * Created by IEvgen Boldyr on 25.12.16.
 */

public class CalcGUI {

    private Scanner scanner;

    public CalcGUI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        CalcCPU.parse(scanner.nextLine());
    }
}
