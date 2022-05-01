package labs_examples.datastructures.trees.labs;

public class GenericNode<T> {

    int key;
    T data;
    int height;
    GenericNode leftChild;
    GenericNode rightChild;

    public GenericNode(int key, T data) {
        this.key = key;
        this.data = data;
        leftChild = null;
        rightChild = null;
        this.height = 1;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
