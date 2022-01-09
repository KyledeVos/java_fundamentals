package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */

public class Exercise_02 {

    public static void main(String[] args) {

        Counter counter = new Counter();

    }
}

class Counter extends Thread{

    int count;

    public Counter(){
        count = 0;
        start();
    }

    @Override
    public void run() {
        System.out.println("Counting from 0");

        for(int i = 0; i< 50; i++){
            System.out.println(count);
            count++;

            try{
                Thread.sleep(100);
            } catch(InterruptedException exc){
                System.out.println(exc.getMessage());
            }
        }
    }
}
