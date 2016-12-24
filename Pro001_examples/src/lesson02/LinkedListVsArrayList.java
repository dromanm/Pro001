package lesson02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IEvgen Boldyr on 18.12.16.
 */
public class LinkedListVsArrayList {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        List<Integer> linked = new LinkedList<>();

        System.out.println("Добавление элементов: " );

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            array.add((int)(Math.random() * 10_000));
        }
        long end = System.currentTimeMillis();
        long arrayTime = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            linked.add((int)(Math.random() * 10_000));
        }
        end = System.currentTimeMillis();
        long linkedTime = end - start;

        System.out.println("ArrayList time: " + arrayTime);
        System.out.println("LinkedList time: " + linkedTime);
        System.out.println(arrayTime > linkedTime ? "Linked WIN" : "Array WIN");

        System.out.println("Добавление элементов в произвольное место:");

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            array.add((int) (Math.random() * 999_999), 10_000);
        }
        end = System.currentTimeMillis();
        arrayTime = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            linked.add((int) (Math.random() * 999_999), 10_000);
        }
        end = System.currentTimeMillis();
        linkedTime = end - start;

        System.out.println("ArrayList time: " + arrayTime);
        System.out.println("LinkedList time: " + linkedTime);
        System.out.println(arrayTime > linkedTime ? "Linked WIN" : "Array WIN");

        System.out.println("Удаление элементов:");
        start = System.currentTimeMillis();
        array.remove(0);
        //array.remove(500_000);
        end = System.currentTimeMillis();
        arrayTime = end - start;

        start = System.currentTimeMillis();
        linked.remove(0);
        //linked.remove(500_000);
        end = System.currentTimeMillis();
        linkedTime = end - start;

        System.out.println("ArrayList time: " + arrayTime);
        System.out.println("LinkedList time: " + linkedTime);
        System.out.println(arrayTime > linkedTime ? "Linked WIN" : "Array WIN");
    }
}
