package labs_examples.packages.labs.remote;

import labs_examples.packages.labs.television.SmartTv;

public class TVremote {

    public static void main(String[] args) {

        SmartTv smartTv = new SmartTv();
        turnOnTV();

    }

    public static void turnOnTV(){
        SmartTv smartTv = new SmartTv();
        smartTv.showDownloadedApps();
        smartTv.addApp("Netflix");
        smartTv.addApp("YouTube");
        smartTv.showDownloadedApps();

        //this will not work as removeApp has been declared protected
        //smartTv.removeApp();





    }
}
