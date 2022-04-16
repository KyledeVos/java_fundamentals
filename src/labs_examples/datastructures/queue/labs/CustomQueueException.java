package labs_examples.datastructures.queue.labs;

public class CustomQueueException extends Throwable {

    private String returnMessage;

    public CustomQueueException(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    @Override
    public String toString() {
        return returnMessage;
    }
}
