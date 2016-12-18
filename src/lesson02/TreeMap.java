package lesson02;

import java.util.Vector;

/**
 * Created by IEvgen Boldyr on 18.12.16.
 */
public class TreeMap<K extends Comparable, V> {

    private class Node<K, V> {
        private K key;
        private V value;

        private Node<K,V> parent;
        private Node<K,V> left;
        private Node<K,V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V> root;

    public boolean add(K key, V value) {
        Node<K, V> nd = new Node<>(key, value);
        if (root == null) {
            root = nd;
            return true;
        }
        return findPosition(root, nd);
    }

    public boolean find(K key) {
        return findKey(key, root);
    }

    public V get(K key) {
        return findValue(key, root);
    }

    public V remove(K key) {

        return null;
    }

    private boolean findPosition(Node<K, V> root, Node<K, V> nd) {
        if (nd.key.compareTo(root.key) < 0 & root.left == null) {
            root.left = nd;
            nd.parent = root;
            return true;
        } else if (nd.key.compareTo(root.key) > 0 & root.right == null) {
            root.right = nd;
            nd.parent = root;
            return true;
        } else if (nd.key.compareTo(root.key) < 0) {
            return findPosition(root.left,nd);
        } else if (nd.key.compareTo(root.key) > 0) {
            return findPosition(root.right, nd);
        }
        return false;
    }

    private boolean findKey(K key, Node<K, V> root) {
        if (root == null) return false;
        if (key.compareTo(root.key) == 0) {
            return true;
        } else if (key.compareTo(root.key) < 0) {
            return findKey(key, root.left);
        } else if (key.compareTo(root.key) > 0) {
            return findKey(key, root.right);
        }
        return false;
    }

    private V findValue(K key, Node<K, V> root) {
        if (root == null) return null;
        if (key.compareTo(root.key) == 0) {
            return root.value;
        } else if (key.compareTo(root.key) < 0) {
            return findValue(key, root.left);
        } else if (key.compareTo(root.key) > 0) {
            return findValue(key, root.right);
        }
        return null;
    }
}
