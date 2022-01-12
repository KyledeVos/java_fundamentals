package labs_examples.multi_threading.labs;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 *
 *      1) Create a Program that reads a String from an ArrayList and uses wait() and notify()
 *      to read one line at then write that line to a new file
 *
 *      2) Use a method to read a file line by line and put each line as a String in an Array List
 *
 *
 *
 */

public  class Exercise_05 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = returnArrayListFromFile();

        //DELETE
//        for(int i = 0; i< arrayList.size(); i++){
//            System.out.println(arrayList.get(i));
//        }

        CopyToFile copyToFile = new CopyToFile(arrayList);
        new Reader(copyToFile);
        new Writer(copyToFile);




    }

    public static ArrayList<String> returnArrayListFromFile(){

        ArrayList<String> stringList = new ArrayList<>();
        String inputFile = "src/labs_examples/multi_threading/labs/TaskList.txt";
        String line;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))){
            while((line = bufferedReader.readLine())!= null){
                stringList.add(line);
            }

        }catch(FileNotFoundException exc){
            System.out.println("File not Found");
        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }

        return stringList;
    }
}

class CopyToFile{

    String output = "src/labs_examples/multi_threading/labs/CopyTaskList.txt";
    PrintWriter printWriter = null;
    ArrayList<String> arrayList;
    int count;
    boolean reading;
    String line;
    int numberOfLines;

    public CopyToFile(ArrayList<String> arrayList){
        this.arrayList = arrayList;
        count = 0;
        reading = true;
        numberOfLines = this.arrayList.size();
        try{
            printWriter = new PrintWriter(new FileWriter(output));
        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }

    public synchronized void readFile(){
        if(!reading){
            try {
                wait();
            } catch(Exception exc){
                System.out.println(exc.getMessage());
            }
        }

        line = arrayList.get(count);
        count++;
        reading = false;
        notify();
    }

    public synchronized void writeFile(){
            if(reading){
                try{
                    wait();
                }catch(Exception exc){
                    System.out.println(exc.getMessage());
                }
            }

            printWriter.write(line+"\n");
            System.out.println(line);
            printWriter.flush();
            reading = true;
            notify();
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }
}

class Reader implements Runnable{

    CopyToFile copyToFile;
    Thread thread;

    public Reader(CopyToFile copyToFile){
        this.copyToFile = copyToFile;
        thread = new Thread(this, "Reader");
        thread.start();
    }

    @Override
    public void run() {
        int count = 0;
        while(count<copyToFile.getNumberOfLines()) {
            copyToFile.readFile();
            count++;
        }
    }
}

class Writer implements Runnable{

    CopyToFile copyToFile;
    Thread thread;
    int count = 0;

    public Writer(CopyToFile copyToFile){
        this.copyToFile = copyToFile;
        thread = new Thread(this, "Writer");
        thread.start();
    }

    @Override
    public void run() {

        while(count<copyToFile.getNumberOfLines()){
            copyToFile.writeFile();
            count++;
        }
    }
}