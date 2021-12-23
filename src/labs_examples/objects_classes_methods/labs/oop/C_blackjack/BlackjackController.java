package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Scanner;


public class BlackjackController {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        playFullGame();

    }

    public static void playFullGame(){


        System.out.println("Welcome to Black Jack!");
        System.out.println("Please enter name of Player:");
        String name = scanner.nextLine();
        Player player = new Player(name);
        Player comp = new Player("Computer");
        comp.setPotValue(1000);
        System.out.println("Please enter your pot amount. Please note computer will start with $1000");
        int pot = scanner.nextInt();
        scanner.nextLine();
        player.setPotValue(pot);

        menu();
        gameControl(player, comp);

    }

    public static void gameControl(Player player, Player comp){

        boolean quit = false;

        while(!quit) {


            if(comp.getPotValue() == 0) {
                System.out.println("Computer out of money. Game Over");
                System.out.println("Player has won total of $" + player.getPotValue());
                break;
            }
            int menuInput = scanner.nextInt();
            scanner.nextLine();


            switch (menuInput) {
                case 1:
                    System.out.println("Please enter amount to add to pot");
                    int pot = scanner.nextInt();
                    scanner.nextLine();
                    addToPotAmount(player, pot);
                    menu();
                    break;

                case 2:
                    System.out.print("Player ");
                    checkBalance(player);
                    menu();
                    break;

                case 3:
                    System.out.print("Computer ");
                    checkBalance(comp);
                    menu();
                    break;

                case 4:
                    if(playerOutOfMoney(player)){
                        System.out.println("Please add to pot or Exit Game");
                        menu();
                    } else if(comp.getPotValue() == 0) {
                        System.out.println("Computer out of money. Game Over");
                        System.out.println("Player has won total of $" + player.getPotValue());
                        quit = true;

                    } else {
                        playGame(player, comp);
                        if(comp.potValue!=0) {
                            menu();
                        }

                    }
                    break;

                case 5:
                    System.out.println("Game Statistics");
                    System.out.println("Total Games Played: " + Deck.getTotalGamesPlayed());
                    System.out.println("Player has won " + player.totalGamesWon + " games.");
                    System.out.println("Computer has won " + comp.totalGamesWon + " games.");
                    System.out.println();
                    menu();
                    break;

                case 6:
                    System.out.println("Game has ended");
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid Input");
                    menu();
                    break;
            }

        }

    }

    public static void menu(){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("Please Enter One of the following Actions:");
        System.out.println("1 - Add to Pot Amount\n" +
                           "2 - Check Balance\n" +
                           "3 - Check Computer Balance\n" +
                           "4 - Play BlackJack\n" +
                           "5 - Game Stats\n" +
                           "6 - Quit Game");
    }

    public static void addToPotAmount(Player player, int bet){
        player.changePotValue(true, bet);
        System.out.println("New Balance: " + "$" + player.getPotValue());
    }

    public static void checkBalance(Player player){
        System.out.println("Current Balance: " + "$" + player.getPotValue());
    }

    public static void playGame(Player player, Player comp) {

        //Creates new Deck for every game
        Deck deck = new Deck();
        deck.populateDeck();
        deck.setTotalGamesPlayed(1);

        //clear hand from previous games
        player.hand.cards.clear();
        player.hand.resetHandValue();
        comp.hand.cards.clear();
        comp.hand.resetHandValue();

        int betValue = getPlayerBet(player, comp);

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
        //String emptyScanner = scanner.nextLine();
        while (!quit) {

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

            if (player.hand.getHandValue() > 21) {
                System.out.println();
                System.out.println("Player: " + player.name + " is bust");
                System.out.println("Computer wins");
                comp.setTotalGamesWon();

                //sort bets and pots
                if(player.potValue== betValue){
                    System.out.println();
                    player.changePotValue(false, betValue);
                    System.out.println("Player out of Money");
                    comp.changePotValue(true, betValue);
                } else {
                    System.out.println();
                    System.out.println("Computer has won $" + betValue);
                    player.changePotValue(false, betValue);
                    comp.changePotValue(true, betValue);
                }

                quit = true;
                break;
            }

            if (comp.computerAI(player)) {
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

            if (comp.hand.bust()) {
                System.out.println("Computer bust!");
                System.out.println("Player wins");
                player.setTotalGamesWon();

                //sort bets and pots
                if(comp.potValue== betValue){
                    System.out.println();
                    comp.changePotValue(false, betValue);
                    System.out.println("Computer out of Money");
                    comp.changePotValue(true, betValue);
                } else {
                    System.out.println();
                    System.out.println("Player has won $" + betValue);
                    player.changePotValue(true, betValue);
                    comp.changePotValue(false, betValue);
                }

                quit = true;
                break;
            }

            if (playerInput.equals("no") && !comp.computerAI(player)) {

                if (player.hand.getHandValue() > comp.hand.getHandValue()) {
                    System.out.println(player.name + " wins");
                    player.setTotalGamesWon();

                    //sort bets and pots
                    if(comp.potValue== betValue){
                        System.out.println();
                        comp.changePotValue(false, betValue);
                        System.out.println("Computer out of Money");
                        comp.changePotValue(true, betValue);
                    } else {
                        System.out.println();
                        System.out.println("Player has won $" + betValue);
                        player.changePotValue(true, betValue);
                        comp.changePotValue(false, betValue);
                    }

                    quit = true;
                    break;

                } else if (player.hand.getHandValue() < comp.hand.getHandValue()) {
                    System.out.println("Computer wins");
                    comp.setTotalGamesWon();

                    //sort bets and pots
                    if(player.potValue== betValue){
                        System.out.println();
                        player.changePotValue(false, betValue);
                        System.out.println("Player out of Money");
                        comp.changePotValue(true, betValue);
                    } else {
                        System.out.println();
                        System.out.println("Computer has won $" + betValue);
                        player.changePotValue(false, betValue);
                        comp.changePotValue(true, betValue);
                    }

                    quit = true;
                    break;
                } else if(player.hand.getHandValue() == comp.hand.getHandValue()){
                    System.out.println("Draw");
                    System.out.println("No changes to pot value");
                    quit = true;
                    break;
                }
            }

        }


    }

    public static boolean playerOutOfMoney(Player player){

        return player.getPotValue() == 0;
    }

    public static int getPlayerBet(Player player, Player comp){

        System.out.println("Please Enter Value to bet. Computer will match if possible");
        int betAmount = scanner.nextInt();
        scanner.nextLine();
        boolean quit = false;

        while(!quit) {

            if(player.getPotValue() == betAmount){
                //scanner.nextLine();
                System.out.println("Going all in. Is this correct?");
                String input = scanner.nextLine();

                if(input.equals("yes")){
                    System.out.println("Player has gone all in");
                    quit = true;
                    break;
                } else {
                    System.out.println("Please Enter new Amount");
                    betAmount = scanner.nextInt();
                    scanner.nextLine();
                }
            }

            if(player.getPotValue()>betAmount){
                //scanner.nextLine();
                System.out.println("bet allowed");

                quit = true;
                break;
            }

            if (player.getPotValue() < betAmount) {
                //scanner.nextLine();
                System.out.println("Not Enough available for bet. Max Available is $" + player.getPotValue());
                System.out.println("Do you want to bet all?");
                String input = scanner.nextLine();

                if (input.equals("yes")) {
                    System.out.println("Player has gone all in");
                    betAmount = player.getPotValue();
                    quit = true;
                    break;
                } else {
                    System.out.println("Please Enter new Amount");
                    betAmount = scanner.nextInt();
                    scanner.nextLine();
                }
            }

            //scanner.nextLine();
        }

        if(comp.getPotValue()<=betAmount){
            System.out.println("Computer max available is: $" + comp.getPotValue());
            System.out.println("Computer has gone all in");
        } else {
            System.out.println("Computer will match bet amount of: $" + betAmount);
        }

        return betAmount;

    }

    public static void quickGame() {
        Deck deck = new Deck();
        deck.populateDeck();

        System.out.println("Please enter name of Player:");
        String name = scanner.nextLine();
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
        while (!quit) {

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

            if (player.hand.getHandValue() > 21) {
                System.out.println();
                System.out.println("Player: " + player.name + " is bust");
                System.out.println("Computer wins");

                quit = true;
                break;
            }

            if (comp.computerAI(player)) {
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

            if (comp.hand.bust()) {
                System.out.println("Computer bust!");
                System.out.println("Player wins");
                quit = true;
                break;
            }

            if (playerInput.equals("no") && !comp.computerAI(player)) {

                if (player.hand.getHandValue() > comp.hand.getHandValue()) {
                    System.out.println(player.name + " wins");
                    quit = true;
                    break;
                } else if (player.hand.getHandValue() < comp.hand.getHandValue()) {
                    System.out.println("Computer wins");
                    quit = true;
                    break;
                }
            }

        }
    }






}
