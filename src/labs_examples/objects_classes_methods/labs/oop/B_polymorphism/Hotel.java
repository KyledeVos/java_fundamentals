package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Hotel {

    Oven hotelOven;

    public Hotel(Oven hotelOven) {
        this.hotelOven = hotelOven;
    }

    public void setHotelOven(Oven hotelOven) {
        this.hotelOven = hotelOven;
    }

    public void runOven(){
        hotelOven.turnOn();
        System.out.println("Electricity Consumption: " + hotelOven.electricityConsumption(3, true));
    }
}
