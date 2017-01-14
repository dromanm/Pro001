package hw2.authentication;


import java.util.Set;
import java.util.TreeSet;
/**
 * Created by JL on 24.12.2016.****
 */
public class TreeMap<K extends Comparable, V> {

    private class Node<K,V> {
        private K key;
        private V value;
        private Node<K,V> parent;
        private Node<K,V> right;
        private Node<K,V> left;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K,V> root;

    public boolean add(K key, V value) {
        Node<K,V> node = new Node<>(key, value);
        if (root == null) {
            root = node;
            return true;
        }
        return addNode(node, root);
    }

    public boolean find(K key) {

        return findNode(key, root);
    }

    public V get(K key) {

        return getValue(key, root);
    }

    public V remove(K key) {

        Node <K,V> node = findNodeKV(key, root);

        if (node == null) return null;

        if (node.equals(root) & (root.left == null || root.right== null)) {
            V returnValue = root.value;
            if (root.left == null & root.right == null) root = null;
            else if(root.left == null & root.right != null) {

                root.right.parent = null;
                root = root.right;
            } else if (root.left != null & root.right == null) {
                root.left.parent = null;
                root = root.left;
            }
            return  returnValue;
        }

        if (node.right == null & node.left == null) {
            if (node.equals(node.parent.left))   node.parent.left = null;
            else    node.parent.right = null;
            return node.value;

        } else if (node.left == null & node.right != null) {
            if (node.equals(node.parent.left)) {
                node.parent.left = node.right;
                node.right.parent = node.parent;
            } else {
                node.parent.right = node.right;
                node.right.parent = node.parent;
            }
            return node.value;

        } else if (node.left != null & node.right == null) {
            if (node.equals(node.parent.left)) {
                node.parent.left = node.left;
                node.left.parent = node.parent;
            } else {
                node.parent.right = node.left;
                node.left.parent = node.parent;
            }
            return node.value;

        } else if (node.left != null & node.right != null) {
            V returnValue = node.value;
            Node<K,V> min = findMin(node.right);
            remove(min.key);
            node.key = min.key;
            node.value = min.value;
            return returnValue;
        }
        return null;
    }

    private boolean addNode(Node<K,V> node, Node<K,V> root) {
        if (node.key.compareTo(root.key) < 0 & root.left == null) {
            root.left = node;
            node.parent = root;
            return true;
        } else if (node.key.compareTo(root.key) > 0 & root.right == null) {
            root.right = node;
            node.parent = root;
            return false;
        } else if (node.key.compareTo(root.key) < 0) {
            return addNode(node, root.left);
        } else if (node.key.compareTo(root.key) > 0) {
            return addNode(node, root.right);
        }
        return false;
    }

    public String toString() {
        return print(root);
    }

    private String print(Node<K,V> node) {
        if (node != null) {
            return print(node.left)  + node.key.toString() + " "  + print(node.right);
        }
        return "";
    }

    private boolean findNode(K key, Node<K,V> root) {
        if (root == null) return false;
        if (key.compareTo(root.key) == 0) return true;

        if (key.compareTo(root.key) < 0) {
            return findNode(key, root.left);
        } else if (key.compareTo(root.key) > 0) {
            return findNode(key, root.right);
        }
        return false;
    }
    private V getValue(K key, Node<K,V> root) {
        if (root == null) return null;
        if (key.compareTo(root.key) == 0) return root.value;

        if (key.compareTo(root.key) < 0) {
            return getValue(key, root.left);
        } else if (key.compareTo(root.key) > 0) {
            return getValue(key, root.right);
        }
        return null;
    }

    public Node<K,V> findMax(Node<K,V> node) {
        if (node == null) return null;
        if (node.right != null) {
            return findMax(node.right);
        } else if (node.right == null) {
            return node;
        }
        return null;
    }

    public Node<K,V> findMin(Node<K,V> node) {
        if (node == null) return null;
        if (node.left != null) {
            return findMin(node.left);
        } else if (node.left == null) {
            return node;
        }
        return null;
    }

    private Node<K,V> findNodeKV(K key, Node<K,V> root) {
        if (root == null) return null;
        if (key.compareTo(root.key) == 0) return root;

        if (key.compareTo(root.key) < 0) {
            return findNodeKV(key, root.left);
        } else if (key.compareTo(root.key) > 0) {
            return findNodeKV(key, root.right);
        }
        return null;
    }

    public Set<K> contains(V value) {
        Set<K> setKeys = new TreeSet<K>();
        return containsValues(value, root, setKeys);
    }


    private Set<K> containsValues(V value, Node<K,V> root, Set<K> setKeys) {

        if (root == null) return null;
        if (value == root.value)    setKeys.add(root.key);

        containsValues(value, root.left, setKeys);
        containsValues(value, root.right, setKeys);
        return setKeys;
    }

}


