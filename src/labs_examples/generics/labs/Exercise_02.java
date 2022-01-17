package labs_examples.generics.labs;

/**
 * Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList. Demonstrate how to call this method from the main() method.
 */
import java.util.ArrayList;

public class Exercise_02 {
    public static void main(String[] args) {

        Demo demo = new Demo();

        Double[] testArray = {1.5 , 1.2, 4.5 , 100.6, 34.9};
        Integer[] intArray = {4, 5, 6, 1 , 12, 3456};

        System.out.println("Sum of Double Array: " + demo.sumArray(testArray));
        System.out.println("\nSum of Integer Array: " + demo.sumArray(intArray));

    }
}

class Demo{

    public <T extends Number> double sumArray(T[] inputArray){

        double sum = 0;

        for(T search : inputArray){
            sum+= search.doubleValue();
        }
        return  sum;
    }
}