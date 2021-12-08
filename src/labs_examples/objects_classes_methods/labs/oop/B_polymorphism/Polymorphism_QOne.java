package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

import java.util.ArrayList;

public class Polymorphism_QOne {

    public static void main(String[] args) {

        Restaurant KFC = new Restaurant("KFC");
        KFC.addSale("Gerald", 50);
        KFC.addSale(70);
        System.out.println("Average Sales Value: " + KFC.averageSalesValue(KFC.getNumberOfSales()));
        Bar KFCBar = new Bar("KFC");
        KFCBar.addSale("Trevor", 100);
        KFC.CashUp();
        KFCBar.CashUp();
        
    }
}

class Restaurant implements POS{
    
    protected String RestaurantName;
    private ArrayList<Double> sales;
    private ArrayList<String> customers;
    private int numberOfSales;


    public Restaurant(String restaurantName) {
        RestaurantName = restaurantName;
        this.sales = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.numberOfSales= 0;
    }

    @Override
    public double averageSalesValue(int noOfCustomers) {
        double saleValues = 0;
        for(double saleValue : sales){
            saleValues+=saleValue;
        }
        return saleValues/sales.size();
    }

    @Override
    public String customerSearch(String name) {
        for(String checkName: customers){
            if(checkName.equals(checkName)){
                return checkName;
            }
        }
        return null;
    }

    @Override
    public boolean findSaleTotal(double saleTotal) {
        for(double holdSaleValue : sales){
            if(holdSaleValue == saleTotal){
                return true;
            }
        }
        return false;
    }

    public void addSale(String name, double sale){
        numberOfSales++;
        customers.add(name);
        sales.add(sale);
    }

    //Method Overloading

    public void addSale(double sale){
        numberOfSales++;
        customers.add("default");
        sales.add(sale);
    }

    public void CashUp(){
        int count = 0;
        for(String name: customers){
            System.out.print("Customer: " + name + " total: ");
            System.out.println(sales.get(count));
            count++;
        }


    }


    public String getRestaurantName() {
        return RestaurantName;
    }

    public int getNumberOfSales() {
        return numberOfSales;
    }

}

class Bar extends Restaurant{

    public Bar(String restaurantName) {
        super(restaurantName);
    }

    @Override
    public void addSale(String name, double sale) {
        name+= " bar sale";
        super.addSale(name, sale);
    }

    @Override
    public void CashUp() {
        System.out.println("Bar CashUp:");
        super.CashUp();
    }
}

