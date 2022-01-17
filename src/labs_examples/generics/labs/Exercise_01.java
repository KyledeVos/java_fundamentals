package labs_examples.generics.labs;

/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

public class Exercise_01 {
    public static void main(String[] args) {

        MathCalculator<Double, Double> mathCalculator = new MathCalculator<>(3.5, 2.7);
        System.out.println("First Number is: " + mathCalculator.getFirstNumber());
        System.out.println("Second Number is: " + mathCalculator.getSecondNumber());
        System.out.println("\n" + "Changing second number to 5");
        mathCalculator.setSecondNumber(5.0);
        System.out.println("Second Number is: " + mathCalculator.getSecondNumber());
        System.out.println("Sum is: " + mathCalculator.sum());

        MathCalculator<Integer, Integer> intObject = new MathCalculator<>(6, 8);
        System.out.println("\nNow With Integers");
        System.out.println("First Number is: " + intObject.getFirstNumber());
        System.out.println("Second Number is: " + intObject.getSecondNumber());
        System.out.println("Sum is: " + intObject.sum());

    }
}

class MathCalculator<T extends Number, V extends Number>{

    T firstNumber;
    V secondNumber;

    public MathCalculator(T firstNumber, V secondNumber){

        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;

    }

    public T getFirstNumber() {
        return firstNumber;
    }

    public V getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(T firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(V secondNumber) {
        this.secondNumber = secondNumber;
    }

    public T sum(){
       return firstNumber;
    }
}

