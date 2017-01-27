package w5.chat.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bohdan on 02.11.2016.
 */
public class ConsoleManager
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void showMessage(String text)
    {
        System.out.println(text);
    }

    public static String readString()
    {
        try
        {
            return bufferedReader.readLine();
        }
        catch (IOException e)
        {
        }
        return readString();
    }

    public static int readInt()
    {
        try
        {
            return Integer.parseInt(readString());
        }
        catch (NumberFormatException e)
        {
            showMessage("Entered string is not valid number");
        }
        return readInt();
    }
}
