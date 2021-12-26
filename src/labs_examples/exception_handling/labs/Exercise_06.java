package labs_examples.exception_handling.labs;

import java.util.Scanner;

/**
 * Exception Handling Exercise 6:
 *
 *      Demonstrate throwing an exception in one method and catching it in another method.
 *
 */

public class Exercise_06{

    public static void main(String[] args) {

        checkAnswer();

    }

    public static void checkAnswer(){
        try{
            System.out.println("Answer: " + MathSolver());
        } catch(ArithmeticException exc){
            System.out.println("Divisor Cannot be zero");
        }
    }

    public static int MathSolver() throws ArithmeticException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number to be divided ");
        int first = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter divisor");
        int second = scanner.nextInt();
        scanner.nextLine();

        return (first/second);
    }

}

