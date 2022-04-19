package labs_examples.datastructures.hashmap.labs;

public class Item<T,S>{

    private T type;
    private S store;
    Item follow = null;

    public Item(T type, S store) {
        this.type = type;
        this.store = store;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public S getStore() {
        return store;
    }

    public void setStore(S store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type=" + type +
                ", store=" + store +
                '}';
    }
}
