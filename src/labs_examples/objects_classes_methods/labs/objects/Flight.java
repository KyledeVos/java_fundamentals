package labs_examples.objects_classes_methods.labs.objects;

public class Flight {

    public static void main(String[] args) {

        Turbines turbines = new Turbines(4, 1000);
        Wings wings = new Wings(16);
        Passengers passengers = new Passengers(56);
        Cargo cargo = new Cargo(3);

        Airplane airplane = new Airplane(turbines, wings, passengers, cargo, 1000);
        System.out.println(airplane.toString());


    }
}

class Airplane{

    int fuelCapacity;
    int currentFuelLevel;

    Turbines turbine;
    Wings wings;
    Passengers passengers;
    Cargo cargo;

    public Airplane(Turbines turbine, Wings wings, Passengers passengers, Cargo cargo, int fuelCapacity) {
        this.turbine = turbine;
        this.wings = wings;
        this.passengers = passengers;
        this.cargo = cargo;
        this.fuelCapacity = fuelCapacity;
        currentFuelLevel = fuelCapacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "\nfuelCapacity=" + fuelCapacity +
                " litres , \ncurrentFuelLevel=" + currentFuelLevel +
                " litres, \nturbine=" + turbine +
                ", \nwings=" + wings +
                ", \npassengers=" + passengers +
                ", \ncargo=" + cargo +
                '}';
    }
}


class Turbines{
    int numberOfTurbines;
    int power;

    public Turbines(int numberOfTurbines, int power){
        this.numberOfTurbines = numberOfTurbines;
        this.power = power;

    }

    @Override
    public String toString() {
        return "Turbines{" +
                "numberOfTurbines=" + numberOfTurbines +
                ", power=" + power +
                '}';
    }
}

class Wings{
    double wingSpan;

    public Wings(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
        return "Wings{" +
                "wingSpan=" + wingSpan +
                '}';
    }
}

class Passengers{
    int numberOfPassengers;
    int averagePassengerWeight = 0;

    public Passengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        averagePassengerWeight = numberOfPassengers*70;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "numberOfPassengers=" + numberOfPassengers +
                ", averagePassengerWeight=" + averagePassengerWeight +
                "kg}";
    }
}

class Cargo{
    int totalCargoWeight;

    public Cargo(int totalCargoWeight) {
        this.totalCargoWeight = totalCargoWeight;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "totalCargoWeight=" + totalCargoWeight +
                "tons }";
    }
}
