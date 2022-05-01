package labs_examples.datastructures.trees.labs;

public class GenericBinaryTree<T> {

    //count number of elements in tree
    int nodeCount;

    //number assigned to each key as elements are added
    int assignmentNumber;

    GenericNode root;

    public GenericBinaryTree(T...data) {

        //set initial number of nodes in tree to 0
        nodeCount = 0;
        assignmentNumber = 0;

        //if no data is entered during initialization, set root to null
        if(data.length<1){
            root = null;
        }

        //if data is entered, add each element to tree
        else {
            for(int i = 0; i< data.length; i++){
                add(data[i]);
            }
        }
    }

    //Adds new elements to tree by calling recursive add() method
    //@param data to be added
    public void add(T element){

        //create new Node to be added
        GenericNode newNode = new GenericNode(assignmentNumber, element);

        //if tree is empty, set root = new element
        if(root == null){
            root = newNode;

            //increment number of nodes in tree
            nodeCount++;

            //change assignment number for next node
            assignmentNumber++;

            //if tree is not empty, call recursive add() method passing in new Node to be added and
            //the root node
        } else{
            root =  add(newNode, root);
        }
    }

    //recursive add() method
    //@param newNode to be added
    //@param node
    //@return new node recursively
    private GenericNode add(GenericNode newNode, GenericNode node){

        //create a new node once appropriate left or right child has been found (would be null)
        if(node == null){
            node = newNode;
            nodeCount++;
            assignmentNumber++;
        }

        //first check if element key is smaller than current key
        if(newNode.getKey()< node.getKey()){
            node.leftChild = add(newNode, node.leftChild);

            //then check if element key is greater than current key
        } else if(newNode.getKey()> node.getKey()) {
            node.rightChild = add(newNode, node.rightChild);

        }
        //node is identical to one already in tree
        else {
            return node;
        }

        //perform tree re-balance
        return rebalanceAfterInsert(newNode, node);

    }

    //Rebalances the Tree after a new node has been added
    //@Param node just added
    //@Param data added to new node
    //@return root of balanced tree (node)

    private GenericNode rebalanceAfterInsert(GenericNode newNode, GenericNode node){

        //get the heights of the child nodes to perform balance check
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);

        //update Node's height to greatest height of child plus 1
        node.height = 1 + Math.max(leftHeight, rightHeight);

        //calculate balance factor
        int bf = leftHeight - rightHeight;

        //check cases to determine if tree is unbalanced and course of action to correct

        //1)
        //leftChild is bigger and newNode key is smaller than leftChild Key
        if(bf > 1 && newNode.getKey() <node.getKey()){
            return  rotateRight(node);
        }

        //2) rightChild is bigger and newNode key is bigger than rightChildKey
        if(bf < -1 && newNode.getKey() > node.rightChild.getKey()){
            return rotateLeft(node);
        }

        //3) leftChild is bigger and newNode key is bigger than leftChild
        if(bf > 1 && newNode.getKey() > node.leftChild.getKey()){
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }

        //4) rightChild is bigger and newNode key is smaller than rightChild key
        if(bf < -1 && newNode.getKey() < node.rightChild.getKey()){
            node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }

        return node;

    }

    //rotates the node's rightChild to the current node position
    //used to rebalance if tree is too long on the right
    //@param current node to be checked
    //@return new root of subtree
    private GenericNode rotateLeft(GenericNode node){

        //copy Node's rightChild
        GenericNode child = node.rightChild;

        //make backup of leftChild
        GenericNode grandchild = child.leftChild;

        //rotate - set the new left child to be the node we are inserting
        child.leftChild = node;

        //set the rightChild to what was formerly the left child
        node.rightChild = grandchild;

        //update heights
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = height(child.leftChild);
        rightHeight = height(child.rightChild);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        node = child;
        return node;

    }

    //rotates the node's leftChild to the current node position
    //used to re-balance if tree is too long on the left
    //@param current node to be checked
    //@return new root of subtree
    private GenericNode rotateRight(GenericNode node) {

        // copy node's leftChild child
        GenericNode child = node.leftChild;
        // make a backup of right child
        GenericNode formerRightChild = child.rightChild;

        // rotate - set the new right child to the node we're inserting
        child.rightChild = node;
        // set the left child to what was formerly the right child
        node.leftChild = formerRightChild;

        // update heights
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        leftHeight = height(child.leftChild);
        rightHeight = height(child.rightChild);
        child.height = 1 + Math.max(leftHeight, rightHeight);

        node = child;
        return node;
    }

    //searched for the node in tree with the specified key value
    //@param key to be searched for
    //@return node if found, null if not found

    public GenericNode search(int key){
        return search(key, root);
    }

    //recursive search - searched recursively through tree until key is found (or not present)
    //@param key to be searched for
    //@param root node of tree
    //@return node matching desired key if found, null if not found

    public GenericNode search(int key, GenericNode node) {

        //check that the end of a branch has not yet been reached
        if (node != null) {
            if (node.getKey() == key) {
                //node with matching key has been found
                return node;
            }

            //follow the left branch if key value is smaller than current node key value
            else if (key < node.getKey()) {
                return search(key, node.leftChild);
            }

            //follow the right branch if key value is greater than current node key value
            else if (key > node.getKey()) {
                return search(key, node.rightChild);
            }
        }

        //else desired key cannot be found
        return null;
    }

    //remove element from tree
    //first check if elements exists, if not return
    //if element exists - recursively remove
    //@param key of node to be removed

    public void remove(int key){
        if(search(key)==null){
            return;
        }

        //at this point we know the node does exist
        System.out.println("Removing: " + search(key).getData());
        root = remove(key, root);
    }

    //recursively remove node
    //@param key of node to be removed
    //@param node for recursive calls
    //@return node for recursive calls

    private GenericNode remove(int key, GenericNode node){

        //recursively move through left and right children until desired node is found

        if(key<node.getKey()){
            node.leftChild = remove(key, node.leftChild);

        } else if(key>node.getKey()){
            node.rightChild = remove(key, node.rightChild);
        }

        //at this point we would be at the desired node
        else{

            //1) node is a leaf node so can simply be removed
            //through recursive iteration - this will terminate the recursions
            if(node.leftChild == null && node.rightChild==null){
                nodeCount--;
                return null;
            }

            //2) rightChild but no leftChild
            else if(node.leftChild==null){
                //delete current node and link to RightChild branch
                nodeCount--;
                return node.leftChild;
            }

            //3) leftChild but no rightChild
            else if(node.rightChild==null){
                //delete current node and link to LeftChild branch
                nodeCount--;
                return node.leftChild;
            }

            //4) node has two branches
            else{
                // get the smallest node that's bigger than leftChild node
                // swap its value to the current node position then remove the old node
                GenericNode smallest = node.rightChild;
                //iterate down the leftChild to the smallest node
                while(smallest.leftChild!=null){
                    smallest = smallest.leftChild;
                }
                //swop node with smallest
                T tempData = (T) node.data;
                int tempKey = node.getKey();
                node.data = smallest.data;
                node.key = smallest.getKey();
                smallest.data = tempData;
                smallest.key = tempKey;

                //remove old smallest node

                node.rightChild = remove(key, node.rightChild);

            }
        }
        return rebalanceRemove(node);
    }

    //rebalances the tree after a node has been removed
    //@param node root
    //@return root of balanced tree

    private GenericNode rebalanceRemove(GenericNode node){

        //update height
        int leftHeight = height(node.leftChild);
        int rightHeight = height(node.rightChild);
        node.height = 1 + Math.max(leftHeight, rightHeight);

        //calculate balanceFactor of node

        int bf = leftHeight - rightHeight;

        //calculate leftChild balance
        leftHeight = 0;
        rightHeight = 0;

        if(node.leftChild !=null){
            leftHeight = height(node.leftChild.leftChild);
            rightHeight = height(node.leftChild.rightChild);
        }

        int balanceLeft = leftHeight - rightHeight;

        //calulate rightChild Balance
        leftHeight = 0;
        rightHeight = 0;
        if (node.rightChild != null) {
            leftHeight = height(node.rightChild.leftChild);
            rightHeight = height(node.rightChild.rightChild);
        }
        int balanceRight = leftHeight - rightHeight;

        // rebalance
        if (bf > 1 && balanceLeft >= 0) {
            return rotateRight(node);
        }
        if (bf > 1 && balanceLeft < 0) {
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }
        if (bf < -1 && balanceRight <= 0) {
            node =  rotateLeft(node);
            return node;
        }
        if (bf < -1 && balanceRight > 0) {
            node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }

        return node;
    }

    //update an element in the tree
    //@param key of element to be updated
    //@param new data to be inserted
    //@param new data
    //@return boolean false is element not found, true when changed

    public boolean update(int key, String data){

        //search for node in tree with specified key
        GenericNode temp = search(key);

        //check if node exists, if not return false
        if(search(key)==null){
            return false;
        }

        //node exists, change data in node and return true
        temp.data = data;
        return true;
    }

    //return number of elements in tree
    public int getNodeCount() {
        return nodeCount;
    }

    //returns the height of a node
    //@Param node for which height is checked
    //@return height of node
    private int height(GenericNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public void printInOrder(GenericNode node){
        if(node == null){
            return;
        }
        printInOrder(node.leftChild);
        System.out.println(node.getData() + " ");
        printInOrder(node.rightChild);
    }

    public void printPreOrder(GenericNode node){
        if(node == null){
            return;
        }

        System.out.println(node.getData() + " ");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }

    public void printPostOrder(GenericNode node){

        if (node==null){
            return;
        }

        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
        System.out.println(node.data + " ");
    }
}
