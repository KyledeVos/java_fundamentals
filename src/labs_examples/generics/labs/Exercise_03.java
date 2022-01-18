package labs_examples.generics.labs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes

 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */
public class Exercise_03 {

    public static void main(String[] args) {

        //1)
        System.out.println("1)");
        System.out.println("Sum of 1.9 and 3.5 is: " + sum(1.9, 3.5));
        System.out.println();

        //2)
        System.out.println("2)");
        String[] palindromes = {"my gym" , "no lemon, no melon", "never odd or even" , "I did, did I",
                                "was it a cat I saw"};
        //Source: Your Dictionary, https://examples.yourdictionary.com/palindrome-examples.html
        System.out.println("Number of elements in array is: " + countElements(palindromes));
        System.out.println();

        //3)
        System.out.println("3)");
        exchangeElements(palindromes, 0, 4);
        System.out.println();

        //4)
        System.out.println("4)");
          List<Integer> list = new ArrayList<>();
          for(int i = 0; i< 10; i++){
              list.add(i);
          }
        System.out.println("Max number in list is: " + findLargest(list));


    }


    //1)
    public static <T extends Number, V extends Number> double sum(T firstNumber, V secondNumber){

        return firstNumber.doubleValue() + secondNumber.doubleValue();

    }

    //2)
    public static <T> int countElements(T[] inputArray){

        return inputArray.length;

    }

    //3)
    public static <T> void exchangeElements(T[] array, int firstIndex, int secondIndex ){
        System.out.println("Old Array Order: \n");
        for(T search: array){
            System.out.println(search);
        }
        System.out.println("\nExchanging positions " + firstIndex + " and " + secondIndex);

        if(firstIndex < 0 || firstIndex > array.length - 2){
            System.out.println("Invalid first index. Set to 0");
            firstIndex = 0;
        }

        if(secondIndex < 0 || secondIndex > array.length - 1){
            System.out.println("Invalid Second Index. Set to " + (array.length - 1));
            secondIndex = array.length -1;
        }

        T hold = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = hold;

        System.out.println("New Array Order: \n");
        for(T search: array){
            System.out.println(search);
        }

    }



    //4)

    public static <T extends Comparable<T>> T findLargest(List<T> list){

        T max = list.get(0);

        for(T search :list){
            if(search.compareTo(max) > 0){
                max = search;
            }
        }
        return max;
    }

}

