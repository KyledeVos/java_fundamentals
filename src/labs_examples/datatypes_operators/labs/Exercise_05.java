package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all logical operators below. These include:
 *
 * AND, short-circuit AND, OR, short-circuit OR, XOR, NOT
 *
 */
class LogicalOperators {

    public static void main(String[] args) {

        // example of "OR"
        boolean a = true;
        boolean b = false;
        if (a | b){
            System.out.println("a or b is true");
        }

        // write your code below

        if( a || b) {
            System.out.println("either a or b is true. If a is true then b is not evaluated");
        }

        if( a & b){
            System.out.println("both a and b are true");
        } else {
            System.out.println("Either a or b is false or both are false");
        }

        if (a && b){
            System.out.println("both a and b are true");
        } else {
            System.out.println("In this case 'a' is false meaning b was not evaluated as this is the shortcut");
        }

        if(a ^ b){
            System.out.println("either a or b was true, but not both");
        }

        if (!(a)) {
            System.out.println("a was false");
        } else {
            System.out.println("a was true");
        }


    }

}

