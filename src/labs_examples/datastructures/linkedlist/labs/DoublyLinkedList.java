package labs_examples.datastructures.linkedlist.labs;

public class DoublyLinkedList<T> {

    private DNode head;

    public DoublyLinkedList(T ...dNodeDataArray){

        //if DoublyLinkedList is initiated with no data then set head = null
        if(dNodeDataArray.length < 1){
            head = null;
        } else{
            //DoublyLinkedList is initiated with data then add data to list using the add method()
            //by default, the data will be added to the end of the list

            for(int i = 0; i< dNodeDataArray.length; i++){
                add(dNodeDataArray[i]);
            }
        }

    }

    //Add Methods:

    //1)
    //add() - adds data to list to back by default
    //Params: data to be added to list
    public void add(T data){

        if(head == null){
            //checks if list is empty and adds first node
            //personal note: 'prev' and 'next' are already set to null by DNode Constructor
            head = new DNode(data);
        } else{
            //there is already at least one node in the list
            //goal is to navigate to last node in the list and then add the new node

            //Iterator to traverse through list to the end
            DNode iterator = head;

            while(iterator.next !=null){
                iterator = iterator.next;
            }

            //at this point the iterator will be the last node in the list
            iterator.next = new DNode(data, iterator, null);
        }
    }

    //2)
    //add(data, toFront) - allows user to specify if data should be added to front or back
    //Params: data to be added
    //Params: boolean to add to front or not
    public void add(T data, boolean addToFront){

        //if user wants to add to back, call above add() method
        if(!addToFront){
            add(data);

        } else {
            //user wants to add data to front of list

            if(head == null){
                //list is empty, so no difference between adding to front or back of list
                add(data);

            } else {
                //there is at least one node in the list
                //new node becomes new head of list

                head = new DNode(data, null, head);

                //set new head previous equal to old head
                head.next.prev = head;
            }
        }
    }

    //3)
    //add(data, index) - allows user to specify index of where to add new node in list
    //Params: data to be added
    //Params: index at which new node is to be added, NOTE: index starts at 0
    public void add(T data, int index){

        if(head == null){
            //list is empty
            add(data);
        } else if(index == 0){
            //user wants to add data to front of list
            add(data, true);

        } else if(index < size()){
            //user wants to insert new node in middle of list

            //iterator to iterate through list
            DNode iterator = head;

            for(int i = 0; i<index; i++){
                iterator = iterator.next;
            }

            //at this point the iterator will equal the node in position of the desired index
            iterator.prev.next = new DNode(data, iterator.prev, iterator);
            iterator.prev = iterator.prev .next;


        } else{
            //at this point the user wants insert the new node at the end of the list
            //if index > size() of list then new node is automatically added to end
            add(data, false);

            //notify user if index > size() of list
            if(index > size()){
                System.out.println("Index > list size - new entry added to end of list");
            }
        }

    }



    //remove() methods:

    //1) remove() - removes first entry in the list
    public void remove(){

        //set node after head to new head
        head = head.next;

        //remove previous head connection to second element(new head)
        head.prev.next = null;

        //removes link to previous head
        head.prev = null;

    }

    //2)
    //popRemove() - removes first entry in list and shows removed element
    //returns String of node data

    public String popRemove(){

        //Store node data in temp string
        String data = (String) head.getNoteData();

        //call remove() method above
        remove();

        return "Removed:" + data;
    }

    //3)
    //removeLast - removes last node in list

    public void removeLast(){

        //iterator to traverse through list till last element
        DNode iterator = head;

        while(iterator.next !=null){
            iterator = iterator.next;
        }

        //set secondLast node next to null and then set last node previous to null
        iterator.prev.next = null;
        iterator.prev = null;
    }

    //4)
    //remove(index) - remove element from specific index
    //Params: int index at which node must be removed; indexed from 0
    public void remove(int index){

        if(index == 0){
            //user wants to remove head of list
            remove();

        } else if(index < size()){
            //user wants to remove node in middle of list

            //Node Iterator to traverse list
            DNode iterator = head;

            //variable to count as we traverse through list to index
            int count = 0;

            while(count < index){
                iterator = iterator.next;
                count++;
            }

            //iterator will now be node to be removed
            iterator.prev.next = iterator.next;
            iterator.next.prev = iterator.prev;

            //remove iterators connections to previous and next node
            iterator.prev = null;
            iterator.next = null;

        } else{
            //user wants to remove last element in list
            removeLast();
        }

    }

    //Get() Methods

    //1)get(index)
    //Params: index of node in list
    //returns: DNode element from list at specified index; indexed from 0 or Null

    public DNode get(int index){

        if(index == 0){
            //user wants to return head node

            return head;
        } else {
            //user wants to return node from middle of list or list node

            try{

                //iterator to traverse list
                DNode iterator = head;

                //variable to count as we iterate through list
                int count = 0;

                while(count < index){
                    iterator = iterator.next;
                    count++;
                }

                return iterator;

            }catch(NullPointerException exc){
                //user entered index greater than element number in list
                System.out.println("Index out of range");
                return null;
            }
        }
    }

    //2)
    //get(T element)
    //Params: Element Type T to search for in list
    //returns: DNode element from list if matching type or Null if no match

    public DNode get(T element){

        //iterator to traverse through list
        DNode iterator = head;

        while(iterator.next !=null){
            if(iterator.getNoteData() == element){
                return iterator;
            }
            iterator = iterator.next;
        }

        return null;

    }

    //Additional Methods

    //size() of list - number of elements in list
    //returns - int number of nodes in list
    public int size(){
        //variable to count number of elements in list
        int count = 0;

        //iterator to traverse through list
        DNode iterator = head;

        while(iterator != null){
            iterator = iterator.next;
            count++;
        }
        return count;
    }

    //print() - prints DNode data of each element in list
    public void print(){
        DNode iterator = head;

        while(iterator !=null){
            System.out.println(iterator.getNoteData());
            iterator = iterator.next;
        }
    }

    //clear() - removes all data from list
    //will delete each node from end of list back to head
    public void clear(){

        //iterator to traverse list
        DNode iterator = head;

        //traverse list until iterator is last node
        while(iterator.next !=null){
            iterator = iterator.next;
        }

        //delete each node connection until iterator equals head
        while(iterator.prev!=null){
            iterator = iterator.prev;
            iterator.next.prev = null;
            iterator.next = null;
        }

        //iterator will now equal head
        head = null;
    }




}
