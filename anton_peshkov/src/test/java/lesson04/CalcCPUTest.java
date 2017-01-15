package lesson04;

import lesson04.CalcCPU;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 25.12.16.
 */
public class CalcCPUTest extends Assert {

    @Test
    public void testCalcAddition(){
        assertEquals("sum", 4, CalcCPU.calc(2,"+",2));
        assertNotEquals("sum2", 5, CalcCPU.calc(2,"+",2));

        assertEquals("substraction", 0, CalcCPU.calc(2,"-",2));
        assertNotEquals("substraction2", 5, CalcCPU.calc(2,"-",2));

        assertEquals("multiplication", 4, CalcCPU.calc(2,"*",2));
        assertNotEquals("multiplication2", 5, CalcCPU.calc(2,"*",2));

        assertEquals("divide", 1, CalcCPU.calc(2,"/",2));
        assertNotEquals("divide2", 5, CalcCPU.calc(2,"/",2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero(){
        CalcCPU.calc(12,"/",0);
    }

}
