package lesson2;

/**
 * Created by george on 18.12.16.
 */
public class NodeList<K extends Comparable, V> {

    private Node<K,V> head;

    public Node<K,V> first;
    public Node<K,V> last;

    public boolean add(Node<K,V> node){
        if(head==null){
            head = node;
            return true;
        }
        return findPosition(node, head);


    }

    private boolean findPosition(Node<K, V> node, Node<K, V> head) {
        if(head.getKey().compareTo(node.getKey())>0 & head.getRight()==null){
            head.setRight(node);
            node.setParent(head);
        }else if(head.getKey().compareTo(node.getKey())<0 & head.getLeft()==null) {
            head.setLeft(node);
            node.setParent(head);
        }else if(head.getLeft().getKey().compareTo(node.getKey())>0){
            return findPosition(node, head.getLeft());
        }else if(head.getRight().getKey().compareTo(node.getKey())<0){
            return findPosition(node, head.getRight());
        }
        return false;
    }

}
