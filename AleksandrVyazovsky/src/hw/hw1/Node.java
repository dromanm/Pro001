package hw.hw1;

/**
 * Created by Олег on 26.12.2016.
 */
public class Node {
    int iData;
    double dData;
    Node leftChild;
    Node rightChild;

    public void displayNode() {
        System.out.print('{');
        System.out.print(iData);
        System.out.print(". ");
        System.out.print(dData);
        System.out.print("} ");
    }
}
