package labs_examples.datastructures.linkedlist.labs;

public class DNode<T> {

     T noteData;
     DNode prev;
     DNode next;

    public DNode(T noteData) {
        this.noteData = noteData;
    }

    public DNode(T noteData, DNode prev, DNode next) {
        this.noteData = noteData;
        this.prev = prev;
        this.next = next;
    }

    public T getNoteData() {
        return noteData;
    }
}
