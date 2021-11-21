package labs_examples.datatypes_operators.labs;

import java.util.Scanner;

/**
 * Fundamentals Exercise 5: Days to seconds
 *
 *      Take in a number in days from the user between 1 and 1,000,000 and convert it to
 *      seconds.
 *
 *      NOTE: We will be using the Scanner class to collect user input. This is demonstrated below.
 *
 */

public class Exercise_07 {

    public static void main(String[] args) {

        // create scanner
        Scanner scanner = new Scanner(System.in);
        // prompt user
        System.out.print("Enter a number in days between 1 and 1,000,000: ");
        // assign input to variable as int
        int days = scanner.nextInt();
        scanner.nextLine(); //clear scanner

        // write completed code here

        //extra check to ensure user data is within allowed parameters
        //while loop allows user to re-enter input
        if( (days < 1) || (days > 1000000)){
            System.out.println("Invalid input. Please enter a number of days between 1 and 1 000 000");

            boolean quit = false;
            while (!quit){
                System.out.print("Enter a number in days between 1 and 1,000,000: ");
                days = scanner.nextInt();
                scanner.nextLine();

                if(( days >= 1) && (days <= 1000000)){
                    quit = true;
                } else {
                    System.out.println("Invalid input. Please enter a number of days between 1 and 1 000 000");
                }

            }
        }

       double seconds = days * 24 *60 *60;
        System.out.println("Total seconds in " + days + " days is " + seconds + " seconds.");

        scanner.close();

    }
}