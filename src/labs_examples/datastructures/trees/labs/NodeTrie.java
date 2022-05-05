package labs_examples.datastructures.trees.labs;

public class NodeTrie {

    //holds the character for this node
    public char c;

    //states whether this node is the end of a word or not
    public boolean isWord;

    //array to hold all 26 possible children for this node
    public NodeTrie[] children;

    public NodeTrie(char c){
        this.c = c;
        isWord = false;
        children = new NodeTrie[26];
    }
}
