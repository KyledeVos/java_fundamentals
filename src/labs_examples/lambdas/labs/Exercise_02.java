package labs_examples.lambdas.labs;

import javax.swing.plaf.basic.BasicIconFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */

public class Exercise_02 {

    public static void main(String[] args) {

        System.out.println("1) - Predicate");
        BiPredicate<String, Integer> nameLengthAllowed = (name, allowedChars) ->{
          if(name.length() <= allowedChars){
              return true;
          }
          return false;
        };
        System.out.println("Name: Benjamin will fit on score board: " + nameLengthAllowed.test("Benjamin", 6)+ "\n");

        ////////////////////////////////////////////////////////////////////////////

        System.out.println("2) Supplier");
        Supplier<String> randomPerson = new Supplier<String>() {
            @Override

            public String get() {
                String[] namesInHat = {"Ted", "Abby" , "Mark", "Sarah"};

                int x = (int) ((Math.random()*10)%5);
                return namesInHat[x-1];
            }
        };

        System.out.println("Random Person for Surprise Gift: " + randomPerson.get() + "\n");

        ////////////////////////////////////////////////////////////////////////

        System.out.println("3) Consumer");

        Consumer<String> customer = (name) -> {
            System.out.println(name + " is next in line to be served");
        };
        customer.accept("Anthony");
        System.out.print("\n");

        ///////////////////////////////////////////////////////

        System.out.println("4) DoubleToInt");

        DoubleToIntFunction roundCosts = new DoubleToIntFunction() {
            @Override
            public int applyAsInt(double value) {
                return (int) (Math.ceil(value));
            }
        };

        System.out.println("Approximate cost of $13.99 dollars has been rounded to: " + roundCosts.applyAsInt(13.99));
        System.out.println("\n");

        ///////////////////////////////////////////////////////

        System.out.println("5) Function");

        Function<String, Character> nameToHighScore = (name) -> name.charAt(0);
        System.out.println("Initital for name Mike is:  " + nameToHighScore.apply("Mike") + "\n");

        //////////////////////////////////////////////////////

        System.out.println("6) BiPredicate");

        BiPredicate<Integer, Integer> validPyramid = new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer integer, Integer integer2) {
                if(integer2 == integer -1){
                    return true;
                }
                return false;
            }
        };

        System.out.println("Valid Row in Pyramid with row below = 5 bricks and row above = 2 bricks: "
                + validPyramid.test(5,2));
        System.out.println("Valid Row in Pyramid with row below = 5 bricks and row above = 4 bricks: "
                + validPyramid.test(5,4) + "\n");

        //////////////////////////////////////////////////////////

        System.out.println("7) Boolean Supplier");

        BooleanSupplier booleanBasedOnEven = () -> {
          int x = (int) (Math.random()*10)%10;
            if( (x%2) == 0) {
                return true;
            }
            return false;
        };

        System.out.println("Boolean value: " + booleanBasedOnEven.getAsBoolean() + "\n");

        ////////////////////////////////////////////////////////

        System.out.println("8) BiFunction ");

        BiFunction<String, Double, String> produceRoots = new BiFunction<String, Double, String>() {
            @Override
            public String apply(String s, Double aDouble) {
                if(s.equals("negative")){
                    return "no roots";
                } else if((Math.sqrt(aDouble))%1 == 0){
                    return "Rational Roots";
                } else {
                    return "Irrational Roots";
                }
            }
        };

        System.out.println("Checking Roots Using Discriminant");
        System.out.println("Discriminant is negative and value of 2 has: " + produceRoots.apply("negative", 2.0));
        System.out.println("Discriminant is positive and value of 4.2 has: " + produceRoots.apply("positive", 4.2));
        System.out.println("Discriminant is positive and value of 4.0 has: " + produceRoots.apply("positive", 4.0) + "\n");

        System.out.println("9) ObjDoubleConsumer");
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Ted");
        employees.add("Ben");
        employees.add("Mark");
        employees.add("Jane");
        employees.add("Amanda");

        ObjDoubleConsumer<ArrayList<String>> randomBonus = (names, number) -> {

            System.out.println("Chosen employee is "  + names.get((int) number) );
        };

        randomBonus.accept(employees, 4);
        System.out.println();

        ////////////////////////////////////////////

        System.out.println("10) Double Supplier");

        DoubleSupplier decimalForTesting = () -> Math.random()*10;
        double x = decimalForTesting.getAsDouble();

        if(x > 5){
            System.out.println("Decimal is within allowed range: " + x);
        } else {
            System.out.println("Decimal is not withing allowed range: " + x);
        }
    }



}