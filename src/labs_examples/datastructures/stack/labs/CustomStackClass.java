package labs_examples.datastructures.stack.labs;

import java.util.Stack;

public class CustomStackClass<T> {

    private T[] array = null;

    //number of active elements in the array
    private int countElements;

    //Constructor accepts user declared size of initial stack
    public CustomStackClass(int stackSize) {
        this.array = (T[]) new Object[stackSize];
    }


    //adds new elements to array(stack)
    //logic is LILO -> top of stack is taken to be last active element in array
    //add from first index to last
    //Params: element to be added to array
    public void push(T element){

       //as array can be resized, there is no need to check if the array is full before adding

        //add new element to array
        array[countElements] = element;

        //increase number of active elements in array
        countElements++;

        //check if number of active elements is larger or equal to three quarters the size of the array
        if(countElements >= (int) (array.length * 0.75)){
            resizeArray(true);
        }
    }


    //pops (removes) element off top of list
    //as elements are added from first to last index, the last index is taken to be the top of the stack
    //removes last element at index of countElement and number of active elements is decreased by one
    //if removal is successful (unless stack is empty)
    //returns element that is removed
    public T pop(){

        try{
            //checks if stack is empty
            stackEmpty("Cannot pop() from Empty Stack");

            //if this point is reached there is at least one element in the stack

            //pop() done on last element in list, set element to null and reduce element
            //count by 1. return removed element or null if StackEmptyException is caught
            T popReturn = array[countElements -1];
            array[countElements - 1] = null;
            countElements--;

            //check if arraySize has been reduced to 1/4 of full size
            if(elementNumber() <= (int) (array.length/4)){
                resizeArray(false);
            }

            return popReturn;

        }catch(StackEmptyException exc){
            System.out.println(exc.toString());
            return null;
        }
    }

    //checks if stack is empty by checking if number of active elements equals 0
    //throws StackEmptyException if active elements = 0
    //returns false if active elements > 0
    public boolean stackEmpty(String returnMessage) throws StackEmptyException{
        if(countElements == 0){
            StackEmptyException exc = new StackEmptyException(returnMessage);
            throw exc;
        } else {
            return  false;
        }
    }

    //returns element at top of stack (last element in array at index of number of
    //countElements or null if stack empty
    public T peekFirst(){

        try{
            //checks if stack is empty
            stackEmpty("Stack empty - cannot return any element values");

            //At this point stack has at least one value to return
            return array[countElements - 1];

        }catch(StackEmptyException exc){
            System.out.println(exc.toString());
            return null;
        }
    }

    //returns element at bottom of stack (first element in array at index of number of
    //countElements or null if stack empty
    public T peekLast(){

        try{
            //checks if stack is empty
            stackEmpty("Stack empty - cannot return any element values");

            //At this point stack has at least one value to return
            return array[0];

        }catch(StackEmptyException exc){
            System.out.println(exc.toString());
            return null;
        }
    }


    //returns the size of the underlying array
    public int size(){
        return array.length;
    }


    //returns size of stack array (number of active elements)
    public int elementNumber(){
        return countElements;
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


    //prints all elements to console from stack
    public void printStack(){
        for(int i = 0; i< countElements; i++){
            System.out.println("Element " + (i+1) + ": " + array[i]);
        }
    }

}
