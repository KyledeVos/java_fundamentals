package labs_examples.datastructures.linkedlist.labs;

import java.util.LinkedList;

public class SingleLinkedList<T> {

    private Node head;

    public SingleLinkedList(T ... nodeDataArray) {

        //If linkedList is initiated with no data then set head = null
        if(nodeDataArray.length < 1){
            head = null;

        } else {
            //if linked List is initiated with data then add data to the linked list using
            // the add method - following instruction that data can only be added to the front of the list
            for(int i = 0 ; i<nodeDataArray.length ; i++){
                add(nodeDataArray[i]);
            }
        }
    }

    //User wants to add data to linked list -> data to front of list
    //Params: data to be added
    public void add(T data){

        if(head == null){
            //checks if list is empty
            head = new Node(data);

        } else{
            //list is not empty and need to add new Node to the front of the list
            head = new Node(data, head);
        }
    }

    //user wants to specify to add data to front or end of list
    //Params: data to be added
    //Params: boolean to add to front of list or not (taken to mean end of list)
    public void add(T data, boolean front){

        if(front){
            //user wants to add data to front of list - call first add() method above
            add(data);
        } else{
            //user wants to add data to end of list

            Node iterator = head;

            while(iterator.next != null){
                iterator = iterator.next;
            }

            //once end of list has been reached by while loop, add new node to end of list
            iterator.next = new Node(data);
        }
    }


    //remove() -> first method means remove from front of list
    //Params: none
    public void remove(){

        if(head == null){
            System.out.println("Cannot remove from empty list");

        } else if(head.next == null) {
            //means there is only one node in the list, we set head to null
            head = null;

        } else {
            //occurs if there is more than one node in the list
            //we make the next node in the list the new head

            head = head.next;
        }
    }

    //remove(boolean front) -> Overloaded remove() allows user to specify to remove node
    //from front or back of list
    //Params: boolean to remove node from front or back of list
    public void remove(boolean front){

        if(front){
            //user wants to remove first node, call first remove()
            remove();

        } else{
            //user wants to remove element at the end of the list

            if(head == null){
                //list is empty
                System.out.println("Cannot remove from empty list");

            } else if(head.next == null){
                //there is only one node in the list
                head = null;

            } else{
                //there is more than one node in the list

                //previous to keep track of node before iterator.
                //iterator to traverse through list until the end is reached
                Node previous = null;
                Node iterator = head;

                while(iterator.next!= null){
                    previous = iterator ;
                    iterator = iterator.next;
                }

                //iterator will now equal last node in the list so iterator.next will equal to null
                //assign previous (node before last node) to equal to null (iterator.next)
                previous.next = null;

                //alternative is to say previous.next = iterator.next;
            }
        }
    }

    //get() - used to retrieve a node from the list
    //@Params: node value of type T
    //return: node data from list
    public T get(T node){

        //iterator to traverse through list
        Node iterator = head;

        while(iterator!=null){

            //compare node data from list with data of param object
            if(iterator.getNodeData() == node){
                return (T) iterator.getNodeData();
            }
            iterator = iterator.next;
        }

        //occurs if list is empty or there is no matching node in list
        return null;

    }

    ////////////////////////////////////////////////////////////////////

    //helper method 1 - print data of linked list to console
    //for object params please add a toString()
    public void print(){
        if(head == null){
            System.out.println("List Empty");
        } else {

            Node iterator = head;
            while(iterator !=null){
                System.out.println(iterator.getNodeData());
                iterator = iterator.next;
            }
        }
    }

    //helper method 2 - size()
    //returns number of elements in list (int)
    public int size(){

        //variable to count number of elements in list
        int count = 0;

        //iterator to traverse through list
        Node iterator = head;

        while(iterator!= null){
            count++;
            iterator = iterator.next;
        }

        return count;


    }




}
