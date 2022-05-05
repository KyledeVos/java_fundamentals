package labs_examples.datastructures.trees.labs;

/*
    Trees: Exercise_02

    For this challenge, please research and implement a custom Trie data structure (https://en.wikipedia.org/wiki/Trie).

    Trie's are very interesting and useful data structures. Many interview questions, and real-world scenario's
    can be properly addressed using a Trie. We use Tries to store things like words and numbers in a highly
    efficient manner. See here: http://theoryofprogramming.com/wp-content/uploads/2015/06/trie12.jpg

    Understanding and implement a Trie is a fantastic step in thinking creatively as a developer to
    accomplish goals as efficiently as possible.

    Here is a fantastic set of relevant interview questions: https://www.techiedelight.com/trie-interview-questions/

 */

public class Exercise_02 {

    public static void main(String[] args) {
        TrieClass trieClass = new TrieClass();
        trieClass.insert("hello");
        trieClass.insert("bye");
        trieClass.insert("height");
        trieClass.insert("man");
        trieClass.insert("mango");
        trieClass.insert("aero");
        System.out.println("Does Trie Contain bye: " + trieClass.search("bye"));
        System.out.println("Does Trie Contain byte: " + trieClass.search("byte"));
        trieClass.print();
        System.out.println();
        trieClass.remove("bye");
        trieClass.remove("mango");
        trieClass.remove("height");
        System.out.println();
        trieClass.print();

    }
}