package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Scanner;

public class BlackjackController {

    public static void main(String[] args) {

        playBlackJack();

//        System.out.println(deck.cards.length);
//        //System.out.println(deck.cards[1].getSuit());
//       // System.out.println(deck.cards[1].getCardValue());
//
//        for(int i = 0; i< deck.cards.length; i++){
//            System.out.println(deck.cards[i].getCardSuit());
//            System.out.println(deck.cards[i].getCardValue());
//            System.out.println();
//        }



    }

    public static void playBlackJack() {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.populateDeck();

        System.out.println("Please enter name of Player:");
        String name = scanner.nextLine();
        System.out.println(name);
        Player player = new Player(name);
        Player comp = new Player("Computer");

        deck.deal(player);
        deck.deal(player);

        deck.deal(comp);
        deck.deal(comp);


        System.out.println("Player Hand");
        System.out.println("........................");
        player.hand.showHand();
        System.out.println("Player Hand Value: " + player.hand.handValue);
        System.out.println();

        System.out.println("Comp Hand");
        System.out.println("........................");
        comp.hand.showHand();
        System.out.println("Comp Hand Value: " + comp.hand.handValue);
        System.out.println();

        boolean quit = false;
        while(!quit) {

            System.out.println("Do you want to deal again?");
            String playerInput = scanner.nextLine();

            if (playerInput.equals("yes")) {
                deck.deal(player);
            } else {
                System.out.println("New Card not dealt");
            }
            System.out.println();

            System.out.println("Player Hand");
            System.out.println("........................");
            player.hand.showHand();
            System.out.println("Player Hand Value: " + player.hand.handValue);
            System.out.println();

            if(player.hand.getHandValue()>21){
                System.out.println();
                System.out.println("Player: " + player.name + " is bust");
                quit = true;
                break;
            }

            if (comp.computerAI()) {
                System.out.println("computer wants to deal again");
                deck.deal(comp);
            } else {
                System.out.println("Computer does not want to deal again");
            }
            System.out.println("Comp Hand");
            System.out.println("........................");
            comp.hand.showHand();
            System.out.println("Comp Hand Value: " + comp.hand.handValue);
            System.out.println();

            if(comp.hand.bust()){
                System.out.println("Computer bust!");
                quit = true;
                break;
            }

            if(playerInput.equals("no") && !comp.computerAI()){

                if(player.hand.getHandValue() > comp.hand.getHandValue()){
                    System.out.println(player.name + " wins");
                } else {
                    System.out.println("Computer wins");
                }
                quit = true;
                break;
            }
        }




    }

}
