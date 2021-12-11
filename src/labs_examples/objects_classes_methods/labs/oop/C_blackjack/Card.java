package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {

    //char[] suit = new char[]{'♠', '♦', '♥', '♣'};
    char cardSuit;
    int cardValue;

    public Card(int cardValue, char cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    public int getCardValue() {
        return cardValue;
    }

    public char getCardSuit() {
        return cardSuit;
    }
}
