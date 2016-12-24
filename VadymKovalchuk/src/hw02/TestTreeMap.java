package hw02;

/**
 * Created by eriol4ik on 18/12/2016.
 */
public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        System.out.println("add element with key = 50: " + treeMap.add(50, "1"));
        System.out.println("add element with key = 35: " + treeMap.add(35, "2"));
        System.out.println("add element with key = 65: " + treeMap.add(65, "3"));
        System.out.println("add element with key = 25: " + treeMap.add(25, "4"));
        System.out.println("add element with key = 40: " + treeMap.add(40, "5"));
        System.out.println("add element with key = 55: " + treeMap.add(55, "6"));
        System.out.println("add element with key = 38: " + treeMap.add(38, "7"));
        System.out.println("add element with key = 45: " + treeMap.add(45, "8"));
        System.out.println("add element with key = 37: " + treeMap.add(37, "9"));
        System.out.println("add element with key = 44: " + treeMap.add(44, "10"));
        System.out.println("add element with key = 67: " + treeMap.add(67, "11"));
        System.out.println("add element with key = 70: " + treeMap.add(70, "11"));
        System.out.println("add element with key = -2: " + treeMap.add(-2, "11"));
        System.out.println("add element with key = -19: " + treeMap.add(-19, "11"));
        System.out.println("add element with key = 25: " + treeMap.add(25, "11"));
        System.out.println("add element with key = 69: " + treeMap.add(69, "12"));

        System.out.println("remove element with key = 40: " + treeMap.remove(40));
        System.out.println("remove element with key = 55: " + treeMap.remove(55));
        System.out.println("find element with key = 40: " + treeMap.find(40));
        System.out.println("find element with key = 38: " + treeMap.find(38));
        System.out.println("find element with key = 55: " + treeMap.find(55));
        System.out.println("get element with key = 40: " + treeMap.get(40));
        System.out.println("get element with key = 65: " + treeMap.get(65));

        System.out.println(treeMap.toString());

        System.out.println(treeMap.contains("11"));

    }
}
