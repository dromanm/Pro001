package lesson02;

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

    public boolean add(K key, V value) {

        return false;
    }

    public boolean find(K key) {

        return false;
    }

    public V get(K key) {

        return null;
    }

    public V remove(K key) {

        return null;
    }
}
