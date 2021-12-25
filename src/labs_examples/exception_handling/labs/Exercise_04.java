package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 4:
 *
 *      Demonstrate a nested try/catch.
 *
 */

public class Exercise_04{
    public static void main(String[] args) {

        //Vowel in Words Counter

        String[] words = new String[5];
        //populate array with words
        words[0] = "Tree";
        words[1] = "Donkey";
        words[2] = "Chairs";
        words[3] = "Gate";
        words[4] = "cartwheel";

        int numberOfVowels = 0;

            try {

                try {
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 20; j++) {
                            switch (words[i].charAt(j)) {
                                case 'a':
                                case 'e':
                                case 'i':
                                case 'o':
                                case 'u':
                                    numberOfVowels++;
                                    break;
                            }
                        }

                    }



                } catch (IndexOutOfBoundsException innerCatch) {
                    System.out.println("word checked for vowels");
                }


            } catch (ArrayIndexOutOfBoundsException outerCatch) {
                System.out.println("All words checked");
            }
        }
    }

