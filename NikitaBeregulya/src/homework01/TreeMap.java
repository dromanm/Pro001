package homework01;

/**
 * Created by Никита on 24.12.2016. pls commit
 */

public class TreeMap<K extends Comparable, V> {

    private class Node<K, V> {

        private K key;
        private V value;

        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private Node<K, V> root;

    public boolean add(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node<K, V> current = root;
            Node<K, V> parent;
            while (true) {
                parent = current;
                if (key.compareTo(current.key) < 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return true;
                    }
                } else if (key.compareTo(current.key) > 0) {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find(K key) {
        Node<K, V> current = root;
        while (key.compareTo(current.key) != 0) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public V get(K key) {
        Node<K, V> current = root;
        while (key.compareTo(current.key) != 0) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current.value;
    }

    public V remove(K key) {
        Node<K, V> current = root;
        Node<K, V> parent = root;
        boolean isLeft = true;
        while (key.compareTo(current.key) != 0) {
            parent = current;
            if (key.compareTo(current.key) < 0) {
                isLeft = true;
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                isLeft = false;
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeft) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeft){
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        return null;
    }

}
