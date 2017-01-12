package hw2.frequency;

import hw2.authentication.ConsoleManager;

import java.io.IOException;
import java.util.Random;

/**
 * Created by Bohdan on 12.01.2017.
 */
public class Freq
{
    private String text;

    public String setTextFromConsole()
    {
        return text = ConsoleManager.readString();
    }

    public String setTextFromFile(String fileName) throws IOException
    {
        return text = FileManager.readText(fileName);
    }

    public String generateRandomText(int textLength)
    {
        String stringSigns = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ,.!?\n";

        StringBuilder stringBuilder = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < textLength; i++)
        {
            stringBuilder.append(stringSigns.charAt(random.nextInt(stringSigns.length())));
        }

        return text = stringBuilder.toString();
    }
}
