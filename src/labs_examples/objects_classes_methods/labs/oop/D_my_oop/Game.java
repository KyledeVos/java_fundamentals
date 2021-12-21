package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Crazy Eight.");
        System.out.println("Would you like to read the game rules first?");
        System.out.println("Enter 'yes' to read the rules or 'no' to skip");
        String input = scanner.nextLine();

        if(input.equals("yes")){
            introAndRules();
        }

        System.out.println("Please enter number of Real Players. There must be at least one and no more than three");
        boolean loop = true;
        int noOfPlayers = 0;

        while(loop) {
            boolean hasInt = scanner.hasNextInt();
            if (hasInt) {
                noOfPlayers = scanner.nextInt();
                if (noOfPlayers < 1 || noOfPlayers > 3) {
                    System.out.println("Invalid Number of Players. Please enter a number between one and three");
                } else {
                    System.out.println();
                    System.out.println("Real Players: " + noOfPlayers);
                    loop = false;
                }
            } else {
                System.out.println("Invalid Input. Please enter a number between one and three");
            }
            scanner.nextLine();
        }

        Deck deck = new Deck();
        deck.populateDeck();
        Card topCard = deck.setFirstTopCard();

        if(noOfPlayers == 1){
            System.out.println("Please Enter Player Name");
            String name = scanner.nextLine();
            Player player = new Player(name);
            Player comp1 = new Player("Computer 1");
            Player comp2 = new Player("Computer 2");

            deck.firstDeal(player);
            deck.firstDeal(comp1);
            deck.firstDeal(comp2);

            PlayRound turnOne = new PlayRound(deck, player);
            PlayRound turnTwo = new PlayRound(deck, comp1);
            PlayRound turnThree = new PlayRound(deck, comp2);

            onePlayer(deck, turnOne, turnTwo, turnThree);

        } else if(noOfPlayers == 2){
            System.out.println("Please Enter Name of First Player");
            String name = scanner.nextLine();
            System.out.println();
            Player player1 = new Player(name);
            System.out.println();
            System.out.println("Please Enter Name of Second Player");
            name = scanner.nextLine();
            Player player2 = new Player(name);
            Player comp = new Player("Computer");

            deck.firstDeal(player1);
            deck.firstDeal(player2);
            deck.firstDeal(comp);

            PlayRound turnOne = new PlayRound(deck, player1);
            PlayRound turnTwo = new PlayRound(deck, player2);
            PlayRound turnThree = new PlayRound(deck, comp);

            twoPlayer(deck, turnOne, turnTwo, turnThree);
        } else {

            System.out.println("Please Enter Name of First Player");
            String name = scanner.nextLine();
            System.out.println();
            Player player1 = new Player(name);
            System.out.println();
            System.out.println("Please Enter Name of Second Player");
            name = scanner.nextLine();
            System.out.println();
            Player player2 = new Player(name);
            System.out.println("Please Enter Name of Third Player");
            name = scanner.nextLine();
            System.out.println();
            Player player3 = new Player(name);


            deck.firstDeal(player1);
            deck.firstDeal(player2);
            deck.firstDeal(player3);

            PlayRound turnOne = new PlayRound(deck, player1);
            PlayRound turnTwo = new PlayRound(deck, player2);
            PlayRound turnThree = new PlayRound(deck, player3);

            threePlayer(deck, turnOne, turnTwo, turnThree);

        }

       //playGame();



    }

    public static void onePlayer(Deck deck, PlayRound first, PlayRound second, PlayRound third){

        boolean play = true;
        int track =1 ;
        boolean forward = true;
        int pickUpCards = 0;

        while(play){

            if(enoughPlayers(first.player, second.player,third.player)) {

                if (track == 1 && first.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(first.player.getName() + " Turn");
                    first.setNext(forward);
                    pickUpCards = first.round(pickUpCards);
                    forward = first.isNext();
                    if (forward) {
                        //second player
                        if (second.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else { // only comp2 is left
                            track = 3;
                        }
                    } else {
                        //third player
                        if (third.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else {
                            track = 2;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(first.player, second.player,third.player)) {
                if (track == 2 && second.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(second.player.getName() + " turn");
                    second.setNext(forward);
                    pickUpCards = second.computerRound(pickUpCards);
                    forward = second.isNext();
                    if (forward) {
                        //third player
                        if (third.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else { // only player
                            track = 1;
                        }

                    } else {
                        if (first.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 3;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(first.player, second.player,third.player)) {
                if (track == 3 && third.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(third.player.getName() + " turn");
                    third.setNext(forward);
                    pickUpCards = third.computerRound(pickUpCards);
                    forward = third.isNext();
                    if (forward) {
                        if (first.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 2;
                        }
                    } else {
                        if (second.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else {
                            track = 1;
                        }
                    }

                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

        }

    }

    public static void twoPlayer(Deck deck, PlayRound first, PlayRound second, PlayRound third){

        boolean play = true;
        int track =1 ;
        boolean forward = true;
        int pickUpCards = 0;

        while(play){

            if(enoughPlayers(first.player, second.player,third.player)) {

                if (track == 1 && first.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(first.player.getName() + " Turn");
                    first.setNext(forward);
                    pickUpCards = first.round(pickUpCards);
                    forward = first.isNext();
                    if (forward) {
                        //second player
                        if (second.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else { // only comp2 is left
                            track = 3;
                        }
                    } else {
                        //third player
                        if (third.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else {
                            track = 2;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(first.player, second.player,third.player)) {
                if (track == 2 && second.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(second.player.getName() + " turn");
                    second.setNext(forward);
                    pickUpCards = second.round(pickUpCards);
                    forward = second.isNext();
                    if (forward) {
                        //third player
                        if (third.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else { // only player
                            track = 1;
                        }

                    } else {
                        if (first.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 3;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(first.player, second.player,third.player)) {
                if (track == 3 && third.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(third.player.getName() + " turn");
                    third.setNext(forward);
                    pickUpCards = third.computerRound(pickUpCards);
                    forward = third.isNext();
                    if (forward) {
                        if (first.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 2;
                        }
                    } else {
                        if (second.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else {
                            track = 1;
                        }
                    }

                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

        }


    }

    public static void threePlayer(Deck deck, PlayRound first, PlayRound second, PlayRound third){

        boolean play = true;
        int track =1 ;
        boolean forward = true;
        int pickUpCards = 0;

        while(play){

            if(enoughPlayers(first.player, second.player,third.player)) {

                if (track == 1 && first.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(first.player.getName() + " Turn");
                    first.setNext(forward);
                    pickUpCards = first.round(pickUpCards);
                    forward = first.isNext();
                    if (forward) {
                        //second player
                        if (second.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else { // only comp2 is left
                            track = 3;
                        }
                    } else {
                        //third player
                        if (third.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else {
                            track = 2;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(first.player, second.player,third.player)) {
                if (track == 2 && second.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(second.player.getName() + " turn");
                    second.setNext(forward);
                    pickUpCards = second.round(pickUpCards);
                    forward = second.isNext();
                    if (forward) {
                        //third player
                        if (third.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else { // only player
                            track = 1;
                        }

                    } else {
                        if (first.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 3;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(first.player, second.player,third.player)) {
                if (track == 3 && third.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println(third.player.getName() + " turn");
                    third.setNext(forward);
                    pickUpCards = third.round(pickUpCards);
                    forward = third.isNext();
                    if (forward) {
                        if (first.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 2;
                        }
                    } else {
                        if (second.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else {
                            track = 1;
                        }
                    }

                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

        }


    }

    public static void playGame(){

        //display rules and create deck with top card
        introAndRules();
        Deck deck = new Deck();
        deck.populateDeck();
        Card topCard = deck.setFirstTopCard();

        //Create Players - One User, Two 'Computers'
        Player player = new Player("Kyle");
        Player comp = new Player("Computer 1");
        Player comp2 = new Player("Computer 2");

        //Testing - Extra Players
//        Player player2 = new Player("Michaela");
//        Player player3 = new Player("Ivan");

                //create playerTurn
        PlayRound turn = new PlayRound(deck, player);
//        PlayRound mTurn = new PlayRound(deck, player2);
//        PlayRound iTurn = new PlayRound(deck, player3);

        //create computer Turn
        PlayRound turn2 = new PlayRound(deck, comp);
        PlayRound turn3 = new PlayRound(deck, comp2);


        //Starts Game SetUp
        deck.firstDeal(player);
        deck.firstDeal(comp);
        deck.firstDeal(comp2);
        //deck.firstDeal(player2);
        //deck.firstDeal(player3);

        //Loop for GamePlay
        boolean play = true;

        int track =1 ;
        boolean forward = true;

        int pickUpCards = 0;

        while(play){

            if(enoughPlayers(player, comp , comp2)) {

                if (track == 1 && player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println("Kyle Turn");
                    turn.setNext(forward);
                    pickUpCards = turn.round(pickUpCards);
                    forward = turn.isNext();
                    if (forward) {
                        //if comp1 is playing
                        if (turn2.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else { // only comp2 is left
                            track = 3;
                        }
                    } else {
                        //If comp2 is playing
                        if (turn3.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else {
                            track = 2;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(player, comp , comp2)) {
                if (track == 2 && turn2.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println("Computer 1 Turn");
                    turn2.setNext(forward);
                    pickUpCards = turn2.computerRound(pickUpCards);
                    forward = turn2.isNext();
                    if (forward) {
                        //if Comp2 is playing
                        if (turn3.player.hand.playersHand.size() > 0) {
                            track = 3;
                        } else { // only player
                            track = 1;
                        }

                    } else {
                        if (turn.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 3;
                        }
                    }
                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

            if(enoughPlayers(player, comp , comp2)) {
                if (track == 3 && turn3.player.hand.playersHand.size() > 0) {
                    System.out.println("_____________________________________");
                    System.out.println("Computer 2 Turn");
                    turn3.setNext(forward);
                    pickUpCards = turn3.computerRound(pickUpCards);
                    forward = turn3.isNext();
                    if (forward) {
                        if (turn.player.hand.playersHand.size() > 0) {
                            track = 1;
                        } else {
                            track = 2;
                        }
                    } else {
                        if (turn2.player.hand.playersHand.size() > 0) {
                            track = 2;
                        } else {
                            track = 1;
                        }
                    }

                }
            } else {
                System.out.println("Game Over");
                play = false;
                break;
            }

        }

    }

    //Method to check if enough players are in Game
    public static boolean enoughPlayers(Player player, Player comp1, Player comp2){
        int totalPlayers =0;
        if(player.hand.playersHand.size() > 0){
            totalPlayers++;
        }
        if(comp1.hand.playersHand.size()>0){
            totalPlayers++;
        }
        if(comp2.hand.playersHand.size()>0){
            totalPlayers++;
        }

        if(totalPlayers>1){
            return true;
        }
        return false;
    }

    public static void introAndRules(){

        System.out.println("Game Intro: ");
        System.out.println("1) Each Player will automatically be dealt 7 cards\n" +
                           "2) The game objective is to be the first player to have no cards in your hand\n" +
                           "3) One card will be placed down automatically called the 'Top Card'\n" +
                           "4) You cannot see the cards the computer players are holding, only the number of " +
                            "cards they each have will be shown");
        System.out.println();
        System.out.println("Game Rules: ");
        System.out.println("1) During your turn you may only place one card from your hand on top of the top card\n" +
                           "2) To place down a card you need to match either the numeric or face value of the top card or the suit of the top card\n" +
                           "3) If you are unable to do so, you need to draw one card from the deck\n" +
                           "4) Please enter the number on the left of each card in order to play the card");

        System.out.println("Crazy Eight has 'special cards' and you may play one as your final card");
        System.out.println("Special Cards");
        System.out.println("1) Ace - This reverses the direction of play\n" +
                           "2) Two - The player after you must draw two cards from the deck unless they play another two " +
                           "which will force the next player to draw 4 and so on\n" +
                            "3) 8 - Can be played on top of any card and allows the player to state the suit\n");
        System.out.println("Please note an eight cannot be played if you are required to draw cards after a 2 has been played");

        System.out.println();
        System.out.println("Note:");
        System.out.println("For realistic gameplay, you will be provided with options following the rules however " +
                            "the program will not allow plays that do not follow the rules");
        System.out.println();
        System.out.println("GAME START");
        System.out.println();

    }
}
