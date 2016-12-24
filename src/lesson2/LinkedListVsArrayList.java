package lesson2;


import java.util.*;

/**
 * Created by george on 18.12.16.
 */
public class LinkedListVsArrayList {

    public static void main(String[] args) {

//        NodeList<Integer, String> n = new NodeList<>();
//        System.out.println(n.add(new Node<Integer, String>(1,"Name")));
//        System.out.println(n.add(new Node<Integer, String>(2,"Name")));
//        System.out.println(n.add(new Node<Integer, String>(2,"Name")));


        Queue<Integer> q = new ArrayDeque<>();
        q.add(4);

        Set<Double> set = new HashSet<>();
        set.add((Double) (Math.random()*10000000));
        System.out.println(set);

    }
}
