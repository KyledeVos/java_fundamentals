package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

/**
 * Run the class below and study the output. What prints and why?
 *
 * Your answer:
 * The object is defined to be of type 'Parent Class' and set to a new instance of the child class
 * Objects declared in this manner do not have access to a child's class fields or methods unless
 * this method in the child class overrides a method from the parent class
 *
 * The output is 10 (declared in the parent class) as the object can only access fields from the parent
 * class
 */
class A {
    int i = 10;
}

class B extends A{
    int i = 20;
}

public class Exercise_02 {

    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.i);
    }
}