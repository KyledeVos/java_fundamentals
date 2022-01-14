package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

public class Exercise_06 {

    public static void main(String[] args) {

        CountControl control = new CountControl();
        FirstThread firstThread = new FirstThread(control);
        SecondThread secondThread = new SecondThread(control);

    }
}

class CountControl{

    private int count = 1;
    boolean firstRun = true;

    public synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }

    public synchronized void FirstIncrement(){
        while(!firstRun){
            try{
                wait();
            } catch(InterruptedException exc){
                System.out.println(exc.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " has counted " + count);
        increment();
        firstRun = false;
        notify();
    }

    public synchronized void SecondIncrement(){
        while(firstRun){
            try{
                wait();
            } catch(InterruptedException exc){
                System.out.println(exc.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " has counted " + count);
        increment();
        firstRun = true;
        notify();
    }

}

class FirstThread implements Runnable{

    CountControl control;
    Thread thread;

    public FirstThread(CountControl control){
        this.control = control;
        thread = new Thread(this, "First Thread");
        thread.start();
    }

    @Override
    public void run() {
        while(control.getCount() < 100){
            control.FirstIncrement();
        }
    }
}


class SecondThread implements Runnable{

    CountControl control;
    Thread thread;

    public SecondThread(CountControl control){
        this.control = control;
        thread = new Thread(this, "Second Thread");
        thread.start();
    }

    @Override
    public void run() {
        while(control.getCount() < 101){
            control.SecondIncrement();
        }
    }
}