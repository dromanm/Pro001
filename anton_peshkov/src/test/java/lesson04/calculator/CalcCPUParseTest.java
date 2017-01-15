package lesson04.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 25.12.16.
 */
public class CalcCPUParseTest extends Assert{

    @Test
    public void parseTest(){
        CalcCPU.parse("123 gki 021");
        assertEquals("first",new Integer(123) , CalcCPU.first);
        assertEquals("second",new Integer(21) , CalcCPU.second);
        assertEquals("operation","gki" , CalcCPU.operation);

    }
}
