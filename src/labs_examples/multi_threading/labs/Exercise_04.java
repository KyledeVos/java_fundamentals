package labs_examples.multi_threading.labs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

//A program allowing two threads to read data from the same String array and output to the same file
    //1) Use a Synchronized method
    //2) Use a Synchronized Block

  public class Exercise_04 {

      public static void main(String[] args) {

          String[] stringArray = {"This is the first line" , "This is the second string",
                                "This is the third String", "String number 4", "This is line five"
                                , "Additional String", "Adding more strings", "The year is now",
                                "Dont know what line this is now", "lots of Strings in this array",
                                "Still adding more", "more and more", "more", "last one"};

          //1) Synchronized Method
          FileControl control = new FileControl();
          WriteToFile first = new WriteToFile(stringArray, control, "first Thread");
          WriteToFile second = new WriteToFile(stringArray, control, "Second Thread");

          //2) Synchronized Block
          FileControl control2 = new FileControl();
          EncryptString third = new EncryptString(control2, stringArray, "Third Thread");
          EncryptString fourth = new EncryptString(control2, stringArray, "Fourth Thread");
      }
}

class FileControl extends Thread {

      int count;
      public FileControl(){
          count = 0;
      }

    public void increment(){
          count++;
      }

    public int getCount() {
        return count;
    }
}

class WriteToFile implements Runnable {

      PrintWriter printWriter = null;
      FileControl fileControl;
      Thread thread;
      String[] stringArray;
      String name;
      String output = "src/labs_examples/multi_threading/labs/output.txt";
      int count;

      public WriteToFile(String[] stringArray, FileControl fileControl, String name){

          this.fileControl = fileControl;

          try{
              printWriter = new PrintWriter(new FileWriter(output, true));
          } catch(Exception exc){
              System.out.println(exc.getMessage());
          }

          this.name = name;
          thread = new Thread(this, name);
          this.stringArray = stringArray;
          count = 0;
          thread.start();
      }

    @Override
    public void run() {
        writeToOutputFile();
    }

    public synchronized void writeToOutputFile(){

        count = fileControl.getCount();

          try {
              while (count < stringArray.length) {

                  printWriter.write("output from "+ name+ " " + stringArray[count] + "\n");
                  //System.out.println("output from "+ name+ " " + stringArray[count]);
                  printWriter.flush();
                  fileControl.increment();
                  count = fileControl.getCount();
              }
          } catch(Exception exc){
              System.out.println(exc.getMessage());
          }

      }
}

//2) Synchronized Block

class EncryptString implements Runnable{

      FileControl fileControl;
      PrintWriter printWriter = null;
      String outputFile = "src/labs_examples/multi_threading/labs/EncryptedOutput.txt";
      Thread thread;
      String[] stringArray;
      String name;
      int count;

      public EncryptString(FileControl fileControl, String[] stringArray, String name){
          this.fileControl = fileControl;
          this.stringArray = stringArray;
          this.name = name;

          try{
              printWriter = new PrintWriter(new FileWriter(outputFile, true));
          }catch(IOException exc){
              System.out.println(exc.getMessage());
          }

          thread = new Thread(this, name);
          count = fileControl.getCount();
          thread.start();
      }

    @Override
    public void run() {
        writeEncryptedOutput();
    }

    public void writeEncryptedOutput(){

        try {


                while (count < stringArray.length) {
                            String line = stringArray[count].replace('a', 'b');
                        printWriter.write("output from " + name + " " + line + "\n");
                        //System.out.println("output from " + name + " " + line);
                        printWriter.flush();

                    synchronized (fileControl) {
                        fileControl.increment();
                        count = fileControl.getCount();
                    }
                }


        } catch(Exception exc){
            System.out.println(exc.getMessage());
        }

    }
}

