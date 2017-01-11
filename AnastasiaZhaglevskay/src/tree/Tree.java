package tree;

public class Tree<K extends Comparable, V> {

    private class Node<K, V>{
        private V value;
        private K key;

        private Node<K, V>  parent;
        private Node<K, V>  leftChld;
        private Node<K, V>  rightChld;

        public Node(K key, V value)  {
            this.value = value;
            this.key = key;
        }
    }

    private Node<K, V> root;

    public boolean add(K key, V value) {
        Node<K, V> node = new Node<>(key, value);

        if (root == null) {
            root = node;

            return true;
        }

        return findPos(node, root);
    }

    public boolean find(K key) {
        return findKey(key, root);
    }

    public V get(K key) {
        return findValue(key, root);
    }

    public V remove(K key){

        Node<K,V> curr = root;
        boolean leftChild = false;

        while (key.compareTo(curr.key) != 0){

            if (key.compareTo(curr.key) < 0){
                curr = curr.leftChld;
                leftChild = true;
            }else if (key.compareTo(curr.key) > 0){
                curr = curr.rightChld;
                leftChild = false;
            }
        }

        if (curr.leftChld == null && curr.rightChld == null){
            if (leftChild){
                curr.parent.leftChld = null;
            }else {
                curr.parent.rightChld = null;
            }

            return curr.value;
        }else if (curr.leftChld != null && curr.rightChld == null){
            if (leftChild){
                curr.parent.leftChld = curr.leftChld;
            }else {
                curr.parent.rightChld = curr.leftChld;
            }
            curr.parent = null;
            curr.leftChld = null;

            return curr.value;
        }else if (curr.leftChld == null && curr.rightChld != null){
            if (leftChild){
                curr.parent.leftChld = curr.rightChld;
            }else {
                curr.parent.rightChld = curr.rightChld;
            }
            curr.parent = null;
            curr.rightChld = null;

            return curr.value;
        }else {
            if (curr.key.compareTo(root.key) > 0) { // правая сторона дерева
                Node<K, V> max;

                if (!leftChild){
                    max = findMax(curr.leftChld);
                    curr.parent.rightChld = curr.leftChld;
                    max.rightChld = curr.rightChld;
                }else {
                    max = findMax(curr.rightChld);
                    curr.parent.leftChld = max;
                    if (curr.leftChld != null) {
                        max.leftChld = curr.leftChld;
                    }else {
                        max.rightChld = curr.rightChld;
                    }
                    max.parent.rightChld = null;
                }

                curr.parent = null;
                curr.leftChld = null;
                curr.rightChld = null;

                return curr.value;
            }else if (curr.key.compareTo(root.key) < 0){ // левая сторона
                Node<K, V> min;

                if (leftChild) {
                    min = findMin(curr.rightChld);
                    curr.parent.leftChld = curr.rightChld;
                    min.leftChld = curr.leftChld;
                }else {
                    min = findMin(curr.leftChld);
                    curr.parent.rightChld = min;
                    min.rightChld = curr.rightChld;
                    min.parent.leftChld = null;
                }

                curr.parent = null;
                curr.leftChld = null;
                curr.rightChld = null;

                return curr.value;
            }else { // удаляем корень
                Node<K, V> min = findMin(curr.rightChld);

                root.value = min.value;
                root.key = min.key;

                if (min.rightChld != null) { // если это родитель листика))
                    min.parent.leftChld = min.rightChld;
                    min.parent = null;
                    min.rightChld = null;
                }

                min.parent = null;

                return curr.value;
            }
        }
    }

    public Node<K, V> findMin(Node<K, V> node){
        if (node == null) return null;

        if (node.leftChld != null){
            return findMin(node.leftChld);
        }else if (node.leftChld == null){
            System.out.println("min = " + node.value);

            return node;
        }

        return null;
    }

    public Node<K, V> findMax(Node<K, V> node){
        if (node == null) return null;

        if (node.rightChld != null){
            return findMax(node.rightChld);
        }else if (node.rightChld == null){
            System.out.println("max = " + node.value);

            return node;
        }

        return null;
    }

    public boolean findPos(Node<K, V> node, Node<K, V> root){
        if (node.key.compareTo(root.key) < 0 && root.leftChld == null){
            root.leftChld = node;
            node.parent = root;

            return true;
        }else if (node.key.compareTo(root.key) > 0 && root.rightChld == null){
            root.rightChld = node;
            node.parent = root;

            return true;
        }else if (node.key.compareTo(root.key) > 0){ // key больше
            return findPos(node, root.rightChld);
        }else if (node.key.compareTo(root.key) < 0){
            return findPos(node, root.leftChld);
        }

        return false;
    }

    public boolean findKey(K key, Node<K, V> root){
        if (root == null) return false;
        if (key.compareTo(root.key) == 0){
            return true;
        } else if (key.compareTo(root.key) < 0) {
            return findKey(key, root.leftChld);
        } else if (key.compareTo(root.key) > 0) {
            return findKey(key, root.rightChld);
        }

        return false;
    }

    public V findValue(K key, Node<K, V> root){
        if (root == null) return null;
        if (key.compareTo(root.key) == 0){
            return root.value;
        }else if (key.compareTo(root.key) < 0){
            return findValue(key, root.leftChld);
        }else if (key.compareTo(root.key) > 0){
            return findValue(key, root.rightChld);
        }

        return null;
    }

    public String print(Node<K, V> node){
        if (node != null) {
            return print(node.leftChld) + node.key.toString() + " " + print(node.rightChld);
        }

        return "";
    }

    public String toString(){
        return print(root);
    }


}

