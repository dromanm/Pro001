package hw1.tree_map;

import java.util.ArrayList;

/**
 * Created by eriol4ik on 20/12/2016.
 */
public class TreeMapVsOther {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        java.util.TreeMap<Integer, String> treeMapUtil = new java.util.TreeMap<>();

        System.out.println("Добавление элементов:");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            arrayList.add("a");
        }
        long end = System.currentTimeMillis();
        long arrayListTime = end - start;


        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            treeMap.add(i, Integer.toString((int)(Math.random() * 1_000_000)));
//            treeMap.add((int)(Math.random() * 10_000), "a");
        }
        end = System.currentTimeMillis();
        long treeMapTime = end - start;

        start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) {
            treeMapUtil.put(i, Integer.toString((int)(Math.random() * 1_000_000)));
//            treeMapUtil.put((int)(Math.random() * 10_000), "a");
        }
        end = System.currentTimeMillis();
        long treeMapUtilTime = end - start;

        System.out.println(arrayListTime);
        System.out.println(treeMapTime);
        System.out.println(treeMapUtilTime);
    }
}
