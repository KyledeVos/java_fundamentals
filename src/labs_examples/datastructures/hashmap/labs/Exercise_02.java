package labs_examples.datastructures.hashmap.labs;

/**
 *      HashMaps Exercise_02
 *
 *      Rewrite the CustomHashMap class to meet the following requirements:
 *      1) no method has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      2) no variable has the same name as any in CustomHashMap
 *          (do not use refactor - do it manually)
 *      3) resize the HashMap when the underlying array is more than half full
 *      4) triple the size of the underlying array on resize()
 *      5) instead of checking the number of keys to resize, check the number of values
 *      6) on collisions, add new elements to the front of the LinkedList, not the end
 *      7) anytime someone tries to get/update/remove an element that does not exist, print
 *          out a message indicating that the element does not exist
 *      8) add at least one more method that you think could be useful to the HashMap
 *          review Java's built-in HashMap for inspiration
 */

public class Exercise_02 {

    public static void main(String[] args) {

        //Testing HashMap

        MyCustomHashMap<String, Integer> myPointsMap = new MyCustomHashMap<>(5);
        myPointsMap.add("Ben", 10);
        myPointsMap.add("Mary", 14);
        System.out.println("\nFirst Print");
        myPointsMap.print();
        System.out.println();
        System.out.println("\nNumber of elements: " + myPointsMap.getItemCount());
        System.out.println("Size of Array: " + myPointsMap.sizeOfBucket() + "\n");

        System.out.println("Added one new element");
        myPointsMap.add("Alfred", 15);

        System.out.println("Testing: Array should triple in size to 15");
        System.out.println("\nNumber of elements: " + myPointsMap.getItemCount());
        System.out.println("Size of Array: " + myPointsMap.sizeOfBucket() + "\n");

        myPointsMap.add("Megan", 17);
        myPointsMap.add("Ned", 8);
        myPointsMap.add("Homer", 18);
        myPointsMap.add("Sarah", 20);
        myPointsMap.add("Gwen", 17);

        System.out.println("\nTesting: added five new elements. Array should triple in size to 45");
        System.out.println("Number of elements: " + myPointsMap.getItemCount());
        System.out.println("Size of Array: " + myPointsMap.sizeOfBucket() + "\n");
        System.out.println();
        myPointsMap.print();
        System.out.println();

        System.out.println("Testing if item with key \"Alfred\" is in list: " + myPointsMap.find("Alfred"));
        System.out.println("Testing if item with key \"Michael\" is in list: " + myPointsMap.find("Michael"));

        System.out.println("\nTesting removal");
        System.out.println("Number of elements: " + myPointsMap.getItemCount());
        System.out.println("Removing Item: " + myPointsMap.delete("Alfred"));
        System.out.println("Removing Item: " + myPointsMap.delete("Matilda"));
        myPointsMap.print();
        System.out.println("\nNumber of elements: " + myPointsMap.getItemCount());

        System.out.println("\nTesting Update: ");
        System.out.println("Old value of \"Mary\": " + myPointsMap.find("Mary"));
        System.out.println("Update of Mary points: " + myPointsMap.update("Mary", 17));
        System.out.println("New value of \"Mary\": " + myPointsMap.find("Mary"));
        System.out.println("Update of John points: " + myPointsMap.update("John", 19));

    }
}
