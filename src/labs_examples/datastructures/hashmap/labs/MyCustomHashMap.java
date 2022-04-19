package labs_examples.datastructures.hashmap.labs;

public class MyCustomHashMap<T,S> {

    //variable to keep track of number of items in array (bucket)
    private int itemCount;

    //array to hold hashMap
    //T -> Key
    //S -> Value
    private Item<T,S>[] bucket;

    //initialize new HashMap with arraySize and set number of items in array(bucket) to zero
    public MyCustomHashMap(int initialSize) {
        bucket = new Item[initialSize];
        this.itemCount = 0;
    }

    //uses hashCode of object(Key -> Type) to create 'unique' index for object in array
    private int uniqueCode(T type){
        int place = Math.abs(type.hashCode()%bucket.length);
        return place;
    }


    //adds new Item to HashMap
    //@Params item to be added
    public void add(T type, S store){

        //assign uniqueCode (hash) for index of new item to be added to array
        int place = uniqueCode(type);

        //if no item has been added to array at index of uniqueCode, create and add new Item
        if(bucket[place]==null){
            bucket[place] = new Item<>(type, store);
        } else {
            //at this point there is either one item in the index of the array or a LinkedList

            //check if this is the start of the linkedList
            if (bucket[place].follow == null){
                //add new item as follow
                bucket[place].follow = new Item(type, store);
            } else{
                //there is a LinkedList and new item must be added to the front of the list

                //create new item and point it to second item in linkedList
                Item<T, S> newItem = new Item<>(type, store);
                newItem.follow = bucket[place].follow;

                //set first item in list follow equal to new Item
                bucket[place].follow = newItem;
            }
        }

        //increment number of Items in array (bucket) by 1
        itemCount++;

        //check if bucket is more than half full, if so then called resizeBucket()
        if(itemCount > (int) bucket.length/2){
            resizeBucket();
        }
    }


    //finds item from hashMap
    //@Param Type (key) to search for
    //@returns value of item if item is found, null if item is not found (does not exist)
    //also prints message to console if item is not found
    public S find(T type){

        //use UniqueCode to find hash(index) of item in array
        int place = uniqueCode(type);

        //first check if there is nothing present at the index (place) in the array
        //implies there is neither one item there nor a linkedList
        if(bucket[place] == null){
            System.out.println("Item does not exist in HashMap");
            return null;

        } else{
            //this means the item may be at the index (place) in the array or in the linkedList
            //or may not exist
            //remember that each item in the linkedList at a specific hash(index) in the array
            //will have the same hash

            //first check if searchItem matches item in array (first item in LinkedList)

            Item<T,S> item = bucket[place];

            if(item.getType() != null){

                //iterate through linked list at matched uniqueCode and check if there is match for type (key)
                while(item.getType()!= type){

                    //if item's follow is null, then there is no match and return null;
                    if(item.follow==null){
                        System.out.println("Item does not exist in HashMap");
                        return null;
                    } else{
                        item=item.follow;
                    }
                }
            }

            //if no null has yet been returned then the item has been matched in the list
            //return its value

            return item.getStore();
        }
    }


    //remove item from list using key (type)
    //@returns boolean true if item is removed
    public boolean delete(T type){

        //check if item can be found in list
        //if not, return null and print message to console

        if(find(type) == null){
            System.out.println("Item not in list, cannot perform deletion");
            return false;
        }

        //at this point the item is in the list
        //retrieve uniqueCode (hash) of Item
        int place = uniqueCode(type);

        //get the Item at the index
        Item<T,S> item = bucket[place];

        //may not be the correct item as there could be a linkedList with other items sharing the same key
        //first check if item first in potential list matches key (type)

        if(item.getType().equals(type)){
            bucket[place] = item.follow;

        } else {
            //item is in linkedList
            //loop will iterate until item.follow has the correct type (key)
            while (item.follow!=null){
                //we do not have a previous node and therefore have to look one node ahead
                if(item.follow.getType() != type){
                    item = item.follow;
                }
            }

            //at this point the next item in the list is the correct one to remove
            item.follow = item.follow.follow;
        }

        //decrease value of itemCount
        itemCount--;
        return true;
    }

    //update value (Store_ of item in bucket
    //@Param type (key) of item to be updated
    //@Param newValue to replace old value (Store)
    //@returns boolean true if update successful
    //prints to console if item not find (done by find())
    public boolean update(T type, S newValue){

        //check if item is in list, if not return false
        if(find(type) == null){
            return false;
        }

        //Item is in list
        //check if item is in arrayIndex

        //get hash of item
        int place = uniqueCode(type);

        //check if item in bucket (first in index of array matches key(type)
        if(bucket[place].getType().equals(type)){
            bucket[place].setStore(newValue);
        } else {
            //item is therefore in linked list
            //Create iterator
            Item<T,S> iterator = bucket[place];

            //traverse through list until iterator equals
            //loop will run until iterator equals desired item
            while(iterator.getType()!=type){
                iterator = iterator.follow;
            }

            //at this point the iterator equals the desired value
            //update its stored value

            iterator.setStore(newValue);
        }
        return true;
    }


    //used to triple size of underlying array in HashMap if it is more than half full
    private void resizeBucket(){

        //reset number of items to 0 else the copy process will increment to the current number of added Items
        itemCount = 0;

        //create copy Array of the original array
        Item<T,S> [] copyArray = bucket;

        //triple the size of the original array
        //done here as we will recall the add method, but do not want to recall this resizeBucket Method
        bucket = new Item[copyArray.length*3];

        //iterate through copyArray
        for(int i = 0; i< copyArray.length; i++){

            //check if item is null (no item added at this index), if so, catch the null value and no do nothing
            try{
                Item item = copyArray[i];

                //call the add method to add this new item to the bucket Array
                //remember the add element is concerned with a linkedList in the bucket, not any
                //linkedLists that may come from this item
                add((T) item.getType(), (S) item.getStore());

                //check if item was the start of a LinkedList
                //if not this will terminate immediately
                //if so, traverse through each item in the LinkedList
                if(item.follow !=null){

                    //will iterate until the items in the LinkedList have been added to the bucket array
                    while(item.follow !=null){
                        //move to next item in list
                        item = item.follow;

                        //call add() to add the item to bucket Array
                        add((T) item.getType(), (S) item.getStore());
                    }
                }
            }catch(NullPointerException exc){
                //do nothing
            }
        }
    }

    
    //check number of items in array
    public int getItemCount() {
        return itemCount;
    }

    //Extra Method
    //print all values in array as neat list
    public void print(){

        //variable to count item number:
        int count = 0;

        for(int i = 0; i< bucket.length; i++){

            //check if item at index of i is not null
            //if it is null then do nothing and move to next item
            try {

                //check if item is not the start of a linkedList
                //if it is not, then print the item element() to console
                if (bucket[i].follow == null) {
                    System.out.println("Element " + (count+1) + ": " + "\"" + bucket[i].getType() + "\"" +  " Value: " + bucket[i].getStore());

                    //increment the count
                    count++;

                } else {

                    //item is the start of a linked list, and we traverse through it
                    //print each element in the linked list and increment the count each time

                    //create Iterator to traverse through list
                    Item<T, S> iterator = bucket[i];

                    while (iterator.follow != null) {
                        System.out.println("Element " + (count+1) + ": " + bucket[i].getType() + " Value: " + bucket[i].getStore());
                        iterator = iterator.follow;
                        count++;

                    }
                }
            }catch(NullPointerException exc){
                //do nothing
            }
        }
    }

    //check size of underlying array for testing purposes
    public int sizeOfBucket(){
        return bucket.length;
    }
}
