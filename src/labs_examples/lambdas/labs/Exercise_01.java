package labs_examples.lambdas.labs;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 *
 *
 *
 *
 */

public class Exercise_01 {

    public static void main(String[] args) {

//        1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
//        2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
//           an anonymous inner class from this interface.

            Car carObject = () -> System.out.println("Red car with v8");

            Car secondObject = new Car() {
                @Override
                public void details() {
                    System.out.println("Red car with v8");
                }
            };
        System.out.println("1) and 2) ");
            carObject.details();
            secondObject.details();
        System.out.print("\n");

//         3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
//           value of the same type as the parameter
//        4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
//                *          an anonymous inner class from this interface.

            Planet<Double> mars = new Planet<Double>() {
                @Override
                public Double calculate(Double a) {
                    return a+10;
                }
            };

            Planet<Integer> earth = a -> a*2;
            earth.calculate(6);

        System.out.println("3) and 4) ");
        System.out.println(mars.calculate(15.0));
        System.out.println(earth.calculate(2));
        System.out.print("\n");

//        5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
// *          value
//        6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
//           an anonymous inner class from this interface.

        EmotionDisplay first = (name, feeling) -> {
          return name + " is feeling " + feeling;
        };
        System.out.println("5) and 6) ");
        System.out.println(first.print("Kyle", "Happy"));

        EmotionDisplay second = new EmotionDisplay() {
            @Override
            public String print(String name, String feeling) {
                return name + " is feeling " + feeling;
            }
        };
        System.out.println(second.print("Benny", "sad"));
        System.out.print("\n");

        System.out.println("7) - Predicate with Lamba Expression ");

        Predicate<Integer> check = (Integer number) -> number>0;
        System.out.println(check.test(-4));

        System.out.println("\n8) - Function with Anonymous Class");
        Function<Integer, String> dayOfWeek = new Function<Integer, String>() {
            @Override
            public String apply(Integer s) {
                switch(s){
                    case 1:
                        return "Monday";

                    case 2:
                        return "Tuesday";

                    case 3:
                        return "Wednesday";

                    case 4:
                        return "Thursday";

                    case 5:
                        return "Friday";

                    case 6:
                        return "Saturday";

                    case 7:
                        return "Sunday";

                    default:
                        return "not a valid day of week";

                }
            }
        };

        System.out.println(dayOfWeek.apply(2));

    }
}