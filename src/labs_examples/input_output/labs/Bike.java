package labs_examples.input_output.labs;

public class Bike {

    private String name;
    private String make;
    private double engineSize;
    private String colour;

    public Bike(){

    }

    public Bike(String name, String make, double engineSize, String colour){
        this.name = name;
        this.make = make;
        this.engineSize = engineSize;
        this.colour= colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", make='" + make + '\'' +
                ", engineSize=" + engineSize +
                ", colour='" + colour + '\'' +
                '}';
    }
}
