package labs_examples.exception_handling.labs;

import java.util.ArrayList;

/**
 * Exception Handling Exercise 2:
 *
 *      Demonstrate a try/catch with multiple catch statements.
 *
 */

public class Exercise_02{

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Benjamin");
        names.add("Ned");
        names.add("Mandy");
        names.add("Freddy");
        String name = "";
        names.add(name);

        for(int i = 0; i< names.size() + 1; i++){
            for(int j = 0; j< names.size(); j++) {
                try {
                    System.out.println("Name: " + names.get(i) + " has characters: ");
                    System.out.println(names.get(i).charAt(j) + " ");

                } catch(StringIndexOutOfBoundsException caught) {
                    System.out.println(caught.toString());
                } catch(IndexOutOfBoundsException	 caught){
                    System.out.println("Data does not exist");
                }
            }
        }
    }
}


