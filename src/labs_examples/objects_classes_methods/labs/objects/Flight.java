package labs_examples.objects_classes_methods.labs.objects;

public class Flight {

    public static void main(String[] args) {

        Turbines turbines = new Turbines(4, 1000);
        Wings wings = new Wings(16);
        Passengers passengers = new Passengers(56);
        Cargo cargo = new Cargo(3);

        Airplane airplane = new Airplane(turbines, wings, passengers, cargo, 1000);

        System.out.println("Original Turbines: " + airplane.turbine.getNumberOfTurbines());
        airplane.turbine.setNumberOfTurbines(2);
        System.out.println("Number of Turbines after modification: " + airplane.turbine.getNumberOfTurbines());
        System.out.println();

        System.out.println("Changing fields of Airplane");
        System.out.println("Original fuel capacity: " + airplane.getFuelCapacity() + "litres");
        airplane.setFuelCapacity(2000);
        System.out.println("Fuel Capacity after change: " + airplane.getFuelCapacity() + "litres");
        System.out.println();

        System.out.println("Original number of passengers: " + passengers.getNumberOfPassengers());
        airplane.passengers.setNumberOfPassengers(100);
        System.out.println("Number of Passengers After change: " + passengers.getNumberOfPassengers());
        System.out.println();

        System.out.println("Using toString Method");
        System.out.println(airplane.cargo.toString());





    }
}

class Airplane{

    private int fuelCapacity;
    private int currentFuelLevel;

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


    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(int currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
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
    private int numberOfTurbines;
    private int power;

    public Turbines(int numberOfTurbines, int power){
        this.numberOfTurbines = numberOfTurbines;
        this.power = power;

    }

    public int getNumberOfTurbines() {
        return numberOfTurbines;
    }

    public void setNumberOfTurbines(int numberOfTurbines) {
        this.numberOfTurbines = numberOfTurbines;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
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
    private double wingSpan;

    public Wings(double wingSpan) {
        this.wingSpan = wingSpan;
    }

    @Override
    public String toString() {
        return "Wings{" +
                "wingSpan=" + wingSpan +
                '}';
    }

    public double getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.wingSpan = wingSpan;
    }
}

class Passengers{
    private int numberOfPassengers;
    private int averagePassengerWeight = 0;

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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getAveragePassengerWeight() {
        return averagePassengerWeight;
    }

    public void setAveragePassengerWeight(int averagePassengerWeight) {
        this.averagePassengerWeight = averagePassengerWeight;
    }
}

class Cargo{
    private int totalCargoWeight;

    public Cargo(int totalCargoWeight) {
        this.totalCargoWeight = totalCargoWeight;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "totalCargoWeight=" + totalCargoWeight +
                "tons }";
    }

    public int getTotalCargoWeight() {
        return totalCargoWeight;
    }

    public void setTotalCargoWeight(int totalCargoWeight) {
        this.totalCargoWeight = totalCargoWeight;
    }
}
