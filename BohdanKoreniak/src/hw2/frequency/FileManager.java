package hw2.frequency;

import java.io.*;

/**
 * Created by Bohdan on 17.12.2016.
 */
public class FileManager
{
    public static void saveObject(Object object, String fileName) throws IOException
    {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        }
    }

    public static Object readObject(String fileName) throws IOException, ClassNotFoundException
    {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName)))
        {
            return objectInputStream.readObject();
        }
    }

    public static String readText(String fileName) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
        {
            bufferedReader.lines().forEach(s -> stringBuilder.append(s).append("\n"));
        }

        return stringBuilder.toString();
    }
}
