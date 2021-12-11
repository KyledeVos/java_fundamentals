package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    Card[] cards;
    ArrayList<Integer> usedCards;

    public Deck() {
        this.cards = new Card[52];
        this.usedCards = new ArrayList<>();
    }

    public void populateDeck(){
        int deckCardCount = 0;
        int cardNumber =1;

        while(deckCardCount<52){

            cards[deckCardCount] = new Card(cardNumber, '♠');
            deckCardCount++;
            cards[deckCardCount] = new Card(cardNumber, '♦');
            deckCardCount++;
            cards[deckCardCount] = new Card(cardNumber, '♥');
            deckCardCount++;
            cards[deckCardCount] = new Card(cardNumber, '♣');
            deckCardCount++;
            if(cardNumber<10) {
                cardNumber++;
            }
        }
    }

    public void deal(Player player){
        Random randomNumber = new Random();
        boolean quit = false;
        int rand = randomNumber.nextInt(52);

       while(!quit) {

           if(usedCards.isEmpty()){
               player.hand.cards.add(this.cards[rand]);
               usedCards.add(rand);
               quit = true;
           } else {
               int count = usedCards.size();
               for (int i = 0; i < count; i++) {
                   if (usedCards.get(i) != rand) {
                       player.hand.cards.add(this.cards[rand]);
                       usedCards.add(rand);
                       quit = true;
                       break;
                   }
               }
           }
       }

        player.hand.addHandValue(cards[rand].cardValue);
    }

    public Card[] getCards() {
        return cards;
    }
}
