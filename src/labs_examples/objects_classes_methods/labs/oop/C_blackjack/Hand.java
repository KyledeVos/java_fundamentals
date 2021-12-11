package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;
    int handValue;

    public Hand() {
        this.cards = new ArrayList<>();
        this.handValue = 0;
    }

    public void showHand(){
        for(int i = 0; i<cards.size(); i++)
        System.out.println(cards.get(i).getCardValue() + " " + cards.get(i).getCardSuit());
    }

    public void addHandValue(int value){
        handValue+=value;
    }

    public boolean bust(){

        if(handValue>21){
            return true;
        }
        return false;
    }

    public int getHandValue() {
        return handValue;
    }


    public void addCard(Card card){
        cards.add(card);

    }
}
