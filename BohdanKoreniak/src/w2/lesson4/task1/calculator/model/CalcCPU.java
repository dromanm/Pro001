package w2.lesson4.task1.calculator.model;

/**
 * Created by Bohdan on 25.12.2016.
 */
public class CalcCPU
{
    private CalcCPU()
    {

    }

    public static Integer calc(Integer numFirst, Integer numSecond, OperationType operation)
    {
        switch (operation)
        {
            case ADDITION:
            {
                return numFirst + numSecond;
            }
            case SUBSTRACTION:
            {
                return numFirst - numSecond;
            }
            case MULTIPLICATION:
            {
                return numFirst * numSecond;
            }
            case DIVISION:
            {
                return numFirst / numSecond;
            }
            default:
            {
                return null;
            }
        }
    }
}
