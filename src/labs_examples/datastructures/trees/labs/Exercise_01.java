package labs_examples.datastructures.trees.labs;

/*
    Trees: Exercise_01

    Please demonstrate how to create a custom Binary Search Tree (BST). Using your custom BST, demonstrate how to:

        1.) Create a new CustomBST
        2.) Insert new elements
        3.) Retrieve elements
        4.) Update elements
        5.) Delete elements
        6.) Print elements (Bonus: try in-order traversal, pre-order traversal, post-order traversal)
        7.) Keep the tree well balanced

 */

import labs_examples.datastructures.trees.examples.CustomBinarySearchTree;

public class Exercise_01{
    public static void main(String[] args) {

        //Testing Binary Tree type String
//        MyCustomBinaryTree customBinaryTree = new MyCustomBinaryTree();
//        customBinaryTree.add("Hello");
//        customBinaryTree.add("This");
//        customBinaryTree.add("is");
//        customBinaryTree.add("a");
//        customBinaryTree.add("test");
//        customBinaryTree.add("and");
//        customBinaryTree.add("these");
//        customBinaryTree.add("are");
//        customBinaryTree.add("more");
//        customBinaryTree.add("entries");
//        customBinaryTree.add("and");
//        customBinaryTree.add("more");
//        customBinaryTree.add("plus");
//        customBinaryTree.add("some");
//        customBinaryTree.add("more");
//        customBinaryTree.add("of");
//        customBinaryTree.add("them");
//        customBinaryTree.printInOrder(customBinaryTree.root);
////
//        customBinaryTree.remove(0);
//        System.out.println(customBinaryTree.search(1));
//        customBinaryTree.update(1, "changed");
//        System.out.println(customBinaryTree.search(1));

        //Testing Generic Binary Tree

        //1) String Type
        System.out.println("\nTesting String Type\n");
        GenericBinaryTree<String> stringTree = new GenericBinaryTree<>();
        stringTree.add("Hello");
        stringTree.add("This");
        stringTree.add("is");
        stringTree.add("a");
        stringTree.add("test");

        stringTree.printInOrder(stringTree.root);
        stringTree.remove(0);
        stringTree.printInOrder(stringTree.root);

        //2)int Type
        System.out.println();
        System.out.println("\nTesting Int Type\n");

        GenericBinaryTree<Integer> intTree = new GenericBinaryTree<>(1,2,3,4);
        intTree.printInOrder(intTree.root);

        //3) Object Type
        System.out.println("\nTesting Object Type\n");

        Car merc = new Car("Mercedes", 2);
        Car bmw = new Car("BMW", 2);
        Car lambo = new Car("Lambo", 3);

        GenericBinaryTree<Car> carTree = new GenericBinaryTree<>();
        carTree.add(merc);
        carTree.add(bmw);
        carTree.add(lambo);
        carTree.printInOrder(carTree.root);
        carTree.search(0);
        carTree.remove(0);
        carTree.printInOrder(carTree.root);


    }
}