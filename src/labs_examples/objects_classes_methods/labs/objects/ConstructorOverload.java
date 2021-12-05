package labs_examples.objects_classes_methods.labs.objects;

public class ConstructorOverload {

    public static void main(String[] args) {

        Watch defaultWatch = new Watch();
        Watch brandWatch = new Watch("Casio");
        Watch fullDataWatch = new Watch("Casio", false);

        System.out.println(" State of Default Watch:");
        System.out.println(defaultWatch.toString());
        System.out.println();

        System.out.println(" State of Branded Watch:");
        System.out.println(brandWatch.toString());
        System.out.println();

        System.out.println(" State of Full Constructor Watch");
        System.out.println(fullDataWatch.toString());
    }
}

class Watch{

    String brand;
    boolean analogue;

    public Watch(){
        this.brand = "default";
        this.analogue = true;
    }

    public Watch(String brand){
        this.brand = brand;
        this.analogue = true;
    }

    public Watch(String brand, boolean analogue){
        this.brand = brand;
        this.analogue = analogue;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "brand='" + brand + '\'' +
                ", analogue=" + analogue +
                '}';
    }
}
