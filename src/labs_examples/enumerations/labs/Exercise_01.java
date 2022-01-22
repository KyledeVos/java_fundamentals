package labs_examples.enumerations.labs;

/**
 * Enumerations Exercise 1:
 *
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a separate class.
 *      2) Create a parameterized enumeration that passes one or more values to its constructor. Demonstrate the use
 *      of this enum from a separate class.
 */

public class Exercise_01 {

    public static void main(String[] args) {

        //1)
        System.out.println("Question 1:");
        SchoolBag schoolBag = new SchoolBag("Kyle");
        schoolBag.printTextbooks();

        //2)
        System.out.println("\nQuestion 2");
        Catalogue catalogue = new Catalogue();
        catalogue.printCatalogue();
        catalogue.searchItem(OnlineItems.COASTER);
        catalogue.searchItem(OnlineItems.SMALLBOOKMARK);

    }
}


// 1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a separate class.
enum Textbook{

    MATHS , PHYSICS, ENGLISH , HISTORY , GEOGRAPHY;

}
class SchoolBag{

    public String studentName;
    int count = 1;

    public SchoolBag(String studentName){
        this.studentName = studentName;
    }

    public void printTextbooks(){
        System.out.println("Textbooks in " + studentName + "'s bag:");
        for(Textbook search : Textbook.values()){
            System.out.println(count + " " + search);
            count++;
        }
    }
}

//2) Create a parameterized enumeration that passes one or more values to its constructor. Demonstrate the use
// *      of this enum from a separate class.

enum OnlineItems{

    LARGEBOOKMARK(75, "Large"), SMALLBOOKMARK(35, "small") , COASTER(65, "normal") ,
    KEYRING(40 , "Medium");

    int price;
    String size;

     OnlineItems(int price, String size){
        this.price = price;
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }
}

class Catalogue{

    public void printCatalogue(){
        System.out.println("\nProduct Catalogue");
        for(OnlineItems onlineItems : OnlineItems.values()){
            System.out.println(onlineItems + " R" + onlineItems.getPrice() + ", size " + onlineItems.getSize());
        }
    }

    public void searchItem(OnlineItems search){

            System.out.println(search + " R" + search.getPrice() + " size: " + search.getSize());
    }



}