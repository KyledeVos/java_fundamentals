package labs_examples.lambdas.labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Lambdas Exercise 4:
 *
 *      Stream API Labs
 *
 *      1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
 *      2) Demonstrate the use of the sum function to determine the range of a set of numbers.
 *      3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
 *          to get the sum of the modified list
 *      4) Demontrate the filter function by filtering out all Integers that are less than 10 - then use the average
 *          function to average the remaining numbers, assign this result to an int variable.
 *      5) Demonstrate the reduce() function to determine the sum of a list of Integers
 *      6) Demontsrate how to Stream a text file and print out each line
 *      7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          the print out the element at the 1 index for each array.
 *      8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          the print out the sum of all elements at index 2.
 *      9) Demonstrate the anyMatch() function.
 *      10) Demonstrate the allMatch() function.
 *      11) Demonstrate the collect() terminal operation to store resulting values into a List
 *      
 */

class Example {

    public static void main(String[] args){

        //1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)

        System.out.println("1)");
        IntStream.range(1,16).forEach(x -> System.out.print(x + " "));
        System.out.println("\n");

        //2) Demonstrate the use of the sum function to determine the range of a set of numbers.
        System.out.println("2)");
        System.out.println("Printing sum of 1 - 10: " + IntStream.range(1, 11).sum());
        System.out.print("\n");

        //3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use
        // the sum function to get the sum of the modified list

        System.out.println("3) ");
        List<Integer> myList = Arrays.asList(2,  4 , 6 , 8 , 11 , 12 , 14, 16 , 20 , 22 , 24);
        System.out.println("Sum of Modified 2-Times Table:");
        System.out.println(myList.stream().map(x -> x+1).reduce(0, (Integer a, Integer b)-> a + b));
        System.out.println();


        //4) Demonstrate the filter function by filtering out all Integers that are less than 10 -
        // then use the average function to average the remaining numbers, assign this result to an int variable.

        System.out.println("4)");
        int average = (int) myList.stream().filter(y -> y > 10).mapToInt(y -> y).average().getAsDouble();
        System.out.println("Average is: " + average);
        System.out.println();

        //5) Demonstrate the reduce() function to determine the sum of a list of Integers

        System.out.println("5)");
        System.out.println("Sum: " + myList.stream().reduce(0, (Integer a, Integer b) -> a + b));
        System.out.println();

        //6) Demonstrate how to Stream a text file and print out each line
        System.out.println("6)");
        String path = "src/labs_examples/lambdas/labs/BurgerRecipe.txt";
        Stream<String> recipe = null;

        try {
             recipe = Files.lines(Paths.get(path));
        } catch(IOException exc){
            System.out.println("File not found");
        }
        if(recipe!=null) {
            recipe.forEach(x -> System.out.println(x));
        }
        recipe.close();
        System.out.println();

        System.out.println("7) ");

//        7) Demonstrate how to Stream the stream_text_lab.csv file in this package.
//        Split the lines into String arrays, then print out the element at the 1 index for each array.

        String csvPath = "src/labs_examples/lambdas/labs/stream_text_lab.csv";
        Stream<String> csv = null;
        try{
            csv = Files.lines(Paths.get(csvPath));
        } catch(IOException exc){
            System.out.println("file not found");
        }

        csv.map( a -> a.split(",")).forEach(a -> System.out.println(a[1]));
        csv.close();
        System.out.println();

        //8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the
        // lines into String arrays, then print out the sum of all elements at index 2.

        System.out.println("8) ");

        String csvPath2 = "src/labs_examples/lambdas/labs/stream_text_lab.csv";
        Stream<String> csv2 = null;
        try{
            csv2 = Files.lines(Paths.get(csvPath));
        } catch(IOException exc){
            System.out.println("file not found");
        }

        Double sum = csv2.map(x -> x.split(",")).map(x -> Double.parseDouble(x[2]))
                .reduce(0.0 , (Double a, Double b) -> a +b);
        System.out.println("sum " + sum);
        System.out.println();

        // 9) Demonstrate the anyMatch() function.

        System.out.println("9) ");

        //List from above:
        //List<Integer> myList = Arrays.asList(2,  4 , 6 , 8 , 11 , 12 , 14, 16 , 20 , 22 , 24);

        boolean rangeOfMax = myList.stream().anyMatch(x -> x>20);
        System.out.println("Does list contain numbers bigger than 20: " + rangeOfMax);

        boolean secondRangeOfMax = myList.stream().anyMatch(x -> x>30);
        System.out.println("Does list contain numbers bigger than 30: " + secondRangeOfMax);
        System.out.println();

        //10) Demonstrate the allMatch() function.
        System.out.println("10) ");

        boolean positivesOnly = myList.stream().allMatch(x -> x>0);
        System.out.println("Does unmodified list contain only positive numbers: " + positivesOnly);

        positivesOnly = myList.stream().map(x -> x-10).allMatch(x -> x>0);
        System.out.println("Does modified list contain only positive numbers: " + positivesOnly);
        System.out.println();

        //11) Demonstrate the collect() terminal operation to store resulting values into a List

        System.out.println("11) ");
        List<Integer> overTens = myList.stream().filter(x -> x > 10).collect(Collectors.toList());
        overTens.stream().forEach(x -> System.out.print(x + " "));
        
    }
    
}