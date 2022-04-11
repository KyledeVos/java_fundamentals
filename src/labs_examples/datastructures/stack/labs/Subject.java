package labs_examples.datastructures.stack.labs;

public class Subject {

    private String name;
    private int credits;
    private int numberOfClasses;



    public Subject(String name, int credits, int numberOfClasses) {
        this.name = name;
        this.credits = credits;
        this.numberOfClasses = numberOfClasses;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setNumberOfClasses(int numberOfClasses) {
        this.numberOfClasses = numberOfClasses;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", credits=" + credits +
                ", numberOfClasses=" + numberOfClasses +
                '}';
    }
}
