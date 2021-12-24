package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 1:
 *
 *      1) Demonstrate a try/catch.
 *
 */
public class Exercise_01{

    public static void main(String[] args) {

        try{
            System.out.println(5/0);
        } catch(ArithmeticException caught){
            System.out.println("Cannot perform a division by zero");

        }

    }


}

