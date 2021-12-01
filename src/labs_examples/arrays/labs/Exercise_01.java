package labs_examples.arrays.labs;

import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] userArray = new int[10];
        int sum = 0;
        double average = 0;

        for(int i = 0; i< userArray.length; i++){
            System.out.println("Please enter input " + (i + 1));
            int input = scanner.nextInt();
            scanner.nextLine();
            userArray[i] = input;
            sum+=input;
        }

        average = ((double) sum)/userArray.length;

        System.out.println("User Data Inputs Are:");
        for(int i = 0; i< userArray.length; i++){
            System.out.println(userArray[i]);
        }

        System.out.println("Sum of all User Values: " + sum);
        System.out.println("Average of User Values: " + average);

    }



}