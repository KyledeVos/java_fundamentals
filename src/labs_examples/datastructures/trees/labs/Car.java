package labs_examples.datastructures.trees.labs;

public class Car {

    String name;
    int engineSize;

    public Car(String name, int engineSize) {
        this.name = name;
        this.engineSize = engineSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
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
