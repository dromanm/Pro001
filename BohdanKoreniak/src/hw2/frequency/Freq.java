package hw2.frequency;

import hw2.authentication.ConsoleManager;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Bohdan on 12.01.2017.
 */
public class Freq
{
    private String text;

    private Map<String, Long> mapWordsByFrequency = new HashMap<>();

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

    private void collectWordsByFrequency()
    {
        if (!mapWordsByFrequency.isEmpty())
        {
            return;
        }

        Stream<String> stream = Stream.of(text.toLowerCase().split("[^\\d\\w']+"));

        mapWordsByFrequency = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
    }

    public Set<String> getWordsByFrequency(int frequency)
    {
        collectWordsByFrequency();

        Set<String> words = new HashSet<>();

        mapWordsByFrequency.forEach((key, value) ->
        {
            if (value.intValue() == frequency)
            {
                words.add(key);
            }
        });

        return words;
    }

    public Set<String> getWordsByFrequencyLessThan(int frequency)
    {
        collectWordsByFrequency();

        Set<String> words = new HashSet<>();

        mapWordsByFrequency.forEach((key, value) ->
        {
            if (value.intValue() < frequency)
            {
                words.add(key);
            }
        });

        return words;
    }

    public Set<String> getWordsByFrequencyMoreThan(int frequency)
    {
        collectWordsByFrequency();

        Set<String> words = new HashSet<>();

        mapWordsByFrequency.forEach((key, value) ->
        {
            if (value.intValue() > frequency)
            {
                words.add(key);
            }
        });

        return words;
    }

    public void printAcs()
    {
        collectWordsByFrequency();

        mapWordsByFrequency.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry ->
        {
            ConsoleManager.printText(entry.getKey() + "\t" + entry.getValue());
        });
    }

    public void printDesc()
    {
        collectWordsByFrequency();

        mapWordsByFrequency.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(entry ->
        {
            ConsoleManager.printText(entry.getKey() + "\t" + entry.getValue());
        });
    }

    public static void main(String[] args)
    {
        Freq freq = new Freq();

        try
        {
            ConsoleManager.printText(freq.setTextFromFile("src/hw2/frequency/lyrics.txt"));
            ConsoleManager.printText("");

            freq.printAcs();
            ConsoleManager.printText("");

            freq.printDesc();
            ConsoleManager.printText("");
        }
        catch (IOException e)
        {
            ConsoleManager.printText(e.getMessage());
        }
    }
}
