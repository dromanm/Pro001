package w2.lesson4.task1.calculator.controller;

import w2.lesson4.task1.calculator.model.CalcCPU;
import w2.lesson4.task1.calculator.model.CalculatorModel;
import w2.lesson4.task1.calculator.model.OperationType;
import w2.lesson4.task1.calculator.view.CalculatorView;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class CalculatorController
{
    private CalculatorModel model = new CalculatorModel();
    private CalculatorView view = new CalculatorView(this);

    public CalculatorModel getModel() {
        return model;
    }

    public void performAddition()
    {
        model.setNumResult(CalcCPU.calc(model.getNumFirst(), model.getNumSecond(), OperationType.ADDITION));
    }

    public void performSubstraction()
    {
        model.setNumResult(CalcCPU.calc(model.getNumFirst(), model.getNumSecond(), OperationType.SUBSTRACTION));
    }

    public void performMultiplication()
    {
        model.setNumResult(CalcCPU.calc(model.getNumFirst(), model.getNumSecond(), OperationType.MULTIPLICATION));
    }

    public void performDivision()
    {
        model.setNumResult(CalcCPU.calc(model.getNumFirst(), model.getNumSecond(), OperationType.DIVISION));
    }

    public void calculateExpression()
    {
        String expression = model.getExpression();
        expression = expression.replaceAll(" ", "");

        if (!expression.matches("\\d+[\\+\\-\\/\\*]\\d+\\="))
        {
            throw new IllegalArgumentException("Expression does`t match expression pattern");
        }

        String[] numbers = expression.split("[\\+\\-\\*\\/\\=]");

        model.setNumFirst(Integer.parseInt(numbers[0]));
        model.setNumSecond(Integer.parseInt(numbers[1]));

        switch (expression.replaceAll("[\\d\\=]", ""))
        {
            case "+":
            {
                performAddition();
                break;
            }
            case "-":
            {
                performSubstraction();
                break;
            }
            case "*":
            {
                performMultiplication();
                break;
            }
            case "/":
            {
                performDivision();
                break;
            }
        }
    }

    public void run()
    {
        while (true)
        {
            view.showMenu();

            if (model.getExpression().equals("exit"))
            {
                break;
            }

            try
            {
                calculateExpression();
                view.showCalculationResult();
            }
            catch (IllegalArgumentException e)
            {
                view.showMessage(e.getMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        CalculatorController controller = new CalculatorController();
        controller.run();
    }
}
