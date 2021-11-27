package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 2: Days of the week
 *
 *      Take in a number from the user and print "Monday", "Tuesday", ... "Sunday", or "Other"
 *      if the number from the user is 1, 2,... 7, or other respectively. Use an if-else statement
 *      to accomplish this task.
 * 
 *      Bonus Tricky Challenge: Use a "nested-if" statement.
 *
 */

import java.util.Scanner;

public class Exercise_02 {





    public static void main(String[] args) {

        // 1) create scanner (don't forget to import Scanner!)
        Scanner scanner = new Scanner(System.in);
        // 2) prompt user
        System.out.println("Please enter  number from 1 - 7 to return day of the week");
        // 3) assign input to variable as int
        int dayOfWeek = scanner.nextInt();
        scanner.nextLine();

        // 4) write completed code here

        if(dayOfWeek > 0 && dayOfWeek < 8){
            if(dayOfWeek == 1){
                System.out.println("Monday");
            } else if(dayOfWeek == 2){
                System.out.println("Tuesday");
            } else if(dayOfWeek == 3){
                System.out.println("Wednesday");
            } else if(dayOfWeek == 4){
                System.out.println("Thursday");
            } else if(dayOfWeek == 5){
                System.out.println("Friday");
            } else if(dayOfWeek == 6){
                System.out.println("Saturday");
            } else if(dayOfWeek == 7){
                System.out.println("Sunday");
            }
        } else {
            System.out.println("Other");
        }

    }

}
