package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class InheritanceHierarchy {
    public static void main(String[] args) {

        Plant myPlant = new Plant(true, 10);
        Tree oak = new Tree(true, 20, 4, false);
        FruitTree lemon = new FruitTree(false, 50, 17, true, "Lemon");
        Bush hedge = new Bush(true, 2, 3, false);
        Rose redRoseBush = new Rose(true, 40, 2, true, "Red");

        //Demonstrate subclasses have set variables and therefore called parametrized constructors in super classes

        System.out.println("oak water: " + oak.getWaterAvailable());
        System.out.println("fruit tree water: " + lemon.getWaterAvailable());
        System.out.println("fruit tree branches: " + lemon.getNumberOfBranches());
        System.out.println("Bush in sunlight: " + hedge.isInSunlight());
        System.out.println("rose bush height" + redRoseBush.getHeight());

        //Demonstrate Overriding of methods:

        System.out.print("Parent Class Plant: " );
        myPlant.grow();
        System.out.print("Child Class: ");
        oak.grow();
        oak.looseLeaves(oak.isEverGreen());
        System.out.println("Child class");
        lemon.grow();
        lemon.looseLeaves(lemon.isEverGreen());
    }
}

class Plant{

    private boolean inSunlight;
    private double waterAvailable;

    public Plant(boolean inSunlight, double waterAvailable) {
        this.inSunlight = inSunlight;
        this.waterAvailable = waterAvailable;
    }

    public void grow(){
        System.out.println("Plant is growing");
    }

    public boolean isInSunlight() {
        return inSunlight;
    }

    public void setInSunlight(boolean inSunlight) {
        this.inSunlight = inSunlight;
    }

    public double getWaterAvailable() {
        return waterAvailable;
    }

    public void setWaterAvailable(double waterAvailable) {
        this.waterAvailable = waterAvailable;
    }
}

//Heirarchy: Plant -> Tree -> Fruit Tree

class Tree extends Plant{

    private int numberOfBranches;
    private boolean everGreen;

    public Tree(boolean inSunlight, double waterAvailable, int numberOfBranches, boolean everGreen) {
        super(inSunlight, waterAvailable);
        this.numberOfBranches = numberOfBranches;
        this.everGreen = everGreen;
    }

    @Override
    public void grow() {
        System.out.println("Tree is growing. Branches get longer");
    }

    public void looseLeaves(boolean everGreen){
        if(everGreen){
            System.out.println("Tree does note loose leaves");
            return;
        }

        System.out.println("Tree looses leaves in Autumn");
    }

    public void growthRate(){
        if(isInSunlight()){
            System.out.println("Tree growing well in sun");
            return ;
        }
        System.out.println("Growth rate greatly reduced due to lack of sun");
    }

    public int getNumberOfBranches() {
        return numberOfBranches;
    }

    public void setNumberOfBranches(int numberOfBranches) {
        this.numberOfBranches = numberOfBranches;
    }

    public boolean isEverGreen() {
        return everGreen;
    }

    public void setEverGreen(boolean everGreen) {
        this.everGreen = everGreen;
    }
}

class FruitTree extends Tree{

    private String fruit;

    public FruitTree(boolean inSunlight, double waterAvailable, int numberOfBranches, boolean everGreen, String fruit) {
        super(inSunlight, waterAvailable, numberOfBranches, everGreen);
        this.fruit = fruit;
    }

    @Override
    public void grow() {
        System.out.println("Fruit Tree is growing");
    }

    @Override
    public void looseLeaves(boolean everGreen) {
        if(everGreen){
            System.out.println("Leaves not lost, fruit remains");
            return;
        }
        System.out.println("Fruit lost");
    }

    @Override
    public void growthRate() {
       if(isInSunlight()){
           System.out.println("Tree and fruit growing well");
           return;
       }
        System.out.println("Growth rate of tree and fruit reduced due to lack of sun");

    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}

//Heirarchy: Plant -> Bush -> Rose

class Bush extends Plant{

    int height;
    boolean prune;

    public Bush(boolean inSunlight, double waterAvailable, int height, boolean prune) {
        super(inSunlight, waterAvailable);
        this.height = height;
        this.prune = prune;
    }

    @Override
    public void grow() {
        System.out.println("Bush is growing");
    }

    public void pruned(boolean prune){
        if(prune){
            System.out.println("Bush has been pruned");
            return;
        }

        System.out.println("Bush needs to be pruned");
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isPrune() {
        return prune;
    }

    public void setPrune(boolean prune) {
        this.prune = prune;
    }

}

class Rose extends Bush{
    String colour;

    public Rose(boolean inSunlight, double waterAvailable, int height, boolean prune, String colour) {
        super(inSunlight, waterAvailable, height, prune);
        this.colour = colour;
    }

    @Override
    public void grow() {
        System.out.println("Rose Bush is Growing");
    }



    @Override
    public void pruned(boolean prune) {
        if(prune){
            System.out.println("Roses not present, bush pruned");
            return;
        }
        System.out.println("Roses present but bush needs to be pruned");
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}


