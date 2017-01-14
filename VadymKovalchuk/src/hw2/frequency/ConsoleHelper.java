package hw2.frequency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by eriol4ik on 14/01/2017.
 */
public class ConsoleHelper {
    public static String readString(String msg) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(msg);
        try {
            return br.readLine();
        } catch (IOException ioe) {
            System.out.println("Please try again.");
            return readString(msg);
        }
    }
}
