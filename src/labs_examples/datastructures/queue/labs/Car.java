package labs_examples.datastructures.queue.labs;

public class Car {

    private String name;
    private double engineSize;

    public Car(String name, double engineSize) {
        this.name = name;
        this.engineSize = engineSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engineSize=" + engineSize +
                '}';
    }
}
