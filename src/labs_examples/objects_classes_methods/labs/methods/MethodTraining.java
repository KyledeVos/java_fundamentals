package labs_examples.objects_classes_methods.labs.methods;

import java.util.ArrayList;

public class MethodTraining {

    public static void main(String[] args) {

        String greeting = "Hello.";
        Weather weather = new Weather("Sunny");

        //1) Demonstrate method overloading in this class
        System.out.println("Exercise 1 - Method Overloading");
        System.out.println("Results of average of two: " + average(5, 10));
        System.out.println("Results of average of any number of inputs: " + average(3, 5, 8, 9, 10, 15));
        System.out.println();

        //2) Demonstrate the difference between "pass by value" and "pass by reference"
        System.out.println("Exercise 2 - Pass by value vs pass by reference");
        System.out.println("Pass by Value");
        System.out.println("Initial String: " + greeting);
        System.out.println("Modified to: " + addToString(greeting));
        System.out.println("Initial String after modification: " + greeting);
        System.out.println();

        System.out.println("Pass by Reference");
        //uses the added Weather Class
        System.out.print("Initial weather value ");
        weather.displayWeather();
        Weather weather2 = weather;
        weather2.setWeather("rain");
        System.out.print("Weather after change by a new object ");
        weather.displayWeather();
        System.out.println();

        //3) Create a method that will return the largest of 4 numbers (all of which are passed in as arguments)
        System.out.println("Exercise 3: Return Largest Value");
        System.out.println(largestParameter(-1, 10, 3, 8));
        System.out.println();

        //4) Write a method to count all consonants (the opposite of vowels) in a String
        System.out.println("Exercise 4: Count Consonants in String");
        System.out.println("number of consonants is: " + countConsonantsInString("CodingNomads"));
        System.out.println();

        //5) Write a method that will determine whether or not a number is prime
        System.out.println("Exercise 5: Determine if number is Prime");
        System.out.println("Is Number Prime: " + isPrime(15));
        System.out.println();

        //6) Write a method that will return a small array containing the highest and lowest numbers in a
        // given numeric array which is passed in as an argument
        System.out.println("Exercise 6: Highest and lowest values in Array");
        int[] myArray = {4, 6 , 8, 2, 10, 15, 1 , 3 , 18 , 4};
        int[] maxAndMinArray = giveMaxAndMinArray(myArray);
        System.out.println("Max Value: " + maxAndMinArray[0]);
        System.out.println("Min Value: " + maxAndMinArray[1]);
        System.out.println();

        //7) Write a method that takes 3 arguments (int maxNum, int divisor1, int divisor2) and returns an
        // Integer Arraylist.In this method create an Integer ArrayList and populate it with each number
        // between zero and maxNum that is divisible by both divisor1 and divisor2. Then return this ArrayList.
        // After calling this method, print out the length of the returned list
        System.out.println("Exercise 7: Return all values within a range divisible by two divisors");
        ArrayList<Integer> divisibilityArrayList = divisibilityOfRange(20, 2, 5);
        System.out.println("Length of ArrayList: " + divisibilityArrayList.size());
        System.out.println();

        //8) Write a method that will reverse an array in place use only one extra temp variable.
        // For this exercise you cannot instantiate a second array. You must reverse the array in place
        // using only one extra temp variable. Hint: this variable is used to temporarily store individual
        // values in the array

        System.out.println("Exercise 8: Reverse Array in place");
        int[] myIntegerArray = {1 , 2 , 3, 4, 5 ,6};
        System.out.print("Initial Array: ");
        printArray(myIntegerArray);
        System.out.print("After Reversal: ");
        printArray(reverseArray(myIntegerArray));











    }


    //1) Demonstrate method overloading in this class
    public static int average(int a, int b){
        return (a+b)/2;
    }

    public static int average(int ... inputs){
        int sum = 0;

        for(int i = 0; i < inputs.length; i++){
            sum+=inputs[i];
        }

        return sum/inputs.length;
    }

    //2) Demonstrate the difference between "pass by value" and "pass by reference"
    public static String addToString(String firstString){
        firstString += " How are you";
        return firstString;
    }

    //3) Create a method that will return the largest of 4 numbers (all of which are passed in as arguments)
    public static int largestParameter(int a, int b, int c, int d){
        int highest = 0;
        if(a > highest){
            highest = a;
        }

        if(b> highest){
            highest = b;
        }

        if(c > highest){
            highest = c;
        }

        if(d > highest){
            highest = d;
        }

        return highest;
    }

    //4) Write a method to count all consonants (the opposite of vowels) in a String

    public static int countConsonantsInString(String input){
        int count = 0;
        for(int i = 0; i< input.length(); i++){
            char hold = input.charAt(i);
            if(hold != 'a' && hold != 'e' && hold != 'i' && hold != 'o' && hold != 'u'){
                count ++;
            }
        }
        return count;
    }

    //5) Write a method that will determine whether or not a number is prime

    public static boolean isPrime(int number){

        if(number == 1){
            System.out.println("Neither Prime nor Composite ");
            return false;
        }
        for(int i =2; i<number; i++){
            if((number%i) == 0){
                return false;
            }
        }
        return true;
    }

    //6) Write a method that will return a small array containing the highest and lowest numbers in a
    // given numeric array which is passed in as an argument

    public static int[] giveMaxAndMinArray(int[] myArray){

        int[] outputArray = new int[2];
        int min = myArray[0];
        int max = myArray[0];

        for(int i = 0; i< myArray.length; i++){
            if(myArray[i]<min){
                min = myArray[i];
            }

            if(myArray[i]>max){
                max = myArray[i];
            }
        }

        outputArray[0] = max;
        outputArray[1] =min;

        return outputArray;

    }

    //7) Write a method that takes 3 arguments (int maxNum, int divisor1, int divisor2) and returns an
    // Integer Arraylist.In this method create an Integer ArrayList and populate it with each number
    // between zero and maxNum that is divisible by both divisor1 and divisor2. Then return this ArrayList.
    // After calling this method, print out the length of the returned list

    public static ArrayList<Integer> divisibilityOfRange(int maxNum, int divisor1, int divisor2){
        ArrayList<Integer> divisibiltyArrayList = new ArrayList<>();

        for(int i = 0; i<=maxNum; i++){
            if((i%divisor1)== 0 && (i%divisor2)==0){
                divisibiltyArrayList.add(i);
            }
        }
        return divisibiltyArrayList;
    }

    //8) Write a method that will reverse an array in place use only one extra temp variable.
    // For this exercise you cannot instantiate a second array. You must reverse the array in place
    // using only one extra temp variable. Hint: this variable is used to temporarily store individual
    // values in the array

    public static int[] reverseArray(int[] input){
        int temp = 0;

        // [ 1 , 2 , 3 , 4 , 5 , 6]
        // [
        for(int i = 0; i<=(input.length-1)/2; i++){
            temp = input[input.length-(i+1)];
            input[input.length-(i+1)]= input[i];
            input[i] = temp;
        }

        return input;
    }

    public static void printArray(int[] array){
        for(int i = 0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}




