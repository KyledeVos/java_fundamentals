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

        MyCustomBinaryTree customBinaryTree = new MyCustomBinaryTree();
        customBinaryTree.add("Hello");
        customBinaryTree.add("This");
        customBinaryTree.add("is");
        customBinaryTree.add("a");
        customBinaryTree.add("test");
        customBinaryTree.add("and");
        customBinaryTree.add("these");
        customBinaryTree.add("are");
        customBinaryTree.add("more");
        customBinaryTree.add("entries");
        customBinaryTree.add("and");
        customBinaryTree.add("more");
        customBinaryTree.add("plus");
        customBinaryTree.add("some");
        customBinaryTree.add("more");
        customBinaryTree.add("of");
        customBinaryTree.add("them");
        customBinaryTree.printInOrder(customBinaryTree.root);
//
        customBinaryTree.remove(0);
        System.out.println(customBinaryTree.search(1));
        customBinaryTree.update(1, "changed");
        System.out.println(customBinaryTree.search(1));


    }
}