package labs_examples.objects_classes_methods.labs.objects;

public class Association {

    public static void main(String[] args) {

        Pen pen = new Pen("black", 0.5);
        Book book = new Book(190, "Software");

        System.out.println("My book has " + book.getPageCount() + " pages and is used for " + book.getPurpose() +
                            ". I write using a " + pen.getColour() + " pen with a nib size of " + pen.getNibSize() + " mm");

    }
}

class Pen{
    String colour;
    double nibSize;

    public Pen(String colour, double nibSize) {
        this.colour = colour;
        this.nibSize = nibSize;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getNibSize() {
        return nibSize;
    }

    public void setNibSize(int nibSize) {
        this.nibSize = nibSize;
    }
}

class Book{
    int pageCount;
    String purpose;

    public Book(int pageCount, String purpose) {
        this.pageCount = pageCount;
        this.purpose = purpose;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
