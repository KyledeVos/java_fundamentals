package labs_examples.exception_handling.labs;

import java.util.Scanner;

/**
 * Exception Handling Exercise 3:
 *
 *      Demonstrate a try/catch/finally block.
 *
 */
public class Exercise_03{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Secret Santa List");
        System.out.println("Please Enter names for players below. Enter 'q' to quit ");
        String[] secretSantaPlayers = new String[6];
        boolean quit = false;
        int count = 0;

        try {
            while (!quit) {
                System.out.println("Enter name for player: " + (count + 1));
                String name = scanner.nextLine();
                if (name.equals("q")) {
                    quit = true;
                } else {
                    secretSantaPlayers[count] = name;
                    count++;
                }
            }
        } catch(ArrayIndexOutOfBoundsException caught){
            System.out.println("List is now Full");
            quit = true;
        } finally {
            System.out.println("Thank you for taking part in this year's Secret Santa");
        }

    }
}


