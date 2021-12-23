package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {

    String name;
    Hand hand;
    int potValue;
    int totalGamesWon;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
        totalGamesWon = 0;
    }

    public void setPotValue(int potValue){
        this.potValue = potValue;
    }

    public void changePotValue(boolean increase, int value){

        if(increase){
            potValue += value;
        } else{
            if(potValue<value){
                potValue=0;
            } else {
                potValue -= value;
            }
        }
    }

    public int getPotValue() {
        return potValue;
    }

    public boolean computerAI(Player player){
        return hand.getHandValue() < 16 || (player.hand.getHandValue() > hand.getHandValue() && player.hand.getHandValue() <= 21);
    }

    public int getTotalGamesWon() {
        return totalGamesWon;
    }

    public void setTotalGamesWon() {
        this.totalGamesWon++;
    }
}
