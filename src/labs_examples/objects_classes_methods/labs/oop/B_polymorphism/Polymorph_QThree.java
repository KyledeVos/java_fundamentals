package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Polymorph_QThree {

    public static void main(String[] args) {
        StandardOven kitchenOven = new StandardOven("Kenwood", 2);
        Hotel hotel = new Hotel(kitchenOven);
        hotel.runOven();
    }
}
