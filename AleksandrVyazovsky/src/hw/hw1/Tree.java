package hw.hw1;

import java.util.Stack;

/**
 * Created by Олег on 26.12.2016.
 */
public class Tree {
    private Node root; //first node of tree

    public Tree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current.iData != key) {
            if (key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            if (current == null)
                return false;

        }

        //Если узел не имеет потомков он просто удаляется
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;


        }

        //Если нет правого потомка, узел заменяется левым поддеревом
        else if (current.rightChild == null)
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.rightChild;

            //Если нет левого потомка, узел заменяется левым поддеревом
        else if (current.leftChild == null)
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.rightChild;

        else //два потомка, узел заменяется приемником
        {
            // Поиск приемника для узла (current)
            Node successor = getSuccessor(current);

            //Родитель current связывается с посредником
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // Преемник свызывается с левым потомком current



        }
        return true; //Признак успешного завершения
    }

//-----------------------------------------------------------------------------------------------------------
        //Метод возвращает узел со следующими значениями после delNode
        //Для этого он сначала переходит к правому потомку а затем
        //отслеживает цепочку левых потомков этого узла

    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;    // Переход к правому потомку
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

//------------------------------------------------------------------------------------------------------------
    public void traverse(int traverseType)
    {
        switch (traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                    preOrder(root);
                    break;
            case 2:
                System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }
 //-------------------------------------------------------------------------------------------------------------
    private void preOrder(Node localRoot)
    {

    if(localRoot != null)
    {
        System.out.print(localRoot.iData + " ");
        preOrder(localRoot.leftChild);
        preOrder(localRoot.rightChild);
    }

    }
    private void inOrder(Node localRoot)
    {
        if(localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }
    private  void postOrder(Node localRoot)
    {
        if(localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean  isRowEmpty = false;
        System.out.println(
                ".....................................................................................");
        while (isRowEmpty == false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j = 0; j < nBlanks; j++)
                System.out.print(' ');

        while (globalStack.isEmpty()==false)
        {
            Node temp = (Node)globalStack.pop();
            if(temp != null)
            {
                System.out.print(temp.iData);
                localStack.push(temp.leftChild);
                localStack.push(temp.rightChild);

                if(temp.leftChild != null || temp.rightChild != null)
                isRowEmpty = false;
            }
            else
            {
                System.out.print("--");
                localStack.push(null);
                localStack.push(null);


            }
            for(int j = 0; j < nBlanks*2-2;j++)
                System.out.print(' ');
        }
            System.out.println();
        nBlanks /= 2;
        while(localStack.isEmpty() == false)
            globalStack.push(localStack.pop());
        }
        System.out.println(
                "......................................................................................");
    }
//Конец класса Трее
}





