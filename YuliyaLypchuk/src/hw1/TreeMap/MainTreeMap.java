package hw1.TreeMap;

/**
 * Created by JL on 24.12.2016.
 */
public class MainTreeMap {
    public static void main(String[] args) {

        TreeMap<Integer, Integer>  tree = new TreeMap<Integer, Integer>();

        tree.add(22,22);
        tree.add(19,19);
        tree.add(16,16);
        tree.add(20,20);

        System.out.println(tree.toString());
        System.out.println(tree.remove(22));
        System.out.println(tree.remove(19));
        System.out.println(tree.remove(16));
        System.out.println(tree.remove(20));

        System.out.println(tree.toString());

        tree.add(15,1);
        tree.add(25,1);
        tree.add(5,132);
        tree.add(9,8);
        tree.add(12,8);
        tree.add(20,8);
        tree.add(4,2);
        tree.add(13,1);
        tree.add(14,14);
        tree.add(19,19);
        tree.add(6,6);
        tree.add(7,7);

        System.out.println(tree.toString());
        System.out.println("Remove Key = 15, Value = " + tree.remove(15));
        System.out.println(tree.toString());

        System.out.println("Contains: " + tree.contains(1).toString());
        System.out.println("Contains: " + tree.contains(8).toString());
        System.out.println("Find: " + tree.find(6));
        System.out.println("Get: " + tree.get(13));
    }
}
