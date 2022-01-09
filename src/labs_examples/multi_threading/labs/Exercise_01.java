package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */

public class Exercise_01 {

    public static void main(String[] args) {

        Thread first = new Thread(new Count(), "first");
        first.start();

        Count count = new Count();
        new Thread(count, "second").start();

    }
}

class Count implements Runnable{

    int count;

    public Count(){
        count = 0;
    }

    @Override
    public void run() {
        System.out.println("Running New Count");
        for(int i = 0; i< 50; i++){
            System.out.println(count);
            count++;

            try{
                Thread.sleep(100);
            } catch(InterruptedException exc){
                System.out.println(exc.toString());
            }
        }
    }
}


