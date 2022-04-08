package labs_examples.datastructures.linkedlist.labs;

public class Node<T> {

    T nodeData;
    Node next;

    public Node(T nodeData) {
        this.nodeData = nodeData;
        this.next = null;
    }

    public Node(T nodeData, Node next) {
        this.nodeData = nodeData;
        this.next = next;
    }

    public T getNodeData() {
        return nodeData;
    }


}
