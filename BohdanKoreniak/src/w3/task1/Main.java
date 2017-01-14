package w3.task1;

import java.lang.reflect.Method;

/**
 * Created by Bohdan on 14.01.2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        for (Method method : String.class.getDeclaredMethods())
        {
            System.out.println(method.getName());
        }
    }
}
