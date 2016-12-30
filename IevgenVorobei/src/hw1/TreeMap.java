package hw1;

/**
 * Created by Жека on 12/18/2016.
 */
public class TreeMap<K extends Comparable, V>{

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

    public V remove(K key ) {
        Node <K, V > current = root;
        Node <K, V > parent = root;
        boolean isLeftChild = true;
        V returnvalue=root.value;


        while(key.compareTo(current.key)!=0){
            parent=current;
            if (key.compareTo(current.key)<0){
                isLeftChild= true;
                current=current.left;
            }else{isLeftChild = false;
                  current = current.right;
            }if(current==null)
                return null;
        }
        if (current.left==null && current.right==null){
            if (current==root) {
                root = null;
            }else if(isLeftChild) {
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if (current.right==null){
            if (current==root){
                root=current.left;
            }else if (isLeftChild){
                parent.left=current.left;
            }else { parent.right=current.left;
            }
        }else if(current.left==null){
            if(current==root){
                root=current.right;
            }else  if (isLeftChild){
                parent.left=current.right;
            }else{parent.right=current.right;}
        }else{
            Node <K, V> succesor = getSuccesor(current);
            if (current==root){
                root=succesor;
            }else if(isLeftChild){
                parent.left=succesor;
            }else{
                parent.right=succesor;

            }
        }
        return returnvalue;
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
    private Node <K,V> getSuccesor (Node <K, V> delNode){
        Node<K,V > succesorParent = delNode;
        Node<K,V > succesor = delNode;
        Node<K,V > current = delNode.right;

        while(current!=null){
            succesorParent=succesor;
            succesor=current;
            current=current.left;
        }
        if (succesor!=delNode.right){
            succesorParent.left=succesor.right;
            succesor.right=delNode.right;
        }
        return succesor;
    }

}

