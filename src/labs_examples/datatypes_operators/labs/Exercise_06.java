package labs_examples.datatypes_operators.labs;

/**
 * Fundamentals Exercise 4: Volume and Surface Area
 *
 *      Write the necessary code to calculate the volume and surface area of a cylinder
 *      with a radius of 3.14 and a height of 5. Print out the result.
 *
 */

public class Exercise_06 {

    public static void main(String[] args) {

        // write code here

        double radius = 3.14;
        double height = 5;
        double pi = Math.PI;

        double volume = pi*radius*radius*height;
        double surfaceArea = 2*pi*radius*height + 2*pi*radius*radius;

        System.out.println("Volume of Cylinder: " + volume + " cubic units");
        System.out.println("Surface Area of Cylinder: " + surfaceArea + " units squared");

    }
}