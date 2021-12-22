package labs_examples.static_nonstatic.labs;

public class Exercise1 {

    public static void main(String[] args) {

        //3) A static method calling a static method in another class

        System.out.println(IronmanSuit.fightReady());
        if(!IronmanSuit.fightReady()){

            //4) A static method calling a non-static method in another class

            IronmanSuit ironmanSuit = new IronmanSuit();
            ironmanSuit.activateSystem();
            System.out.println("Changes made: ");
            System.out.println(IronmanSuit.fightReady());
        }

    }

    //6) A non-static method calling a non-static method in another class
    //8) A non-static method calling a static method in another class
    public boolean systemDiagnostics(){
        IronmanSuit ironmanSuit = new IronmanSuit();
        if(IronmanSuit.fightReady() && IronmanSuit.powerLevel==0){
            ironmanSuit.systemMaintenance();
            return true;
        }
        return false;

    }

    //5) A non-static method calling a non-static method in the same class
    public String updateAvengers(){
        if(systemDiagnostics()){
            return "Hello Avengers. My suit is in the shop";
        } else {
            return "Lets get Thanos";
        }

    }

}

class IronmanSuit{

    static String governingSystem;
    static int powerLevel;
    static boolean suitOn;
    boolean charging;

    public IronmanSuit(){
        powerLevel = 100;
        governingSystem = "Jarvis";
        suitOn = true;
        charging = false;
    }

    public static void deactivateSystem(){

        //1) 1) A static method calling another static method in the same class
        turnOffSuit();

        //2) A static method calling a non-static method in the same class
        IronmanSuit control = new IronmanSuit();
        control.charging = true;

    }

    public void activateSystem(){
        suitOn = true;
        charging = false;
    }

    public static void turnOffSuit(){
        suitOn = false;

    }

    public static boolean fightReady(){
        if(suitOn){
            System.out.println("Ready to fight");
            return true;
        } else {
            System.out.println("Suit not on");
            return false;
        }
    }

   //7) A non-static method calling a static method in the same class
    public void systemMaintenance(){
        if(suitOn){
            deactivateSystem();
            System.out.println("System undergoing maintenance, suit Off");
        }
    }




}




