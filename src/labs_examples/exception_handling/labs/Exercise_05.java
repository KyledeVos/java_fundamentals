package labs_examples.exception_handling.labs;

import java.util.Arrays;

/**
 * Exception Handling Exercise 5:
 *
 *      Demonstrate how to throw an exception.
 *
 */

class  Example {

    public static void main(String[] args) {

        try{
            covidRoomCapacity();
        } catch(ArrayIndexOutOfBoundsException exc){
            System.out.println("No more room size detail available at this time");
        }

    }

    public static void covidRoomCapacity() throws ArrayIndexOutOfBoundsException{

        int[] roomArea = {0, 20, 40, 60, 80, 100, 120, 150, 180, 210};
        int count = 0;

        for(int i = 2; i<400; i+=2){
            System.out.println("Total number of people in room of size: " + roomArea[roomArea.length-(count+1)] +
                    " square metres is: " + roomArea[roomArea.length-(count+1)]/i);
            count++;
        }

    }

}