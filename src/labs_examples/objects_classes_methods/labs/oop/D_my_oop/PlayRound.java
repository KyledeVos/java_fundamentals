package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Scanner;

public class PlayRound {

    Scanner scanner = new Scanner(System.in);
    boolean next;

    Deck deck;
    Player player;

    public PlayRound(Deck deck, Player player) {
        this.deck = deck;
        this.player = player;
        this.next = true;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int round(int cardsToDraw) {
        int maxChoice = player.hand.playersHand.size();
        boolean play = true;

        //1) Shows Player Top Card
        //////////////////////////////////////////////

        if (deck.getTopCard().getValue() <= 10) {
            System.out.println("Top Card:" + deck.getTopCard().getValue() + " " + deck.getTopCard().getSuit());
        } else {
            String faceCard = "";
            switch (deck.getTopCard().getValue()) {
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
            System.out.println("Top Card: " + faceCard + " " + deck.getTopCard().getSuit());
        }


            //2) Show Player their hand
            System.out.println();
            player.hand.showHand();

            //3) Game Play
            // i) Allows Player Input
            //ii) Validates Input - is an int and option corresponds to available player cards
            ///iii) Gameplay

            while (play) {

                System.out.println("Please enter card Number or enter 0 for 'draw':");
                if (cardsToDraw != 0 && deck.topCard.getValue() == 2) {
                    System.out.println("From previous Player you need to draw " + cardsToDraw + " cards or play a 2");
                }
                boolean isAnInt = scanner.hasNextInt();

                if (isAnInt) {
                    int choice = scanner.nextInt();
                    if (choice > maxChoice) {
                        System.out.println("Invalid Input");
                    } else {

                        //GamePlay
                        /////////////////////////////////////////////

                        //1) If TopCard is 2 and player must draw
                        if (deck.topCard.getValue() == 2 && cardsToDraw != 0) {

                            if (choice == 0) {
                                System.out.println("You have drawn " + cardsToDraw + " cards");
                                for (int i = 0; i < cardsToDraw; i++) {
                                    deck.deal(player);
                                }
                                return 0;

                            } else if (player.hand.playersHand.get(choice - 1).getValue() != 2) {
                                //player tried to play anything other than a 2 and does not choose draw
                                System.out.println("Invalid choice");
                            } else {
                                //player has chosen to play 2 adding two cards to next player's draw
                                cardsToDraw += 2;
                                deck.playCard(player.hand.playersHand.get(choice - 1), player);
                                System.out.println("next player must draw: " + cardsToDraw + " cards");
                                return cardsToDraw;
                            }


                        } else {

                            //1) Player wants to draw only
                            if (choice == 0) {
                                deck.deal(player);
                                System.out.println("New Card Drawn by: " + player.getName());
                                play = false;

                                //2) Player wants to play an 8 which can be played on anything
                            } else if (player.hand.playersHand.get(choice - 1).getValue() == 8) {

                                //allows player to play card
                                deck.playCard(player.hand.playersHand.get(choice - 1), player);

                                //setting of new suit allowed by 8
                                System.out.println("Please enter number of choice for suit change from: ");
                                System.out.println("1) ♠  - Spades\n" +
                                        "2) ♦  - Diamonds\n" +
                                        "3) ♥  - Hearts\n" +
                                        "4) ♣  - Clubs");

                                choice = scanner.nextInt();

                                boolean setSuitForEight = true;
                                while (setSuitForEight) {

                                    if (setSuitForEight) {
                                        //checks choice is one of four suits
                                        if (choice > 0 && choice < 5) {
                                            switch (choice) {
                                                case 1:
                                                    deck.cards[52].setSuit('♠');
                                                    System.out.println("Suit is now: ♠");
                                                    break;

                                                case 2:
                                                    deck.cards[52].setSuit('♦');
                                                    System.out.println("Suit is now: ♦");
                                                    break;

                                                case 3:
                                                    deck.cards[52].setSuit('♥');
                                                    System.out.println("Suit is now: ♥");
                                                    break;

                                                case 4:
                                                    deck.cards[52].setSuit('♣');
                                                    System.out.println("Suit is now: ♣");
                                                    break;
                                            }
                                            setSuitForEight = false;
                                            play = false;
                                            break;
                                        } else {
                                            System.out.println("Invalid Choice. Please enter number between 1 and 4");
                                        }
                                    } else {
                                        //player does not enter integer number for choice
                                        System.out.println("Invalid Input");
                                    }
                                    scanner.nextLine();

                                } // end of while statement for card play of 8

                                //3) check if player card is valid for card number or suit
                            } else if (player.hand.playersHand.get(choice - 1).getValue() == deck.getTopCard().getValue() || player.hand.playersHand.get(choice - 1).getSuit() == deck.getTopCard().getSuit()) {

                                //i) Player wants to play a 2

                                if (player.hand.playersHand.get(choice - 1).getValue() == 2) {
                                    System.out.println("Next Player must draw 2 cards ");
                                    deck.playCard(player.hand.playersHand.get(choice - 1), player);

                                    if(player.hand.playersHand.size() == 0){
                                        System.out.println(player.name + " has no cards in their hand");
                                    }

                                    return 2;

                                    //Player wants to play an ace reversing change of direction
                                } else if (player.hand.playersHand.get(choice - 1).getValue() == 1) {
                                    //allow play of card
                                    deck.playCard(player.hand.playersHand.get(choice - 1), player);

                                    if (next) {
                                        next = false;
                                    } else {
                                        next = true;
                                    }
                                    System.out.println("________________________________");
                                    System.out.println("Direction of play has reversed");
                                    System.out.println("________________________________");

                                    play = false;
                                } else {
                                    deck.playCard(player.hand.playersHand.get(choice - 1), player);
                                    play = false;

                                }

                            } else {
                                System.out.println("Card does not match. Please play card with value of " +
                                        deck.getTopCard().getValue() + " or card of suit " + deck.getTopCard().getSuit());
                            }

                        }
                    }

                } else {
                    //If player does not enter integer+
                    System.out.println("Invalid Input");
                }

                if(player.hand.playersHand.size() == 0){
                    System.out.println(player.name + " has no cards in their hand");
                }
            }//of while(play)

        return 0;
    }

    public int computerRound(int cardsToDraw){

        //1) Shows Computer Top Card
        //////////////////////////////////////////////

        if (deck.getTopCard().getValue() <= 10) {
            System.out.println("Top Card:" + deck.getTopCard().getValue() + " " + deck.getTopCard().getSuit());
        } else {
            String faceCard = "";
            switch (deck.getTopCard().getValue()) {
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
            System.out.println("Top Card: " + faceCard + " " + deck.getTopCard().getSuit());
        }

        //COMMENT OUT IN REAL GAMEPLAY
        //2) Show Player their hand
//        System.out.println(player.name + " hand");
//        System.out.println();
//        player.hand.showHand();

        //3) Game Play

            if (cardsToDraw != 0 && deck.topCard.getValue() == 2) {

                System.out.println("From previous Player " + player.getName() + " needs to draw " + cardsToDraw + " cards or play a 2");

                //If computer has a two
                if(cardToPlay(player) != -1){
                    deck.playCard(player.hand.playersHand.get(cardToPlay(player)), player);
                    cardsToDraw+=2;
                    System.out.println("next player must draw: " + cardsToDraw + " cards");
                    return cardsToDraw;

                    //if computer does not have a two
                } else {
                    System.out.println("Computer has drawn " + cardsToDraw + " cards");
                    for(int i = 0; i<cardsToDraw; i++){
                        deck.deal(player);
                    }
                }
            } else {
                //checks that card computer may have match to top Card
                //cardToPlay will make decision of best card to play and return index of card
                // or return -1 to indicate draw
                int cardIndex = cardToPlay(deck.getTopCard(), player);
                //1) Computer cannot play anything to match top card and will draw
                if(cardIndex == -1){
                    System.out.println(player.getName() + " will draw a card");
                    deck.deal(player);

                    //computer can play a card on the top card
                } else{

                    //If computer wants to play an 8
                    if(player.hand.playersHand.get(cardIndex).getValue() ==8){
                        deck.playCard(player.hand.playersHand.get(cardIndex), player);

                        switch(dominantSuit(player)){

                            case "Spades":
                            deck.cards[52].setSuit('♠');
                            deck.setTopCard(new Card(8, '♠'));
                            System.out.println("Suit is now: ♠");
                            break;

                            case "Diamonds":
                                deck.cards[52].setSuit('♦');
                                deck.setTopCard(new Card(8, '♦'));
                                System.out.println("Suit is now: ♦");
                                break;

                            case "Hearts":
                                deck.cards[52].setSuit('♥');
                                deck.setTopCard(new Card(8, '♥'));
                                System.out.println("Suit is now: ♥");
                                break;

                            case "Clubs":
                                deck.cards[52].setSuit('♣');
                                deck.setTopCard(new Card(8, '♣'));
                                System.out.println("Suit is now: ♣");
                                break;
                        }

                        //2) Computer wants to play a 2
                    } else if(player.hand.playersHand.get(cardIndex).getValue() == 2){
                        deck.playCard(player.hand.playersHand.get(cardIndex), player);
                        System.out.println("Next Player Must draw two cards");
                        return 2;

                        //3) Computer wants to play a 1
                    } else if(player.hand.playersHand.get(cardIndex).getValue()==1){
                        //allow play of card
                        deck.playCard(player.hand.playersHand.get(cardIndex), player);

                        if (next) {
                            next = false;
                        } else {
                            next = true;
                        }

                        System.out.println("Direction of play has reversed");

                        //4) Computer wants to play any other card
                    } else {
                        deck.playCard(player.hand.playersHand.get(cardIndex), player);

                    }

                }
            }
        if(player.hand.playersHand.size() ==0){
            System.out.println(player.name + " has no cards in their hand");
            System.out.println();
        } else {
            System.out.println(player.name + " has " + player.hand.playersHand.size() + " cards");
            System.out.println();
        }
        return 0;
    }



    //returns index of chosen card from computer hand of cards
    //return of -1 means computer does not have a card to match top card

    //order of choice
    //1) Play a 2
    //2) Play an 8
    //3) Play any other card that matches top card
    public int cardToPlay(Card card, Player player){
        //card is top card of deck

        //1) check all cards to look for 2
        for(Card searchCard: player.hand.playersHand) {
            if (searchCard.getSuit() == card.getSuit() || searchCard.getValue() == card.getValue()) {
                if (searchCard.getValue() == 2) {
                    return player.hand.playersHand.indexOf(searchCard);
                }
            }
        }

        //2) If hand does not contain a 2 but contains an eight
        for(Card searchCard: player.hand.playersHand){
            if(searchCard.getValue() == 8){
                return player.hand.playersHand.indexOf(searchCard);
            }
        }

        //3) Hand does not have a 2 or 8 so will play any other card
        for(Card searchCard : player.hand.playersHand){
            if(searchCard.getSuit() == card.getSuit() || searchCard.getValue() == card.getValue()){
                return player.hand.playersHand.indexOf(searchCard);
            }
        }

        return -1;
    }




    public int cardToPlay(Player player){
        for(Card searchCard : player.hand.playersHand){
            if(searchCard.getValue() == 2){
                return player.hand.playersHand.indexOf(searchCard);
            }
        }
        return -1;
    }

    public String dominantSuit(Player player){

        int diamondSuit = 0;
        int heartSuit = 0;
        int clubSuit = 0;
        int spadesSuit = 0;

        for(Card searchCard: player.hand.playersHand) {
            if (searchCard.getValue() != 8) {
                switch (searchCard.getSuit()) {
                    case '♦':
                        diamondSuit++;
                        break;

                    case '♥':
                        heartSuit++;
                        break;

                    case '♣':
                        clubSuit++;
                        break;

                    case '♠':
                        spadesSuit++;
                        break;
                }
            }
        }
            int[] suitArray = {diamondSuit, heartSuit, clubSuit, spadesSuit};
            int maxIndex = -1;
            for(int i = 0; i< suitArray.length-1; i++){
                if(suitArray[i] >= suitArray[i+1]){
                    maxIndex = i;
                }
            }

            switch(maxIndex){
                case 0:
                    return "Diamonds";

                case 1:
                    return "Hearts";

                case 2:
                    return "Clubs";

                case 3:
                    return "Spades";

                default:
                    return "Diamonds";
            }
        }


}


