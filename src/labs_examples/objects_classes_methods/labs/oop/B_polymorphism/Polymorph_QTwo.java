package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

import java.util.Scanner;

public class Polymorph_QTwo {


    public static void main(String[] args) {

        xBox threeSixty = new xBox("Kyle XBox");
        xBoxSeriesX versionTen = new xBoxSeriesX("Ted", true);

//        threeSixty.addGame();
//        threeSixty.addGame();
//        System.out.println("Searching for NFS: " + threeSixty.searchForGame("NFS"));

        versionTen.addGame();
        versionTen.addGame();
        versionTen.gameVersionChecks();
        versionTen.gameVersionChecks("NFS");



    }
}
class xBox implements GameConsole {

    private String name;
    private boolean on;
    private String[] games;
    private String[] apps;
    private int downloadedGamesCount =0;
    Scanner scanner = new Scanner(System.in);


    public xBox(String name) {
        this.name = name;
        this.on = true;
        games = new String[100];
        apps = new String[10];
    }

    public void addGame(){

        if(downloadedGamesCount<100) {
            System.out.println("Enter title to download");
            String input = scanner.nextLine();
            games[downloadedGamesCount] = input;
            downloadedGamesCount++;
        } else{
            System.out.println("No space remaining. Please delete games to free space");
        }
    }

    @Override
    public void TurnOn() {
        System.out.println("Xbox Turned On");
    }

    @Override
    public boolean searchForGame(String title) {
        for(int i = 0; i< games.length; i++){
            if(games[i].equals(title)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String appsOnConsole(String[] apps) {
        System.out.println("Please enter name of app");
        String input = scanner.nextLine();
        for(int i = 0; i< apps.length; i++){
            if(apps[i].equals(input)){
                return "found App";
            }
        }
        return "App not found";
    }

    public String[] getGames() {
        return games;
    }

    public int getDownloadedGamesCount() {
        return downloadedGamesCount;
    }
}

class xBoxSeriesX extends xBox {

    boolean fourKResolution;

    public xBoxSeriesX(String name, boolean fourKResolution) {
        super(name);
        this.fourKResolution = fourKResolution;
    }

    @Override
    public void TurnOn() {
        System.out.println("XBox Series X Turned On");
    }

    public void gameVersionChecks(){
        for(int i = 0; i<getDownloadedGamesCount(); i++ ){
            System.out.println("Title: " + getGames()[i] + " checking version");
            System.out.println("Would implement an update if required");
        }
    }

    public void gameVersionChecks(String game){
        System.out.println("Checking version of: " + game);
        System.out.println("Would implement an update if required");
    }


}
