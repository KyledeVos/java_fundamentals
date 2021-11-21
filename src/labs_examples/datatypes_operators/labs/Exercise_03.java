package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all arithmetic operators below. These include:
 *
 * addition, subtraction, multiplication, division and modulus
 *
 */
class ArithmeticOperators {

    public static void main(String[] args) {

        // write your code below

        int firstValue = 4;
        int secondValue = 7;

        int addition = firstValue + secondValue;
        int subtraction = firstValue - secondValue;
        int multiplication = firstValue * secondValue;
        double division = (double) firstValue / (double) secondValue;
        int modulus = secondValue % firstValue;

        System.out.println("Additon: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
        System.out.println("Modulus: " + modulus);



    }

}
