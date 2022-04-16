package labs_examples.datastructures.queue.labs;

public class CustomQueueClass<T> {

    //generic array as underlying data structure
    private T[] array = null;

    //variable used to count number of elements in array
    //needed as size of array does not change with addition or removal of items
    private int numberOfItems;

    //constructor initializes
    public CustomQueueClass(int initialArraySize){
        array = (T[]) new Object[initialArraySize];

        //set initial number of items to 0
        numberOfItems = 0;
    }

    //adds new item to the array (queue)
    //new item is added to the end of the array
    //if array size is nearly 3/4 full, then double the size of the field array
    //@Params new item to be added to array
    public void enqueue(T item){

        //add new item to array (queue)
        array[numberOfItems] = item;

        //increase number of active items in array by 1
        numberOfItems++;

        //check if numberOfItems exceed or equals three quarters of array size
        //If so, double the size of the array

        if (numberOfItems >= (int) (array.length*0.75)){
            resizeArray(true);
        }

    }

    //removes item from array
    //first item in array would have been the first added, so it is removed (FIFO)
    //@returns removed item or null if queue is empty
    public T dequeue(){

        //check if queue is empty
        try{
            queueEmpty("Cannot deQueue from empty queue");

            //at this point there is at least one item in the queue
            //retrieve Item to be removed for return (first item in array)

            T removedItem = array[0];

            //bring all items in array forward by one value and set last value to null
            //when completed

            int count = 0;
            for(int i = 0; i<numberOfItems; i++){
                array[count] = array[count+1];
                count++;
            }
            array[numberOfItems] = null;

            //decrease number of active items in array by 1
            numberOfItems--;

            //check if arraySize has been reduced to 1/4 of original size
            //if so, half array use by using resizeArray() method
            if(numberOfItems <= (int) (array.length*0.25)){
                resizeArray(false);
            }

            //return removedItem
            return removedItem;


        }catch(CustomQueueException exc){
            System.out.println(exc.toString());
            return null;
        }
    }

    //@returns first item in queue (array[0]) or null iif empty
    public T peekFirst(){
        if(numberOfItems==0){
            return null;
        } else{
            return array[0];
        }
    }

    //@returns last item in queue (array[numberOfItems-1]) or null if list is empty
    public T peekLast(){
        if(numberOfItems==0){
            return null;
        } else{
            return array[numberOfItems-1];
        }

    }

    //prints out all elements in queue in order of Item added to last item added
    //first arrayIndex to last
    public void printQueue(){

        System.out.println("\nItems in Queue:\n");
        for(int i = 0; i<numberOfItems; i++){
            System.out.println("Item " + (i+1) + ": " + array[i]);
        }
        System.out.println();

    }

    //returns number of 'active' elements in array
    public int getNumberOfItems() {
        return numberOfItems;
    }

    //returns full size of array
    public int arraySize(){
        return array.length;
    }

    //Checks i queue is empty (no items in queue)
    //@returns false if queue is not empty or throws CustomerQueueException if
    //queue is empty
    private boolean queueEmpty(String returnMessage) throws CustomQueueException{

        if(numberOfItems==0){
            throw new CustomQueueException(returnMessage);
        } else{
            return false;
        }
    }







    //accepts old array and increases arraySize by desired factor
    private void resizeArray(boolean increase){

        //declare copy array to resize old array
        T[] newArray;

        //create new array that will be twice the size of field array
        if(increase){

            newArray = (T[]) new Object[array.length * 2];

            //populate newArray (that is twice the size of field array) with original array values
            for(int i = 0; i< array.length; i++){
                newArray[i] = array[i];
            }

        } else {
            //create new array that is half the size of the old array
            newArray = (T[]) new Object[(int) (array.length / 2)];

            //populate new array with old array values
            for(int i = 0; i< newArray.length; i++){
                newArray[i] = array[i];
            }
        }

        //set field array equal to the new array which will resize it
        array = newArray;
    }



}
