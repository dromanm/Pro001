package homework01;

/**
 * Created by Никита on 24.12.2016.ffff
 */
public class Test {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.add(50, "aaa");
        treeMap.add(25, "bbb");
        treeMap.add(75, "ccc");

        String result = treeMap.get(25);
        if (result != null) {
            System.out.println("Found the node with key 25");
        } else {
            System.out.println("Could not find node with key 25");
        }

    }

}
