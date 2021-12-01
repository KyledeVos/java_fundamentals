package labs_examples.arrays.labs;

import java.util.ArrayList;

/**
 *  ArrayLists
 *
 *      Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 *      Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 *      typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 *      shows a list of methods.
 *
 */
public class Exercise_07 {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("ArrayList demonstrating customers online food choices:");

        System.out.println();
        System.out.println("Demonstrating Adding Items to ArrayList:");
        arrayList.add("Milk");
        arrayList.add("Bread");
        arrayList.add("Pasta");
        arrayList.add("Sugar");
        arrayList.add("Beef");
        arrayList.add("Chicken");
        arrayList.add("Soap");
        arrayList.add("Coffee");
        System.out.println();

        System.out.println("Items Selected: ");
        for(int i = 0; i< arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println();
        System.out.println("Demonstrating Removing an Item");
        arrayList.remove("Beef");
        arrayList.remove(0);
        System.out.println();

        System.out.println("Items Selected: ");
        for(int i = 0; i< arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println();
        System.out.println("Demonstrating searching for an Item");
        System.out.println("Index of Pasta: " + arrayList.indexOf("Pasta"));
        System.out.println();

        System.out.println("Demonstrating changing of Item: Bread to Milk");
        arrayList.set(0, "Milk");
        System.out.println("Items Selected: ");
        for(int i = 0; i< arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println();

        System.out.println("Checking if list is empty");
        System.out.println(arrayList.isEmpty());
        System.out.println();

        System.out.println("Demonstating clearing of ArrayList; client emptying cart online");
        arrayList.clear();

        System.out.println("Is Cart Empty: " + arrayList.isEmpty());


    }
}
