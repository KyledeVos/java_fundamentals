package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 7: First vowel
 *
 *      Take in a word from the user and using a "while" loop, find the first vowel in the word.
 *      Once you find the vowel, print out the word and the first vowel.
 *
 *      Hints:
 *          - there are a few helpful methods in the String class called length(), charAt() and indexOf()
 *          - you'll likely want to use a String that contains all the vowels:
 *              - ie: String vowels = "aeiou";
 *
 */

public class Exercise_07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter one word and ensure it has at least one vowel");
        String input = scanner.nextLine();
        char foundVowel = 'n';

        int wordSize = input.length();

        for(int i = 0; i<wordSize; i++){
            char letter = input.charAt(i);
            if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
                foundVowel = letter;
                        break;
            }
        }

        if(foundVowel == 'n'){
            System.out.println("No vowels in word " + input);
        } else {
            System.out.println("Word " + input + " has first vowel: " + foundVowel);
        }
    }
}
