package labs_examples.datastructures.linkedlist.labs;

public class Car {

    private String name;
    private String engineSize;
    private int year;

    public Car(String name, String engineSize, int year) {
        this.name = name;
        this.engineSize = engineSize;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize =  engineSize;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engineSize='" + engineSize + '\'' +
                ", year=" + year +
                '}';
    }
}
