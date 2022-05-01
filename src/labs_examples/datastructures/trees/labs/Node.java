package labs_examples.datastructures.trees.labs;

public class Node {

    int key;
    String data;
    int height;

    Node leftChild;
    Node rightChild;

    //set left and right child Nodes to null upon creation
    public Node(int key, String data){
        this.key = key;
        this.data = data;
        leftChild = null;
        rightChild = null;
        this.height = 1;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", data='" + data + '\'' +
                ", height=" + height +
                '}';
    }
}
