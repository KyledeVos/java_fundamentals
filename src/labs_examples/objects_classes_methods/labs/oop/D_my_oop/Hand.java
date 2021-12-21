package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList;

public class Hand {

    ArrayList<Card> playersHand;

    public Hand() {
        this.playersHand = new ArrayList<>();
    }

    public ArrayList<Card> getPlayersHand() {
        return playersHand;
    }

    public void showHand(){
        for(int i = 0; i<playersHand.size(); i++) {

            if(playersHand.get(i).getValue()<=10) {

                System.out.print((i+1) + ") - " + playersHand.get(i).getValue() + " " + playersHand.get(i).getSuit() + "  |  ");
            } else {
                String faceCard = "";
                switch(playersHand.get(i).getValue()){
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

                System.out.print((i+1) + ") - " +faceCard + " " + playersHand.get(i).getSuit() + "  |  ");
            }

            }
        System.out.println("\n");
        System.out.println("Total cards: " + playersHand.size());
        System.out.println();
    }
}
