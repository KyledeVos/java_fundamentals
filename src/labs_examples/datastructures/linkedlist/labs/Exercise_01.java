package labs_examples.datastructures.linkedlist.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *
 *      1) create a LinkedList (from Java's libraries)
 *      2) add()
 *      3) addAll()
 *      4) addFirst()
 *      5) addLast()
 *      6) getFirst()
 *      7) getLast()
 *      8) get()
 *      9) set()
 *      10) push()
 *      11) pop()
 *      12) remove()
 *      13) contains()
 *      14) listIterator()
 *      15) clear()
 */

public class Exercise_01{

    public static void main(String[] args){

        //1) create a LinkedList (from Java's libraries)
        LinkedList<Car> carList = new LinkedList<>();

        //2) add()
        carList.add((new Car("Ferrari" , "V8" , 2019)));
        carList.add((new Car("Datsun" , "1200" , 2016)));
        carList.add(new Car("Aston Martin" , "V10" , 2017));
        carList.add((new Car("Bugatti" , "W16" , 2012)));
        carList.add(new Car("Toyoto Corolla" , "1400" , 2015));
        carList.add((new Car("Hilux" , "2400" , 2020)));
        carList.add(new Car("Mustang" , "V8" , 2019));
        carList.add(new Car("Hyundai Getz" , "1600" , 2009));

        //3) addAll()
        ArrayList<Car> secondList = new ArrayList();
        secondList.add((new Car("Renault Sandero" , "1400" , 2015)));
        secondList.add((new Car("Nissan Sentra" , "1800" , 2018)));
        secondList.add(new Car("Bentley Continental" , "3000" , 2021));
        carList.addAll(secondList);

        //4) addFirst()
        carList.addFirst(new Car("Toyota Prius" , "electric" , 2010));

        //5) addLast()
        carList.addLast(new Car("Jaguar E-Type" , "V6" , 1981));

        //6) getFirst()
        System.out.println("Car first in list: " + carList.getFirst().toString() + "\n");

        //7) getLast()
        System.out.println("Car last in list: " + carList.getLast().toString() + "\n");

        //8) get()
        System.out.println("Car third in list: " + carList.get(2).toString() + "\n");

        //9) set()

        System.out.println("Car third in list has been changed to: ");
        carList.set((2), new Car("Subaru" , "2200" , 2015));
        System.out.println(carList.get(2).toString() + "\n");

        //10) push()
        carList.push(new Car("Lamborghini ", "V10", 2020));
        System.out.println("New car in front of list after push: " + carList.getFirst().toString() + "\n");

        //11) pop()
        System.out.println("Car popped off the front of the list: " + carList.pop().toString() + "\n");

        //12) remove()
        carList.remove(carList.size()-1);

        //13) contains()
        Car def = carList.get(4);
        System.out.println("Check if carlist contains: " + def.getName() + " : " + carList.contains(def) + "\n");

        //14) listIterator()

        ListIterator listIterator = carList.listIterator();
        System.out.println("List of Cars: " + "\n");
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
        System.out.println();

        //15) clear()
        carList.clear();
        System.out.println("After clear is carList Empty: " + carList.isEmpty());

    }

}


