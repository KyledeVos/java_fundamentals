package labs_examples.datastructures.linkedlist.labs;

import java.util.ListIterator;

/**
 *      LinkedLists - Exercise_02
 *
 *      Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 *      class we used here, it must be entirely unique.
 *
 *      Please also add at least two additional helper methods that you think could be useful.
 *
 *      Refer to Java's built-in LinkedList class for inspiration.
 *      Your new LinkedList class should ONLY allow users
 *      to add and remove elements from the front of the list AND the end of the list.
 *
 *      Also, instead of using the index in the get() and remove() methods, these methods should
 *      get() and remove() based by the Node's value, not it's index.
 *      //Note: Conflicts with above instruction for remove() as node value is not needed to identify node
 *      //at beginning or end of list
 *
 *
 */

public class Exercise_02{

    public static void main(String[] args) {

        //testing class

        System.out.println("Test with Primitive Type\n");
        SingleLinkedList<String> myList = new SingleLinkedList<>();
        myList.add("Hello");
        myList.add("There");
        myList.add("Welcome", true);
        myList.add("This should print last" , false);
        myList.add("Should be at top of list" , true);
        myList.remove();

        myList.print();
        myList.remove(true);
        System.out.println();
        myList.print();
        System.out.println();

        myList.remove(false);
        myList.print();
        System.out.println("Test of get method: " + myList.get("Hi"));
        System.out.println("Size of list is: " + myList.size() + "\n");

        System.out.println("Test with Object Type\n");

        Car one = new Car("Bugatti", "W16", 2007);
        Car two = new Car("Ferrari" , "2.5" , 2020);
        Car three = new Car("Datsun", "1400", 2017);
        Car four = new Car("Porsche" , "2l" , 1995);
        Car five = new Car("Aston Martin", "V10", 2018);

        SingleLinkedList<Car> carSingleLinkedList = new SingleLinkedList<>();
        carSingleLinkedList.add(one);
        carSingleLinkedList.add(two);
        carSingleLinkedList.add(three);
        carSingleLinkedList.add(four);

        carSingleLinkedList.print();
        System.out.println();
        System.out.println("Test of get method: " + carSingleLinkedList.get(one));
        System.out.println();
        System.out.println("Size of carList is: " + carSingleLinkedList.size());

    }


}
