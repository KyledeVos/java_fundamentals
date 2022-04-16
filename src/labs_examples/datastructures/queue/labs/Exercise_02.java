package labs_examples.datastructures.queue.labs;

/**
 *      Queues - Exercise_02
 *
 *      Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Queue class must also do the following:
 *
 *      1) throw a custom exception when trying to pop  an element from an empty Queue
 *      2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full
 *      3) resize the Queue (the underlying array) to be half the size when the Queue is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Queue
 *
 */

public class Exercise_02 {
    public static void main(String[] args) {

        System.out.println("Testing Primitive Type\n");

        CustomQueueClass<String> stringQueue = new CustomQueueClass<>(4);

        System.out.println("\nNumber of Items in Queue:" + stringQueue.getNumberOfItems());
        System.out.println("Array Size: " + stringQueue.arraySize() + "\n");
        System.out.println("First Element in Queue: " + stringQueue.peekFirst());

        stringQueue.enqueue("Hello");
        stringQueue.enqueue("Welcome");
        System.out.println("\nNumber of Items in Queue:" + stringQueue.getNumberOfItems());
        System.out.println("Array Size: " + stringQueue.arraySize() + "\n");
        stringQueue.printQueue();

        stringQueue.enqueue("To");
        System.out.println("\nNumber of Items in Queue:" + stringQueue.getNumberOfItems());
        System.out.println("Array Size: " + stringQueue.arraySize() + "\n");
        System.out.println("Last Element in Queue: " + stringQueue.peekLast());

        stringQueue.printQueue();
        System.out.println("Item removed from queue: " + stringQueue.dequeue());
        System.out.println("\nNumber of Items in Queue:" + stringQueue.getNumberOfItems());
        System.out.println("Array Size: " + stringQueue.arraySize() + "\n");
        stringQueue.printQueue();

        System.out.println("First Element in Queue: " + stringQueue.peekFirst());
        System.out.println("Last Element in Queue: " + stringQueue.peekLast());

        /////////////////////////////////////////////////////////////////////////////////

        System.out.println("\nTesting Object Type\n");

        Car one = new Car("Ferrari", 2);
        Car two = new Car("Lamborghini", 2.5);
        Car three = new Car("Porsche", 2.1);
        Car four = new Car("Hilux", 2.8);
        Car five = new Car("Aston Martin", 3);
        Car six = new Car("Bugatti", 5.5);

        CustomQueueClass<Car> carQueue = new CustomQueueClass<>(3);
        carQueue.enqueue(one);
        carQueue.enqueue(two);
        carQueue.enqueue(three);

        System.out.println("\nNumber of Items in Queue:" + carQueue.getNumberOfItems());
        System.out.println("Array Size: " + carQueue.arraySize() + "\n");
        System.out.println("First Element in Queue: " + carQueue.peekFirst());
        System.out.println("Last Element in Queue: " + carQueue.peekLast());

        System.out.println("Item removed from queue: " + carQueue.dequeue());
        carQueue.printQueue();


    }
}
