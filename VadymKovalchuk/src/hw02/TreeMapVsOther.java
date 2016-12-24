package hw02;

import java.util.ArrayList;

/**
 * Created by eriol4ik on 20/12/2016.
 */
public class TreeMapVsOther {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        java.util.TreeMap<Integer, String> treeMapUtil = new java.util.TreeMap<>();

        System.out.println("Добавление элементов в конец");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            arrayList.add("a");
        }
        long end = System.currentTimeMillis();
        long arrayListTime = end - start;


        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            treeMap.add((int)(Math.random() * 10_000), "a");
//            treeMap.add(i, Integer.toString((int)(Math.random() * 1_000_000)));
        }
        end = System.currentTimeMillis();
        long treeMapTime = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            treeMapUtil.put((int)(Math.random() * 10_000), "a");
//            treeMap.add(i, Integer.toString((int)(Math.random() * 1_000_000)));
        }
        end = System.currentTimeMillis();
        long treeMapUtilTime = end - start;
        System.out.println(arrayListTime);
        System.out.println(treeMapTime);
        System.out.println(treeMapUtilTime);
//        System.out.println(treeMap.toString());
    }
}
