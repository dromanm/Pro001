package w2.lesson4.task1.calculator.view;

import w2.lesson4.task1.calculator.controller.CalculatorController;
import w2.lesson4.task1.calculator.model.managers.ConsoleManager;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class CalculatorView
{
    private CalculatorController controller;

    public CalculatorView(CalculatorController controller)
    {
        this.controller = controller;
        init();
    }

    public void init()
    {
        ConsoleManager.printText("Welcome to calculator 9000! Please, begin your calculations\n");
    }

    public void showMenu()
    {
        ConsoleManager.printText("Enter expression as showed in example below and press 'Enter' to calculate or enter 'exit' to exit program");
        ConsoleManager.printText("13 + 56 =");
        ConsoleManager.printText("Your expression:");

        controller.getModel().setExpression(ConsoleManager.readString());

        ConsoleManager.printText("");
    }

    public void showCalculationResult()
    {
        ConsoleManager.printText("Calculation result:");
        ConsoleManager.printText(controller.getModel().getNumResult().toString() + "\n");
    }

    public void showMessage(String message)
    {
        ConsoleManager.printText(message + "\n");
    }
}
