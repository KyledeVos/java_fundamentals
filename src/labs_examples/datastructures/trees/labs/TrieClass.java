package labs_examples.datastructures.trees.labs;

public class TrieClass {

    private NodeTrie root;

    //initialize the data structure
    public TrieClass(){
        root = new NodeTrie('\0');
                // \0 means empty character
    }

    //inserts a word into the trie
    //@param new String to be inserted
    public void insert(String word){

        //need iterator node to keep track as we iterate through the data Structure starting from root
        NodeTrie curr = root;

        //iterate through Trie
        //remember that each char holds an int value
        for(int i = 0; i<word.length(); i++){

            //iterate through trie and if node is null, then create new node using
            //current character from word
            char c = word.charAt(i);

            ///note that array size is 26 so to add entries into array at an index that corresponds to a character
            //we have to create a 'start' point
            //char 'a' has int value 97, so by subtracting 'a' from any char (a-z) we can create a valid index
            //at which to store the node from its char value
            //eg) 'h' -> 104 so (h - 'a') = 104 - 97 = 7 so store 'h' in index of 7

            //check if char is already inserted in array, if not then we create a new Node with the current
            //character in the word
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new NodeTrie(c);
            }
            // we then iterate to the next node in the tree
            //could be one that was already there or one we just created above
            curr = curr.children[c-'a'];
        }

        //at this point we have exited the for loop and would be at the final character of the word
        //This may have already been in the trie or one we have added
        //we then set this last character to be the end of a word (which it may have already been from another word)
        curr.isWord = true;

    }

    //search for a word in the trie
    //@param String word to search for
    //@return true if word is found, false if not found
    public boolean search(String word){
        NodeTrie node = getNode(word);
        return node != null && node.isWord;
    }

    //checks if there is any node in the trie that starts with the given prefix
    //@param String prefix to search for
    //@return true if found, false if not found
    public boolean startsWith(String prefix){
        return getNode(prefix) !=null;
    }

    //Helper Method
    //used to iterate through tree and find the last node in the word being searched for
    //@param word to be searched for
    //@return last node of word in tree
    private NodeTrie getNode(String word){

        //iterator node starting at root
        NodeTrie curr = root;

        //iterate through tree
        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);

            //as we iterate, if there is no node that matches then we know the word is not on the path
            //and return null;
            if(curr.children[c-'a'] == null){
                return null;
            }

            //iterate to next node in tree
            curr = curr.children[c-'a'];

        }

        //at this point curr would equal the last node in the word
        return curr;

    }

    public boolean remove(String word){

        //1) check if tree is empty
        if(root == null){
            System.out.println("empty tree - cannot perform removal");
            return false;
        }

        //2) check if word exists in Trie
        if(!search(word)){
            System.out.println("Word does not exist in list - Cannot remove");
            return false;
        }

        //At this point we know the word does lie in the list
        //conditions for removal:
        // * Word cannot be removed if it is the full prefix for another word
        // * If the word shares a prefix with another word, then only the unique part of the word
        // after the prefix is removed.

        //use getNode to get the last node in the word
        NodeTrie temp = getNode(word);

        //If final node has children then the whole word is a prefix to another and cannot be deleted
        if(numberOfChildren(temp)>0){
            System.out.println("\'"+ word +"\'" + " is a prefix to another word and cannot be removed");
            return false;
        }

        //at this point the whole word or parts of it can be removed
         remove(root, word, 0);

        return true;

    }


    //Helper Method
    //Recursively moves from beginning of word to end
    private boolean remove(NodeTrie node, String word, int count){

        boolean continueRemoval = true;
        NodeTrie temp = node.children[word.charAt(count) - 'a'];
        count++;

        if(numberOfChildren(temp)>0){
            continueRemoval = remove(temp, word, count);


            if(numberOfChildren(temp)==1 && continueRemoval){
                for(int i = 0; i< temp.children.length; i++){
                    temp.children[i] = null;
                }
            }

        }
        if(numberOfChildren(temp)==0 && temp.isWord){
            return true;
        } else {
            return false;
        }

    }

//    private void remove(NodeTrie node, String word, int count){
//
//        NodeTrie temp = node.children[word.charAt(count) - 'a'];
//        count++;
//
//        if(numberOfChildren(temp)>0){
//            remove(temp, word, count);
//
//            if(numberOfChildren(temp)==1){
//                for(int i = 0; i< temp.children.length; i++){
//                    temp.children[i] = null;
//                }
//            }
//
//        }
//        if(numberOfChildren(temp)==0){
//            return;
//        }
//
//
//
//
//    }
    //print words in tree

    public void print(){

        print(root, "");

    }

    //Helper Method
    //@param current node in trie
    //@param String prefix
    private void print(NodeTrie node, String prefix){

        //iterate through all indexes in child array until one
        //that is not null is found
        for(int i = 0; i<node.children.length; i++){

            //reset prefix for next node child
            if(node == root){
                prefix = "";

            }

            //set temp node equal to current child
            NodeTrie temp = node.children[i];

            //if child node is not null
            if(temp!=null){

                if(temp.children.length>0){

                    //holds current prefix when moving back up the path in case
                    //there are other children at an earlier point that share the same prefix
                    String oldPrefix = prefix;

                    //add current node character to prefix
                    prefix = prefix + temp.c;

                    if(temp!=null && temp.isWord){

                        //once end of word is found, print to console
                        System.out.println(prefix);
                    }

                    //recursively move to next node in path
                    print(temp, prefix);

                    //resets prefix back to old prefix to stop overlay of characters from moving down
                    //used we come back from the recursive calls
                    prefix = oldPrefix;
                }

            }

        }

    }

    //checks if node contains any children
    private int numberOfChildren(NodeTrie node){
        int count = 0;
        for(int i = 0; i < node.children.length; i++){
            if(node.children[i]!=null){
                count++;
            }
        }
        return count;
    }

}
