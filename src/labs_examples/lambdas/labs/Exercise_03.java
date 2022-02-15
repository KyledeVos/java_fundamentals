package labs_examples.lambdas.labs;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Lambdas Exercise 3:
 *
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 *
 */

public class Exercise_03 {
    public static void main(String[] args) {
        //Static Method Reference

        System.out.println("Static Method Reference");
        Function<String, Integer> reader = Exercise_03::numberOfCharacters;
        String name = "Kyle";
        System.out.println("Number of Characters in " + name + " is " + reader.apply(name));
        System.out.println();

        System.out.println("2) Instance Method Reference");

        ///////////////////////////////////////
        //Instance Method Reference

        Orders orders = new Orders(10);
        Predicate<Integer> addToOrder = orders::allowNewOrders;
        System.out.println("Can we add to current number of orders: " + addToOrder.test(20));
        System.out.println();

        ///////////////////////////////////////
        //Constructor Reference
        System.out.println("2) Instance Method Reference");

        CheckAge bar = Bar::new;
        bar.allow(18).permission();




    }

    //static Reference
    public static Integer numberOfCharacters(String name){
        return name.length();
    }
}

//Instance Method Reference

class Orders{

    private int numberOfOrders;

    public Orders(int numberOfOrders){
        this.numberOfOrders = numberOfOrders;
    }

    public boolean allowNewOrders(int number){
        if(numberOfOrders + number > 40){
            return false;
        }
        return true;
    }
}

//constructor method reference

class Bar{

    int age;

    public Bar(int age){
        this.age = age;
    }

    public void permission(){
        if(age< 18){
            System.out.println("Not allowed to enter");
        } else {
            System.out.println("Allowed to Enter");
        }
    }
}