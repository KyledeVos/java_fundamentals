package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Card {

    int value;
    char suit;

    public Card(int value, char suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        if(value<=10) {
            return "Card: " + value + " " + suit;
        } else {
            switch (value) {
                case 11:
                    return "Card: Jack " + suit;

                case 12:
                    return "Card: Queen " + suit;

                case 13:
                    return "Card: King " + suit;
            }
        }
        return "Card not found";
    }
}
