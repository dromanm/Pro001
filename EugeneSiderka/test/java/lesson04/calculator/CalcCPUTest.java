package lesson04.calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Created by snx on 12/25/16.
 */
public class CalcCPUTest extends Assert {
    @Test
    public void testCalcAddition() {
        // Expected result must be equal to fact result
        assertEquals("Addition", 4, (int) CalcCPU.calc(2, "+", 2));
        // Expected result must be not equal to fact result
        assertNotEquals("Addition", 5, (int) CalcCPU.calc(2, "+", 2));
    }

    @Test
    public void testCalcSubstraction() {
        assertEquals("Substract", 0, (int) CalcCPU.calc(2, "-", 2));
        assertNotEquals("Substract", 5, (int) CalcCPU.calc(2, "-", 2));
    }

    @Test
    public void testCalcMultiply() {
        assertEquals("Multiply", 4, (int) CalcCPU.calc(2, "*", 2));
        assertNotEquals("Multiply", 5, (int) CalcCPU.calc(2, "*", 2));
    }

    @Test
    public void testCalcDivide() {
        assertEquals("Divide", 1, (int) CalcCPU.calc(2, "/", 2));
        assertNotEquals("Divide", 5, (int) CalcCPU.calc(2, "/", 2));
    }

    // (expected = <exception class>.class) - set expected exception
    @Test(expected = ArithmeticException.class)
    public void testCalcDivideByZero() {
        CalcCPU.calc(2, "/", 0);
    }

    @Test
    public void testCalcParse() {
        CalcCPU.parse("2 + 2 =");
        assertEquals("Left parsed operand", 2, (int) CalcCPU.leftOperand);
        assertEquals("Parsed operation sign", "+", CalcCPU.operation);
        assertEquals("Right parsed operand", 2, (int) CalcCPU.rightOperand);
    }

    @Test(expected = NoSuchElementException.class)
    public void testCalcParseEmptyExpression() {
        CalcCPU.parse("");
    }

    @Test(expected = InputMismatchException.class)
    public void testCalcParseWrongValues() {
        CalcCPU.parse("1.2 @ 3,4 =");
//        assertNull("Left parsed operand", CalcCPU.leftOperand);
//        assertNull("Parsed operation sign",CalcCPU.operation);
//        assertNull("Right parsed operand",CalcCPU.rightOperand);

        /**
         * fail() method can be used to fail test manually
         * ( try-catch > fail )
         */
    }
}
