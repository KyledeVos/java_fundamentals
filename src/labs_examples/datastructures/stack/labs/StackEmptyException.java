package labs_examples.datastructures.stack.labs;

public class StackEmptyException extends Exception{

    private String returnMessage;

    StackEmptyException(String returnMessage){
        this.returnMessage = returnMessage;
    }

    @Override
    public String toString() {
        return returnMessage;
    }
}
