package labs_examples.input_output.labs;

import java.io.*;
import java.sql.SQLOutput;

/**
 * Input/Output Exercise 3: variety
 *
 *    1) Demonstrate the usage of at least two additional Byte Streams
 *    2) Demonstrate the usage of at least two additional Character Streams
 *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
 *    4) Demonstrate the use of the DataInputStream and DataOutputStream
 *
 */

public class Exercise_03{
    public static void main(String[] args) {

        //1)
        //lineNumberStreamExample();\
        //sequenceInput();

        //2)
        //lineNumber();
        //stringReader();

        //3)
        //bufferOnByteStream();
        //bufferOnCharStream();

        //4)
        //dataInputAndOutput();
    }


//1a) Demonstrate the usage of at least two additional Byte Streams
    //Chosen Stream: LineNumberInputStream

    public static void lineNumberStreamExample(){

        File file = new File("src/labs_examples/input_output/labs/LineNumbers.txt");

        try(LineNumberInputStream lineNumberInputStream = new LineNumberInputStream(new FileInputStream(file));
            LineNumberInputStream secondReader = new LineNumberInputStream(new FileInputStream(file))){

            System.out.println("1) Reading from a File");
            int a;
            char c;

            while((a = lineNumberInputStream.read())!=-1){
                System.out.print((char) a);
            }
            System.out.println();
            System.out.println();
            System.out.println("2) Reading Line Numbers");

            while((a = secondReader.read())!=-1){
                c = (char) a;
                a = lineNumberInputStream.getLineNumber();

                System.out.println("Character: " + c + " is found on line: " + a);
            }

        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }

    }

//1b) Demonstrate the usage of at least two additional Byte Streams
    //Chosen Stream: SequenceInputStream

    public static void sequenceInput(){

        String firstFile = "src/labs_examples/input_output/labs/firstSequence.txt";
        String secondFile = "src/labs_examples/input_output/labs/secondSequence.txt";

        try(SequenceInputStream sequenceInputStream = new SequenceInputStream(new FileInputStream(firstFile)
                 , new FileInputStream(secondFile))){

            int reading;
            while((reading = sequenceInputStream.read())!=-1){
                System.out.print((char) reading);
            }

        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }

    //2a) Demonstrate the usage of at least two additional Character Streams
    //Chosen Stream: LineNumberReader

    public static void lineNumber(){

        int lineNumber = 0;
        int c;
        String source = "src/labs_examples/input_output/labs/firstSequence.txt";

        try(LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(source))){

            while((c= lineNumberReader.read())!=-1){
                lineNumber = lineNumberReader.getLineNumber();
                System.out.println("Character " + ((char)c) + " found on line " + lineNumber);
            }

        } catch(IOException exc){
            System.out.println(exc.getMessage());
            System.out.println("Error occured on line: " + lineNumber);
        }
    }

    //2b) Demonstrate the usage of at least two additional Character Streams
    //Chosen Stream: StringReader

    public static void stringReader(){

        String inputString = "treeclimbon456fromtweetoptup";
        int read=0;
        String encryptedPassword ="";

        try(StringReader stringReader = new StringReader(inputString)){

            while((read= stringReader.read())!=-1){
                if(read=='t' || read =='e'){
                    read = 'b';
                }
                encryptedPassword= encryptedPassword+ ((char) read);
            }
        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }

        System.out.println("Old PassWord: " + inputString);
        System.out.println("Encrypted Password: " + encryptedPassword);

    }

    // 3a) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams

    //a) Byte Stream Buffer

    public static void bufferOnByteStream(){

        String inputFile = "src/labs_examples/input_output/labs/firstSequence.txt";
        String outputFile = "src/labs_examples/input_output/labs/ByteBufferOutput.txt";

        byte[] buffer = new byte[8];
        int bytesRead;

        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile))){

            while((bytesRead = bufferedInputStream.read(buffer))!=-1){

                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }

    // 3b) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams

    //b) Character Stream Buffer

    public static void bufferOnCharStream(){

        String inputFile = "src/labs_examples/input_output/labs/firstSequence.txt";
        String outputFile = "src/labs_examples/input_output/labs/ByteBufferOutput.txt";
        String line;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(outputFile))){

            while((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line + "\n");
                bufferedWriter.flush();
            }

        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }

    }

    // 4) Demonstrate the use of the DataInputStream and DataOutputStream
    public static void dataInputAndOutput(){

        String outputFile = "src/labs_examples/input_output/labs/QuestionFour.txt";

        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(outputFile));
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(outputFile))) {

            //Demonstrating writing data to file
            dataOutputStream.writeDouble(2.04);
            dataOutputStream.writeInt(10);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeChar(100);
            dataOutputStream.writeFloat(567.89F);


            //Demonstrating reading from file
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readFloat());

        } catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}
