package w2.lesson4.task1.calculator.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class CalcCPUTest extends Assert
{
    @Test(timeout = 1)
    public void testCalcAddition()
    {
        //Expected result should be equal to actual result
        assertEquals("Addition", 4, (int) CalcCPU.calc(2, 2, OperationType.ADDITION));
        assertEquals("Addition", 45, (int) CalcCPU.calc(13, 32, OperationType.ADDITION));
        //Expected result should`t be equal to actual result
        assertNotEquals("Addition", 5, (int) CalcCPU.calc(2, 2, OperationType.ADDITION));
    }

    @Test
    public void testCalcSubstraction()
    {
        assertEquals("Substraction", 9, (int) CalcCPU.calc(19, 10, OperationType.SUBSTRACTION));
        assertEquals("Substraction", -2, (int) CalcCPU.calc(8, 10, OperationType.SUBSTRACTION));
        assertNotEquals("Substraction", 5, (int) CalcCPU.calc(6, 2, OperationType.SUBSTRACTION));
    }

    @Test
    public void testCalcMultiplication()
    {
        assertEquals("Multiplication", 27, (int) CalcCPU.calc(9, 3, OperationType.MULTIPLICATION));
        assertEquals("Multiplication", 12, (int) CalcCPU.calc(4, 3, OperationType.MULTIPLICATION));
        assertNotEquals("Multiplication", 8, (int) CalcCPU.calc(5, 2, OperationType.MULTIPLICATION));
    }

    @Test
    public void testCalcDivision()
    {
        assertEquals("Division", 5, (int) CalcCPU.calc(25, 5, OperationType.DIVISION));
        assertEquals("Division", 9, (int) CalcCPU.calc(27, 3, OperationType.DIVISION));
        assertNotEquals("Division", 12, (int) CalcCPU.calc(28, 2, OperationType.DIVISION));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero()
    {
        CalcCPU.calc(24, 0, OperationType.DIVISION);
    }
}
