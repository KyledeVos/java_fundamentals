package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 3:
 *
 *      In one of the previous exercises, demonstrate changing the priority of a thread
 */

//from Exercise_01

public class Exercise_03 {

    public static void main(String[] args) {

        Thread first = new Thread(new Count(), "first");
        first.setPriority(10);
        first.start();

        Count count = new Count();
        Thread second = new Thread(count, "second");
        second.setPriority(1);
        second.start();

    }
}

class NewCount implements Runnable{

    int count;

    public NewCount(){
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



