package labs_examples.datastructures.stack.labs;

import java.util.Stack;

/**
 *      Demonstrate your mastery of Java's built-in Stack class by completing the following:
 *
 *      1) instantiate a new Stack
 *      2) demonstrate the use of EVERY method in the Stack class - there are 5
 */

public class Exercise_01{
    public static void main(String[] args) {

        // 1) instantiate a new Stack
        Stack<Subject> subjects = new Stack<>();

        //2)

        //push new element onto stack

        subjects.push(new Subject("English", 7, 5));
        subjects.push(new Subject("French", 6, 4));
        subjects.push(new Subject("Mathematics", 7, 3));
        subjects.push(new Subject("Life Skills", 5, 5));
        subjects.push(new Subject("Biology", 6, 2));
        subjects.push(new Subject("Physics", 7, 2));
        subjects.push(new Subject("History", 6, 3));
        subjects.push(new Subject("Business Science", 6, 3));

        //pop() elements off the stack and display returned element

        Subject first = subjects.pop();
        System.out.print("First Subject popped off:" + first.toString() + "\n");

        Subject second = subjects.pop();
        System.out.print("Second Subject popped off: " + second.toString() + "\n");

        //peek() at subject on top of stack
        System.out.println("Subject on Top of stack: " + subjects.peek() + "\n");

        //search for subject in stack
        System.out.println("result of search for subject \"History\" in stack: " + subjects.search(second) + "\n");

        //check if stack is empty()
        System.out.println("Results of checking if stack of subject is empty: " + subjects.empty());

    }
}
