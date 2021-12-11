package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {

    String name;
    Hand hand;
    int potValue;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public boolean computerAI(){
        if(hand.getHandValue()<16){
            return true;
        }
        return false;
    }
}
