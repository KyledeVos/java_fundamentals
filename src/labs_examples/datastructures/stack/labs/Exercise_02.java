package labs_examples.datastructures.stack.labs;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following: (Ryan Take 2)
 *
 *      1) throw a custom exception when trying to pop an element from an empty Stack
 *      2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *      3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *          //needs two methods - i) return number of active elements in array: elementNumber()
 *                              - ii) return size of the underlying array: size()
 *      6) contain a method to print out the data of all elements in the Stack
 *
 *      TIP: To initialize an new array of a Generic type you can use this:
 *           T[] data = (T[]) new Object[10];
 */

public class Exercise_02{
    public static void main(String[] args) {

        //Testing Stack Code

        CustomStackClass<Integer> test = new CustomStackClass<>(10);

        System.out.println("Testing Primitive Type int (Integer)");

        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println("\nSize of array: " + test.size());
        System.out.println("Number of elements: " + test.elementNumber() + "\n");
        test.push(6);
        test.push(7);
        test.push(8);
        System.out.println("\nSize of array: " + test.size());
        System.out.println("Number of elements: " + test.elementNumber() + "\n");
        test.printStack();

        System.out.println("\nTesting pop()\n");
        int out = test.pop();
        System.out.println("Removed element: " + out);
        System.out.println("\nSize of array: " + test.size());
        System.out.println("Number of elements: " + test.elementNumber() + "\n");
        test.printStack();
        System.out.println("Element Removed: " + test.pop());
        System.out.println("Element Removed: " + test.pop());
        System.out.println("Element Removed: " + test.pop());
        System.out.println("Element Removed: " + test.pop());
        System.out.println("Element Removed: " + test.pop());
        System.out.println("Element Removed: " + test.pop());
        System.out.println("Element Removed: " + test.pop());;
        System.out.println("\nSize of array: " + test.size());
        System.out.println("Number of elements: " + test.elementNumber() + "\n");
        test.printStack();
        test.pop();


        System.out.println("\nTest returning elements and watch stack grow");
        test.push(13);
        System.out.println("\nSize of array: " + test.size());
        System.out.println("Number of elements: " + test.elementNumber() + "\n");
        test.printStack();

        test.push(14);
        test.push(15);
        System.out.println("\nSize of array: " + test.size());
        System.out.println("Number of elements: " + test.elementNumber() + "\n");
        test.printStack();

        System.out.println("\nTesting return first and last elements\n");
        System.out.println("Element at top of Stack: " + test.peekFirst());
        System.out.println("Element at bottom of Stack: " + test.peekLast());


        //Testing object Type

        System.out.println("\nTesting Class Type - Subjects\n");
        CustomStackClass<Subject> subjectStack = new CustomStackClass<>(4);
        System.out.println("First Element in Stack: " + subjectStack.peekFirst());

        subjectStack.push(new Subject("English", 7, 5));
        subjectStack.push(new Subject("French", 6, 4));
        subjectStack.push(new Subject("Mathematics", 7, 3));
        subjectStack.push(new Subject("Life Skills", 5, 5));
        subjectStack.push(new Subject("Biology", 6, 2));
        subjectStack.push(new Subject("Physics", 7, 2));
        subjectStack.push(new Subject("History", 6, 3));
        subjectStack.push(new Subject("Business Science", 6, 3));

        System.out.println("\nSize of array: " + subjectStack.size());
        System.out.println("Number of elements: " + subjectStack.elementNumber() + "\n");
        subjectStack.printStack();

        System.out.println("\n Testing pop()\n");
        Subject removed = subjectStack.pop();
        System.out.println("Subject popped off: " + removed.toString() + "\n");
        System.out.println("\nSize of array: " + subjectStack.size());
        System.out.println("Number of elements: " + subjectStack.elementNumber() + "\n");
        subjectStack.printStack();

    }
}
