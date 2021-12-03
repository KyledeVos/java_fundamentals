package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {

        // please create the methods as instructed below then
        // call each of those methods from here, within the main()

        int first = 4;
        int second = 8;
        int years = 10;

        System.out.println("Multiplication " + multiply(first, second));
        System.out.println("Divide " + divide(first, second));
        printJoke();
        System.out.println("seconds in " + years + " years is " + yearsToSeconds(years) + " seconds");
        System.out.println("Number of elements passed to method is: " + lengthofParametersArray(first, second, years));

    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b

    public static int multiply(int a, int b){
        return a*b;
    }


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b

    public static double divide(int a, int b){
        return ((double) a)/ ((double) b);
    }


    // 3) Create a static void method that will print of joke of your choice to the console

    public static void printJoke(){
        System.out.println();
        System.out.println("What has two paws and hangs from a tree?");
        System.out.println("A Paw-Paw");
    }


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents

    public static double yearsToSeconds(int years){
        return (double) (years*365*24*60*60);
    }


    // 5) Create a varargs method that will return the length of the varargs array passed in

    public static int lengthofParametersArray(int ... input){
        return input.length;
    }






}
