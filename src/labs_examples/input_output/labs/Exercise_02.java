package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 2: File encryption
 *
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files.
 *
 *      Then, read back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */

public class Exercise_02 {
    public static void main(String[] args) {

        String inputFile = "src/labs_examples/input_output/labs/MorningRoutine.txt";
        String outputFile = "src/labs_examples/input_output/labs/EncryptedFile_Exercise2.txt";


        EncryptFile(inputFile, outputFile);
        decryptFile(outputFile);

    }

    public static void EncryptFile(String inputFile, String outputFile){
        BufferedReader bufferedReader = null;
        FileWriter fileWriter= null;
        char readCharacter;

        try{
            bufferedReader = new BufferedReader(new FileReader(inputFile));
            fileWriter = new FileWriter(outputFile);

        }catch(IOException exc){
            System.out.println(exc.toString());;
        }

        try{

            while((readCharacter = (char) bufferedReader.read()) !='.'){
                if(readCharacter == 'a'){
                    readCharacter = '-';
                } else if(readCharacter == 'e'){
                    readCharacter ='~';
                }

                fileWriter.write(readCharacter);
            }

            fileWriter.write('.');

        } catch(IOException exc){
            System.out.println(exc.toString());
        }

        finally {
            try {
                bufferedReader.close();
                fileWriter.close();
            } catch(IOException exc){
                exc.toString();
            }
        }
    }

    public static void decryptFile(String filePath){

        BufferedReader bufferedReader = null;
        char readCharacters;

        try{
            bufferedReader = new BufferedReader(new FileReader(filePath));

            while((readCharacters= (char) bufferedReader.read()) !='.'){
                if(readCharacters == '-'){
                    readCharacters = 'a';
                } else if(readCharacters == '~'){
                    readCharacters = 'e';
                }

                System.out.print(readCharacters);
            }

        } catch(FileNotFoundException exc){
            System.out.println("Could not find input file");
        } catch(IOException exc){
            System.out.println(exc.toString());
        }

        finally {
            try{
                bufferedReader.close();
            }catch(IOException exc){
                System.out.println(exc.toString());
            }
        }

    }
}

