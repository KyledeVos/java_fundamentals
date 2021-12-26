package labs_examples.exception_handling.labs;

import java.util.Scanner;

/**
 * Exception Handling Exercise 7:
 *
 *      1) Create a custom exception.
 *      2) Demonstrate a method throwing your custom exception.
 */

public class Exercise_07{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter chosen time for doctor appointment");
        int time = scanner.nextInt();
        scanner.nextLine();

        try {
            bookAppointment(time);
        } catch(RoomClosedException exc){
            System.out.println(exc.toString());
        }

    }

    public static void bookAppointment(int time) throws RoomClosedException {

            if(time< 9) {
                System.out.println("Appointment Booked for " + time);
            } else {
                RoomClosedException closed = new RoomClosedException();
                throw closed;
            }


    }
}

class RoomClosedException extends Exception{

    public int closeTime = 9;

    @Override
    public String toString() {
        return "Doctor's room is closed. Closing time is " + closeTime;
    }
}
