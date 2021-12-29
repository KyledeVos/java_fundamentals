package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 *
 *      Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 *      Make sure you close the connections to both files.
 *
 *
 */

class Example {
    public static void main(String[] args) {

        String source = "src/labs_examples/input_output/labs/MorningRoutine.txt";
        String destination = "src/labs_examples/input_output/labs/Exercise_01_Copy.txt";

        FileInputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        FileOutputStream fileOutputStream = null;

        try{
            inputStream = new FileInputStream(source);
            bufferedInputStream = new BufferedInputStream(inputStream);

            fileOutputStream = new FileOutputStream(destination);

            byte[] buffer = new byte[5];
            int bytesRead = 0;

            while((bytesRead = bufferedInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer);
            }

        } catch(IOException exc){
            System.out.println(exc.toString());
        }

        try{
            inputStream.close();
        } catch(IOException exc){
            System.out.println(exc.toString());
        }

        try{
            bufferedInputStream.close();
        } catch(IOException exc){
            System.out.println(exc.toString());
        }

        try{
            fileOutputStream.close();
        } catch(IOException exc){
            System.out.println(exc.toString());
        }

    }
}