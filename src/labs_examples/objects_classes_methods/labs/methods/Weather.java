package labs_examples.objects_classes_methods.labs.methods;

public class Weather {

    String description;



    public Weather(String description){
        this.description = description;
    }

    public void setWeather(String type){
        description = type;
    }

    public void displayWeather(){
        System.out.println("Weather: " + this.description);
    }

}
