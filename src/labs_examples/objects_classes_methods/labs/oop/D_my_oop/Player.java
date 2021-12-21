package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);

    String name;
    Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}
