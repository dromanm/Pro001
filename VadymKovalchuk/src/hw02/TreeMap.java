package hw02;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eriol4ik on 18/12/2016.
 */
public class TreeMap<K extends Comparable<K>, V> {
    private Node<K, V> root;

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> parent;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean add(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        if (root == null) {
            root = node;
            return true;
        }
        return findPosition(node, root);
    }

    public boolean find(K key) {
        return findKey(key, root);
    }

    public V get(K key) {
        return findValue(key, root);
    }

    public V remove(K key) {
        Node<K, V> nodeToRemove = getNodeToRemove(key, root);
        if (nodeToRemove == null) return null; // не нашли узла с заданным ключем -> возвращаем null (т.е. узел не найден)
        Node<K, V> parent = nodeToRemove.parent;
        boolean isLeft = false;
        if (parent != null) isLeft = (parent.left == nodeToRemove); // храним в переменной информацию, левым или правым потомком есть удаляемый узел

        if (nodeToRemove.left == null && nodeToRemove.right == null) { // удаляемый узел --- листовой
            if (nodeToRemove == root) { // если так, просто обнуляем ссылку корня -> получаем дерево без узлов
                root = null;
            } else if (isLeft) { // обнуляем ссылку родителя на удаляемый узел в зависимости от того, является он левым или правым потомком
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        else if (nodeToRemove.left == null) { // только правый потомок
            if (nodeToRemove == root) { // отдельный случай: удаляемый узел --- корень
                root = nodeToRemove.right;
            }
            else if (isLeft) { // теперь родитель удаляемого узла должен ссылаться на последующий узел после удаляемого
                parent.left = nodeToRemove.right;
            }
            else {
                parent.right = nodeToRemove.right;
            }
        } else if (nodeToRemove.right == null) { // только левый потомок (зеркальный случай к "только правый потомок")
            if (nodeToRemove == root) {
                root = nodeToRemove.left;
            }
            else if (isLeft) {
                parent.left = nodeToRemove.left;
            }
            else {
                parent.right = nodeToRemove.left;
            }
        }

        else { // в удаляемого узла есть левый и правый потомок
            Node<K, V> successor = getSuccessor(key, nodeToRemove);
            if (nodeToRemove == root) { // отдельный случай: удаляемый узел --- корень
                root = successor;
            }
            else if (isLeft) { // меняем ссылки родителя удаляемого узла: теперь потомками родителя есть преемник
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = nodeToRemove.left;

            if (successor != nodeToRemove.right) { // преемник --- один из левых наследников удаляемого узла => нужно поменять некоторые ссылки
                successor.parent.left = successor.right; // меняем ссылку родителя преемника с левого на правого потомка (так как мы берем самый левый потомок в качестве преемника, то у преемника может быть только правый потомок)
                successor.right = nodeToRemove.right; // ссылка на правый наследник как в удаляемого узла
            }
        }
        return nodeToRemove.value;
    }

    public Set<K> contains(V value) {
        Set<K> set = new HashSet<K>();
        visit(root, value, set);
        return set;
    }

    @Override
    public String toString() {
        return "[" + visitedFrom(root) + "]";
    }

    private boolean findPosition(Node<K, V> node, Node<K, V> root) {
        if (node.key.compareTo(root.key) < 0) {
            if (root.left == null) {
                root.left = node;
                node.parent = root;
                return true;
            } else {
                return findPosition(node, root.left);
            }
        }
        if (node.key.compareTo(root.key) > 0) {
            if (root.right == null) {
                root.right = node;
                node.parent = root;
                return true;
            } else {
                return findPosition(node, root.right);
            }
        }
        return false;
    }

    private boolean findKey(K key, Node<K, V> root) {
        if (root == null) return false;
        if (key.compareTo(root.key) == 0) return true;
        if (key.compareTo(root.key) > 0) return findKey(key, root.right);
        if (key.compareTo(root.key) < 0) return findKey(key, root.left);
        return false;
    }

    private V findValue(K key, Node<K, V> root) {
        if (root == null) return null;
        if (key.compareTo(root.key) == 0) return root.value;
        if (key.compareTo(root.key) > 0) return findValue(key, root.right);
        if (key.compareTo(root.key) < 0) return findValue(key, root.left);
        return null;
    }

    private Node<K, V> getNodeToRemove(K key, Node<K, V> root) {
        if (root == null) return null;
        if (key.compareTo(root.key) == 0) return root;
        if (key.compareTo(root.key) > 0) return getNodeToRemove(key, root.right);
        if (key.compareTo(root.key) < 0) return getNodeToRemove(key, root.left);
        return null;
    }

    private Node<K, V> getSuccessor(K key, Node<K, V> root) {
        if (root.right == null) {
            if (root.left != null) return root.left;
            else return null;
        }
        Node<K, V> successor = root.right;

        return min(successor);
    }

    private Node<K, V> min(Node<K, V> root) {
        if (root.left != null) return min(root.left);
        else return root;
    }

    private Node<K, V> max(Node<K, V> root) {
        if (root.right != null) return max(root.right);
        else return root;
    }

    private String visitedFrom(Node<K, V> node) {
        StringBuilder sb = new StringBuilder();
        if (node.left == null && node.right == null) {
            sb.append(node.key).append("=").append(node.value).append(", ");
            return sb.toString();
        }

        if (node.right == null) {
            sb.append(visitedFrom(node.left));
            sb.append(node.key).append("=").append(node.value);
            if (node != max(root)) sb.append(", ");
            return sb.toString();
        }

        if(node.left == null) {
            sb.append(node.key).append("=").append(node.value).append(", ");
            sb.append(visitedFrom(node.right));
            return sb.toString();
        }

        sb.append(visitedFrom(node.left));
        sb.append(node.key).append("=").append(node.value).append(", ");
        sb.append(visitedFrom(node.right));
        return sb.toString();
    }

    private void visit(Node<K, V> node, V value, Set<K> set) {
        if (node.left == null && node.right == null) {
            if (node.value.equals(value)) set.add(node.key);
            return;
        }
        if (node.right == null) {
            visit(node.left, value, set);
            if (node.value.equals(value)) set.add(node.key);
            return;
        }
        if (node.left == null) {
            if (node.value.equals(value)) set.add(node.key);
            visit(node.right, value, set);
            return;
        }

        visit(node.left, value, set);
        if (node.value.equals(value)) set.add(node.key);
        visit(node.right, value, set);
    }
}
