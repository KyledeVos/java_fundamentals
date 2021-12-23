package labs_examples.packages.labs.television;

import java.util.ArrayList;

public class SmartTv {

    public static void main(String[] args) {

    }

    public boolean powerOn;
    private ArrayList<String>apps;
    private int volume;

    public SmartTv() {
        this.powerOn = false;
        this.volume = 50;
        apps = new ArrayList<>();
    }

    public void showDownloadedApps(){
        System.out.println("Apps on Television");
        int count = 1;
        for(String app: apps){
            System.out.print(count + " - " + app +"\n");
        }
    }

    public void addApp(String appName){
        apps.add(appName);
    }

    protected void removeApp(String appName){
        for(String find: apps){
            if(find.equals(appName)){
                apps.remove(appName);
                System.out.println(appName + " has been removed");
                return;
            }
            System.out.println(appName + " not found in list of downloaded apps");
        }
        System.out.println();
    }

    protected void increaseVolume(int change){
        if((this.volume + change)>100){
            this.volume = 100;
        } else {
            this.volume+=change;
        }

    }

    protected void decreaseVolume(int change){
        if((this.volume - change)<=0){
            this.volume = 0;
        } else {
            this.volume-=change;
        }

    }


    public int getVolume() {
        return volume;
    }
}
