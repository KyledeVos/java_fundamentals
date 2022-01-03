 package labs_examples.input_output.labs;

 import java.io.*;
 import java.util.ArrayList;

 /**
 *
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 *
 */

public class Exercise_04{

    public static void main(String[] args) {

        ArrayList<Bike> bike = new ArrayList<>();
        String csvSource = "src/labs_examples/input_output/labs/bikes.csv";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(csvSource))){

            String lineRead;

            while((lineRead = bufferedReader.readLine())!= null){
                String[] bikeComponents = lineRead.split(",");
                bike.add(mapValuesToBikeObject(bikeComponents));
            }
        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }

        for(Bike search: bike){
            System.out.println(search.toString());
        }

        //2) Write the arrayList of objects to valid csv File
        String outputCSV = "src/labs_examples/input_output/labs/bikeOutput.csv";
        try(BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(outputCSV))){

            String line;
            for(Bike search : bike){
                line = search.getName()+ "," + search.getMake() + ", " + search.getEngineSize()+ "," + search.getColour();
                bufferedWriter.write(line+"\n");
                bufferedWriter.flush();
            }


        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }

    }

    public static Bike mapValuesToBikeObject(String[] bikeComponents){

        Bike bike = new Bike();

        bike.setName(bikeComponents[0]);
        bike.setMake(bikeComponents[1]);
        bike.setEngineSize(Double.parseDouble(bikeComponents[2]));
        bike.setColour(bikeComponents[3]);

        return bike;
    }



}
