package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    Card[] cards;
    ArrayList<Integer> dealtCards;
    Card topCard;


    public Deck() {
        cards = new Card[53];
        dealtCards = new ArrayList<>();
        //setting a default top card that will be changed upon game start
        topCard = cards[0];
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
            cardNumber++;
        }
        //extra card used when player plays an 8 and chooses suit
        cards[52] = new Card(8, 'd');
    }

    public Card[] getCards() {
        return cards;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
        cards[52] = topCard;
    }

    public ArrayList<Integer> getDealtCards() {
        return dealtCards;
    }

    public Card setFirstTopCard(){
        Random randomNumber = new Random();
        int numberOfDealtCards = dealtCards.size();
        boolean quit = false;
        boolean find = false;
        int cardIndex = 0;

        while(!quit) {
            int rand = randomNumber.nextInt(52);
            find = false;
            cardIndex = rand;

            for (int i = 0; i < numberOfDealtCards; i++) {

                if(dealtCards.get(i) == rand){
                    find = true;
                    break;
                }
            }

            if(!find){
                quit =true;
            }
        }
        setTopCard(cards[cardIndex]);
        dealtCards.add(cardIndex);
        if(topCard.value == 8){
            cards[52].setSuit(setFirstTopCard().suit);
        }
        return topCard;
    }

    public void playCard(Card card, Player player){

        int cardIndex = 0;

        //finding card index from deck
        for(Card test: cards){
            if(test.getValue() == card.getValue() && test.getSuit() == card.getSuit()){
                break;
            }
            cardIndex++;
        }

        //removing card from dealtCards
        for(int i =0; i<dealtCards.size(); i++){
            if(dealtCards.get(i) == cardIndex){
                dealtCards.remove(i);
                break;
            }
        }

        //removing card from player's hand
        player.hand.playersHand.remove(card);

        //sets played card as new top card
        setTopCard(card);
        //System.out.println("__________________________________________________________");
        if(card.getValue()<=10) {
            System.out.println("Card Played: " + card.getValue() + " " + card.getSuit());
        }
        if(card.getValue()>10){
            String faceCard = "";
            switch(card.getValue()){
                case 11:
                    faceCard = "Jack";
                    break;

                case 12:
                    faceCard = "Queen";
                    break;

                case 13:
                    faceCard = "King";
                    break;
            }
            System.out.println("Card Played: " + faceCard + " " + card.getSuit());
        }
    }

    public void firstDeal(Player currentPlayer){
        Random randomNumber = new Random();
        int rand = 0;
        int playerCardCount = 0;

        while(playerCardCount < 7){
            int numberOfDealtCards = dealtCards.size();
            boolean find = false;

            rand = randomNumber.nextInt(52);    //sets new random index to be checked
            //System.out.println("Random Number: " + rand);

            for(int i = 0; i< numberOfDealtCards; i++){
                if(dealtCards.get(i) == rand){
                    find = true;
                    break;
                }
                //System.out.println("Looping");
            }

            if(find==false){
                dealtCards.add(rand);
                currentPlayer.hand.playersHand.add(cards[rand]);
                playerCardCount++;
            }
        }
    }

    public void deal(Player currentPlayer){

        if(dealtCards.size()<52) {

            Random randomNumber = new Random();
            int rand = 0;
            int playerCardCount = 0;

            while (playerCardCount < 1) {
                int numberOfDealtCards = dealtCards.size();
                boolean find = false;

                rand = randomNumber.nextInt(52);    //sets new random index to be checked

                for (int i = 0; i < numberOfDealtCards; i++) {
                    if (dealtCards.get(i) == rand) {
                        find = true;
                        break;
                    }
                    //System.out.println("Looping");
                }

                if (find == false) {
                    dealtCards.add(rand);
                    currentPlayer.hand.playersHand.add(cards[rand]);
                    playerCardCount++;
                }
            }
        } else {
            System.out.println("The deck is empty. Someone Must play or the game must be restarted");
        }
    }





}
