package labs_examples.arrays.labs;

import java.util.ArrayList;

/**
 *  Traversing Arrays Backwards
 *
 *      Please create and populate an array of your choosing. Then, please demonstrate how to print out every other
 *      element in the array in reverse order.
 *
 */

public class Exercise_05 {
    public static void main(String[] args) {

        //Note, I want to create all three array types for this lab:

        //i) 1-D Array

        char[] oneDArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        System.out.println("1) One Dimensional Array with every other value printed in reverse order:");
        System.out.println();
        System.out.println("Original Array:");
        for(int i = 0; i< oneDArray.length; i++){
            System.out.print(oneDArray[i] + " ");
        }
        System.out.println();
        System.out.println("In reverse order: ");
        for(int i = (oneDArray.length -1); i >=0 ; i-=2){
            System.out.print(oneDArray[i] + " ");
        }

        //2) Two-Dimensional Array

        int[][] twoDArray = new int[5][5];
        int count = 1;
        System.out.println();
        System.out.println();
        System.out.println("2) Two Dimensional Array with every other value printed in reverse order:");

        for(int i = 0; i < twoDArray.length; i++){
            for(int j = 0; j < twoDArray[i].length; j++){
                twoDArray[i][j] = count;
                count++;
            }
        }

        System.out.println("Original Array");
        for(int i = 0; i < twoDArray.length; i++){
            for(int j = 0; j < twoDArray[i].length; j++){
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Reverse Order");
        for(int i = (twoDArray.length-1); i >=0; i--){
            for(int j = (twoDArray[i].length-1); j>=0; j-=2 ){
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        System.out.println("3) Array List with every other value printed in reverse order:");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Welcome ");
        arrayList.add("to ");
        arrayList.add("my ");
        arrayList.add("Coding ");
        arrayList.add("Nomads ");
        arrayList.add("Challenge ");

        System.out.println("Original Array:");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println();
        System.out.println("Reverse Order");

        for(int i = (arrayList.size()-1); i>=0; i-=2){
            System.out.println(arrayList.get(i));
        }







    }

}
