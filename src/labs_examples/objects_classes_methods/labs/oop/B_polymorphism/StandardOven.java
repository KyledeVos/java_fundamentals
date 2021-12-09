package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class StandardOven implements Oven{

    String model;
    int platesOn;

    public StandardOven(String model, int platesOn) {
        this.model = model;
        this.platesOn = platesOn;
    }

    @Override
    public void turnOn() {
        System.out.println("Oven Turned On");
    }

    @Override
    public int electricityConsumption(int platesOn, boolean OvenOn) {
        int ovenConsumption;
        if(OvenOn){
            ovenConsumption = 200;
        } else{
            ovenConsumption = 0;
        }

        return (platesOn*40 + ovenConsumption);
    }
}
