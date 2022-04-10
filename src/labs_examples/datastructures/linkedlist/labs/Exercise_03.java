package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_02
 *
 *      Please create your own custom doubly-LinkedList from start to finish :) You got this!
 */

class Exercise_03{

    public static void main(String[] args) {

        //testing primitive type:
        DoublyLinkedList<String> stringList = new DoublyLinkedList<>();
        stringList.add("Hello");
        stringList.add(".");
        stringList.add("Welcome");
        stringList.add("To");
        stringList.add("my");
        stringList.add("list");
        stringList.print();
        System.out.println();
        System.out.println("Size: " + stringList.size());
        System.out.println();

        System.out.println(stringList.get("Hello").getNoteData());



        //testing object type

        Car one = new Car("Bugatti", "W16", 2007);
        Car two = new Car("Ferrari" , "2.5" , 2020);
        Car three = new Car("Datsun", "1400", 2017);
        Car four = new Car("Porsche" , "2l" , 1995);
        Car five = new Car("Aston Martin", "V10", 2018);

        DoublyLinkedList<Car> carList = new DoublyLinkedList<>();
        carList.add(one);
        carList.add(two);
        carList.add(three);
        carList.add(four);
        carList.add(five);
        System.out.println();
        carList.print();

        carList.clear();
        System.out.println("Car List: ");
        carList.print();
        System.out.println("Size: " + carList.size());



    }


}
