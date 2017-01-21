package lesson04.calculator;

//Желательно контролировать импорты
//компоненты junit.framework.* не
//рекомендованы к использованию.
import lesson04.calculator.CalcCPU;
import org.junit.Assert;
import org.junit.Test;

import java.util.InputMismatchException;

/**
 * Created by IEvgen Boldyr on 25.12.16.
 */

public class CalcCPUTest extends Assert {

    /*Тест кейсы к методу calc()*/
    @Test(timeout = 50)
    public void testCalcAddition() {
        //Ожидаемый результат должен быть равен фактическому
        assertEquals("Сложение", 4, (int) CalcCPU.calc(2, "+", 2));
        //Ожидаемый результат не должен быть равен фактическому
        assertNotEquals("Сложение", 5, (int) CalcCPU.calc(2, "+", 2));
    }

    @Test
    public void testCalcSubtraction() {
        assertEquals("Вычитание", 4, (int) CalcCPU.calc(6, "-", 2));
        assertNotEquals("Вычитание", 4, (int) CalcCPU.calc(6, "-", 3));
    }

    @Test
    public void testCalcMultiplication() {
        assertEquals("Умножение", 4, (int) CalcCPU.calc(2, "*", 2));
        assertNotEquals("Умножение", 12, (int) CalcCPU.calc(6, "*", 3));
    }

    @Test
    public void testCalcDivision() {
        assertEquals("Деление", 4, (int) CalcCPU.calc(8, "/", 2));
        assertNotEquals("Деление", 12, (int) CalcCPU.calc(6, "/", 3));
    }

    //excepted = <Класс исключения>.class - Указываем ожидаемое исключение
    @Test(expected = ArithmeticException.class)
    public void testCalcDivisionByZero() {
        CalcCPU.calc(6, "/", 0);
    }

    /*Тест кейсы к методу parse()*/
    @Test
    public void parseOkTest() {
        CalcCPU.parse("2 + 3");
        assertEquals("Проверка первого операнда ", 2, (int) CalcCPU.first);
        assertEquals("Проверка проверка операции", "+", CalcCPU.operation);
        assertEquals("Проверка первого операнда ", 3, (int) CalcCPU.second);
    }

    @Test
    public void parseFailTest() {
        CalcCPU.parse("4 - 7");
        assertNotEquals("Проверка первого операнда ", 5, (int) CalcCPU.first);
        assertNotEquals("Проверка проверка операции", "*", CalcCPU.operation);
        assertNotEquals("Проверка первого операнда ", 8, (int) CalcCPU.second);
    }

    @Test(expected = InputMismatchException.class)
    public void parseInputMismatchExceptionTest() {
        CalcCPU.parse("s4 - 7");
    }

    @Test
    public void parseInputMismatchExcTest() {
        try {
            CalcCPU.parse("s5 - 7");
            CalcCPU.parse("4 - J7");
        } catch (InputMismatchException exc) {
            fail("Сгенерировано не обработанное исключение");
        }
    }
}
