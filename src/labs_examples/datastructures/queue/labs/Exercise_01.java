package labs_examples.datastructures.queue.labs;

import java.net.Inet4Address;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      //Taken to be Java PriorityQueue as Queue is an interface and not class, als0 has 14 methods to
 *      //override and not 7 as stated below
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 */

public class Exercise_01{
    public static void main(String[] args) {

        PriorityQueue<Integer> intQueue = new PriorityQueue<>();

        //check if Queue is empty
        System.out.println("Is Queue Empty: " + intQueue.isEmpty());

        //add items to Queue

        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);
        intQueue.add(4);
        intQueue.add(5);
        intQueue.add(6);
        intQueue.add(7);
        intQueue.add(8);

        //test contains method

        System.out.println("Does list contain \"7\": " + intQueue.contains(7));
        System.out.println("Does list contain \"10\": " + intQueue.contains(10));

        //show order of items in queue

        System.out.println("List of items in Queue");
        for(Integer i : intQueue){
            System.out.println("Element: " + i);
        }

        //show head of queue
        System.out.println("Head of Queue: " + intQueue.peek());

        //remove head of queue
        System.out.println("Removed Head of Queue: " + intQueue.remove());

        //show new head of queue
        System.out.println("New Head of Queue: " + intQueue.peek());

        //Show size of Queue
        System.out.println("Size of Queue: " + intQueue.size());

        //Clear the queue
        intQueue.clear();

        //show size of queue after clear
        System.out.println("Queue size after clear: " + intQueue.size());

        //show head of queue after clear
        System.out.println("Head of Queue after clear: " + intQueue.peek());

    }
}