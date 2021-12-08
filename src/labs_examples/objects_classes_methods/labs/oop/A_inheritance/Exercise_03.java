package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

/**
 * Why does the output print in the order it does?
 *
 * You answer:
 * Class C_1 is a child class of class B_1 which is a child class of class A_1
 * The constructor for all classes has been set to print that it was called
 *
 * In the controller class we only see the constructor for class C_1 was called, but it must first call
 * the constructor for class B_1 which must first call the constructor for class A_1
 *
 */

class A_1 {
    public A_1()
    {
        System.out.println("Class A Constructor");
    }
}

class B_1 extends A_1 {
    public B_1()
    {
        System.out.println("Class B Constructor");
    }
}

class C_1 extends B_1 {
    public C_1()
    {
        System.out.println("Class C Constructor");
    }
}

public class Exercise_03 {
    public static void main(String[] args)
    {
        C_1 c = new C_1();
    }
}
