package labs_examples.datastructures.hashmap.labs;

import labs_examples.datastructures.linkedlist.examples.CustomLinkedList;
import labs_examples.datastructures.queue.examples.CustomQueue;
import labs_examples.datastructures.queue.labs.CustomQueueClass;
import labs_examples.datastructures.stack.labs.CustomStackClass;

/**
 *      HashMaps Exercise_03
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 100 elements
 *      2) update 100 elements
 *      3) search for 100 elements
 *      4) delete 100 elements
 */

public class Exercise_03 {
    public static void main(String[] args) {

        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        CustomStackClass<Integer> customStackClass = new CustomStackClass<>(10);
        CustomQueueClass<Integer> customQueue = new CustomQueueClass<>(10);
        MyCustomHashMap<Integer, Integer> customHashMap = new MyCustomHashMap<>(10);

        long linkedListTotalTime = 0;
        long stackTotalTime = 0;
        long queueTotalTime = 0;
        long hashMapTotalTime = 0;

        System.out.println("\nTest 1: Adding 100 Integers to each DataStructure:\n");


        //add 100 items to linkedList
        long startTime = System.currentTimeMillis();

        for(int i = 1; i<101; i++) {
            linkedList.add(i);
        }

        long endTime = System.currentTimeMillis();
        linkedListTotalTime = endTime - startTime;

        System.out.println("Task time of Linked List: " + (endTime - startTime));

        //add 100 items to stack
        startTime = System.currentTimeMillis();

        for(int i = 1; i<101; i++) {
            customStackClass.push(i);
        }

        endTime = System.currentTimeMillis();

        System.out.println("Task time of Stack: " + (endTime - startTime));
        stackTotalTime = endTime - startTime;

        //add 100 items to queue
        startTime = System.currentTimeMillis();

        for(int i = 1; i<101; i++) {
            customQueue.enqueue(i);
        }

        endTime = System.currentTimeMillis();

        System.out.println("Task time of queue: " + (endTime - startTime));
        queueTotalTime = endTime - startTime;

        //add 100 items to hashMap
        startTime = System.currentTimeMillis();

        for(int i = 1; i<101; i++) {
            customHashMap.add(i, i);
        }

        endTime = System.currentTimeMillis();

        System.out.println("Task time of hashMap: " + (endTime - startTime));
        hashMapTotalTime = endTime - startTime;


        //////////////////////////////////////////////////////////////
        System.out.println("\n Test 2: Update 100 elements in each DataStructure\n");

        //1) Update 100 elements in Linked List

        startTime = System.currentTimeMillis();

        for(int i = 0; i<100; i++){
            linkedList.set(i, (i*2));
        }
        endTime = System.currentTimeMillis();

        System.out.println("Task time of LinkedList: " + (endTime - startTime));
        linkedListTotalTime += endTime - startTime;

        //2) Update 100 elements in Stack

        startTime = System.currentTimeMillis();

        for(int i = 0; i<100; i++){
            customStackClass.update(i, (i*2));
        }
        endTime = System.currentTimeMillis();

        System.out.println("Task time of Stack: " + (endTime - startTime));
        stackTotalTime += endTime-startTime;

        //3) Update 100 items in queue

        startTime = System.currentTimeMillis();
        for(int i = 0; i<100; i++){
            customQueue.update(i, (i*2));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of queue: " + (endTime - startTime));
        queueTotalTime += endTime - startTime;

        //4) Update 100 items in hashMap

        startTime = System.currentTimeMillis();
        for(int i = 1; i<101; i++){
            customHashMap.update(i, (i*2));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of HashMap: " + (endTime - startTime));
        hashMapTotalTime += endTime -startTime;


        //////////////////////////////////////////////////////////////
        System.out.println("\n Test 3: Search for  100 elements in each DataStructure\n");


        //1) Search for 100 items in LinkedList
        startTime = System.currentTimeMillis();
        for(int i = 0; i< 100; i++){
            linkedList.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of LinkedList: " + (endTime - startTime));
        linkedListTotalTime += endTime - startTime;

        //2) Search for 100 items in Stack
        startTime = System.currentTimeMillis();
        for(int i = 0; i< 100; i++){
            customStackClass.search(i*2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of Stack: " + (endTime - startTime));
        stackTotalTime += endTime - startTime;

        //3) Search for 100 items in Queue

        startTime = System.currentTimeMillis();
        for(int i =0; i<100; i++){
            customQueue.search(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of Queue: " + (endTime - startTime));
        queueTotalTime += endTime - startTime;

        //4) Search for 100 items in HashMap

        startTime = System.currentTimeMillis();
        for(int i=1; i<101; i++){
            customHashMap.find(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of HashMap: " + (endTime - startTime));
        hashMapTotalTime += endTime - startTime;


        //////////////////////////////////////////////////////////////
        System.out.println("\n Test 4: Delete 100 elements in each DataStructure\n");

        //1)Remove 100 Elements from LinkedList

        startTime = System.currentTimeMillis();
        for(int i =0; i<100;i++){
            linkedList.remove(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of LinkedList: " + (endTime - startTime));
        linkedListTotalTime += endTime - startTime;

        //2) Remove 100 Elements from Stack

        startTime = System.currentTimeMillis();
        for(int i =0; i<100;i++){
            customStackClass.pop();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of Stack: " + (endTime - startTime));
        stackTotalTime += endTime - startTime;

        //3) Remove 100 Elements from Queue

        startTime = System.currentTimeMillis();
        for(int i =0; i<100;i++){
            customQueue.dequeue();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of Queue: " + (endTime - startTime));
        queueTotalTime += endTime - startTime;

        //4) Remove 100 Elements from HashMap

        startTime = System.currentTimeMillis();
        for(int i =1; i<101;i++){
            customHashMap.delete(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Task time of HashMap: " + (endTime - startTime));
        hashMapTotalTime += endTime - startTime;

        System.out.println("\nTotal Run Times: \n");
        System.out.println("LinkedList: " + linkedListTotalTime);
        System.out.println("Stack: " + stackTotalTime);
        System.out.println("Queue: " + queueTotalTime);
        System.out.println("HashMap: " + hashMapTotalTime);c















    }
}
