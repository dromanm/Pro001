package tree;

public class Main_tree {

    public static void main(String[] args) {

        // Node<K, V>
        Tree<Integer, Integer> tree = new Tree<>();
        tree.add(30, 30);
        //left
        tree.add(25, 25);
        tree.add(27, 27);
        tree.add(26, 26);
        tree.add(21, 21);
        tree.add(23, 23);
        tree.add(22, 22);
        tree.add(24, 24);
        tree.add(19, 19);
        //right
        tree.add(35, 35);
        tree.add(33, 33);
        tree.add(34, 34);
        tree.add(49, 49);
        tree.add(50, 50);
        tree.add(47, 47);
        tree.add(46, 46);
        tree.add(45, 45);
        tree.add(48, 48);

        System.out.println(tree.toString());

        System.out.println("Find key:     " + "Key = 26  -> " + tree.find(26));
        System.out.println("Find Value:   " + "Key = 21, Value -> " + tree.get(21));
        System.out.println("Delete:       " + "Key = 23, Value -> " + tree.remove(23));

        System.out.println(tree.toString());

    }
}
