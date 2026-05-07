/*
    LINKED LIST 

    What is a Linked List?
    A Linked List is a dynamic linear data structure where elements are
    stored in separate memory locations and connected using references.

    Unlike arrays:
    - Arrays require contiguous memory allocation
    - Insertion/deletion in arrays may require shifting elements
    - Linked Lists can grow dynamically during runtime

    What is a Singly Linked List?
*   A Singly Linked List is a linear data structure in which each node contains:
 *  - A value (data- int, String, float)
 *  - A reference (next) to the next node in the list.
 * 
 *      We can compare a Single Linked List with a train for better understanding. 
 *      - The engine represents the head node.
 *      - Each compartment (node) is connected to the next one
 *      - The last compartment points to null (end of train)

    Why use head and tail?
    - head gives direct access (reference) to the starting node
    - tail (last node) helps perform insertion at the end in O(1) time

    Why traversal is needed?
    Since nodes are not stored continuously like arrays,
    we must move node-by-node to access elements.

    Supported operations are:
    - Insertion (front, back, specific index)
    - Deletion (front, back, specific index)
    - Traversal (visiting each node) and searching
 */

package dsa.linkedlist;

public class SinglyLinkedList {

    // Variables and internal Classes

    // head stores reference to first node of linked list
    // traversal of linked list always starts from head
    private Node head; //first node

    // tail stores reference to last node
    // helps in O(1) insertion at the end. [O(1)- (constant time complexity- best)]
    // without tail, traversal till last node would be required every time
    private Node tail;

    // size keeps track of total number of nodes present in linked list
    private int size;

    // accessing value at head or tail- O(1)
    // direct access is possible because head and tail references are already maintained

    public int getHead(){

        // returns value stored in first node
        return head.value;
    }

    public int getTail(){

        // returns value stored in last node
        return tail.value;
    }

    /**
     Node -single element in linked list

     Each node contains:
     - value -> actual data stored
     - next -> reference to next node in sequence

     Nodes are connected together to form linked structure.

     "this.value"- 'this' keyword refers to the current object and is used
     to access instance variables or resolve naming conflicts
     */

    private class Node{

        // stores actual data of node
        private int value;

        // stores reference to next connected node
        // null indicates end of linked list
        private Node next;

        public Node(int value){

            // assigns parameter value to current object's value
            this.value = value;
        }

        public Node(int value, Node next){

            // initializes node with both value and next reference
            this.value = value;

            // creates connection between current node and next node
            this.next = next;
        }

    }

    // Constructors

    /*
    default constructor- same name as the class and no parameters
    creates empty list
    */
    public SinglyLinkedList(){

        // initially size is 0 because linked list contains no nodes
        size = 0;

        // head and tail are automatically null for empty linked list
    }

    //construct linked list from array- insert elements at the end
    public SinglyLinkedList(int[] array){

        // loop through each element of array
        for(int value:array){

            // inserting at back preserves order of array elements in linked list
            insertBack(value);
        }
    }


    // Get LinkedList size
    public int getSize(){

        // returns total number of nodes currently present in linked list
        return this.size;
    }

       /* 
        Insert element at the front of the list- O(1)
        Edge case- for empty list- head and tail point to new node 
    */ 
    public void insertFront(int value){

        // create new node containing given value
        Node node = new Node(value);

        if(head == null){  // empty list

            // for empty linked list, new node becomes first node
            head = node;

            // since there is only one node, tail also points to same node
            tail = node;

            // increase size because one new node is added
            size++;
            return;
        }

        //link new node to current node and update head

        // new node points to current head so that existing linked structure is preserved
        node.next = head;

        // updating head makes new node the first element of linked list
        head = node;

        // size increases after successful insertion
        size++;
    }

        // Insert at the end of the linked list
    public void insertBack(int value){

        // create new node containing given value
        Node node = new Node(value);

        if(head == null){ //empty list (edge case)

            // if linked list is empty, insertion at back is same as insertion at front
            insertFront(value);
            return;
        }

        // current tail connects to newly created node
        // this preserves sequence of linked list
        tail.next = node;

        // size increases because new node is added
        size++;

        // move tail forward because new node becomes last node now
        tail = tail.next;

    }

       /*
        Insert at Nth (given) Index
        Edge Cases:
            index = 0 → insertFront
            index = size → insertBack
            invalid index → exception
    */ 
    public void insertAtIndex(int value, int index){

        // invalid indexes are not allowed because insertion outside linked list range is impossible
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // inserting at index 0 means inserting at front
        if(index == 0){
            insertFront(value);
            return;
        }

        // inserting at size means inserting at end of linked list
        if(index == size){
            insertBack(value);
            return;
        }

        // temporary node used for traversal
        // linked lists require sequential traversal because direct indexing is not possible
        Node temp = head;

        //traverse to the node before the Nth index -> update pointers-> insert
        for(int i = 0; i < index-1; i++){

            // move step-by-step toward required insertion position
            temp = temp.next;
        }

        // create new node containing given value
        Node node = new Node(value);

        // new node first connects to next node
        // this prevents losing remaining linked structure
        node.next = temp.next;

        // previous node now points to inserted node
        // insertion becomes complete after pointer update
        temp.next = node;

        // increase size because one new node is added
        size++;

    }
    /*
        Searching for given value in the list.
        Value found-> return index. Else -1
        Time complexity-> O(n)- loop runs from 0 to size_linkedlist (n times)
    */
    public int find(int value){

        // temporary node used to traverse linked list sequentially
        Node temp = head;

        // linked lists do not support direct indexing like arrays
        // so traversal must happen node-by-node from head
        for(int index = 0; index < this.size; index++){

            // if current node value matches required value,
            // return index where element is found
            if(temp.value==value){
                return index;
            }

            // move to next connected node during traversal
            temp = temp.next;
        }

        // value not found in linked list
        return -1;
    }

    // Get the node at given index
    private Node getNodeAtIndex(int index){

        // invalid indexes are outside linked list boundaries
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // index 0 directly refers to head node
        // no traversal required in this case
        if (index == 0){ //head at the start of the linked list
            return head;
        }

        // temporary node used for sequential traversal
        Node temp = head;

        //traverse to required index
        for(int i = 0; i < index; i++){

            // move node-by-node because linked lists do not support random access
            temp = temp.next;
        }

        // return node present at required index
        return temp;
    }

    // return value at the given index
    public int getByIndex(int index){

        // getNodeAtIndex() returns complete node
        // ".value" extracts only the data part from that node
        return this.getNodeAtIndex(index).value;
    }


    // Delete first element- O(1)
    public void deleteFront(){

        // deletion is not possible in empty linked list
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        // move head to next node
        // previous first node automatically loses connection with linked list
        head = head.next;

        // decrease size because one node is removed
        size--;

        //check if the list was a single element list
        if(head == null){

            // if head becomes null after deletion,
            // linked list is empty so tail must also become null
            tail = null;
        }
    }
    // Delete Last element/node- O(1)
    public void deleteBack(){

        // deletion cannot happen if linked list is empty
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        // if only one node exists,
        // deleting back is same as deleting front
        if(head == tail){ //single element linked list
            deleteFront();
            return;
        }

        // temporary node used for traversal
        Node temp = head;

        //traverse to second last node
        while(temp.next != tail){

            // move node-by-node until node before tail is reached
            temp = temp.next;
        }

        // removing connection to tail deletes last node from linked list
        temp.next = null;

        // second last node becomes new tail
        tail = temp;

        // decrease size because one node is removed
        size--;
    }

    /* 
        Delete at Nth (given) Index
        Time Complexity- O(n)- loop till n to find index

        Edge Cases:
            index = 0 -> deleteFront
            last index -> update tail
    */ 
    public void deleteAtIndex(int index){

        // invalid indexes are outside linked list boundaries
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        // deleting first node requires updating head
        if(index == 0){

            // move head to next node
            // old first node loses connection with linked list
            head = head.next;

            // decrease size because one node is removed
            size--;

            // if head becomes null after deletion,
            // linked list becomes empty
            if(head == null){

                // tail must also become null for empty linked list
                tail = null;
            }

            return;
        }

        // get node before target index
        // previous node is needed to reconnect links after deletion
        Node prevNode = getNodeAtIndex(index-1);

        // if deleting last node,
        // update tail to previous node
        if(index == size - 1){
            tail = prevNode;
        }

        //remove node by skipping it

        // previous node directly connects to node after target node
        // target node loses connection and gets removed from linked structure
        prevNode.next = prevNode.next.next;

        // decrease size because one node is deleted
        size--;
    }

    // Print Elements of Linklist- O(n)
    public void display(){

        // display operation cannot happen for empty linked list
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        // temporary node used for traversal from head
        Node temp = head;

        // traversal continues until null is reached
        // null indicates end of linked list
        while(temp != null){

            // print current node value followed by arrow representation
            System.out.print(temp.value + " -> ");

            // move to next connected node
            temp = temp.next;
        }

        // END represents termination of linked list
        System.out.println("END");
    }



    // head tail difference- O(1)
    public int headTailDifference(){

        // operation cannot be performed on empty linked list
        if(head == null){ //empty linked list
            return -1;
        }

        // compare values manually to calculate absolute difference
        // subtraction order matters because result should not become negative
        if(head.value > tail.value){

            // head value is greater, so subtract tail from head
            return  head.value - tail.value;

        } else {

            // tail value is greater (or equal), so subtract head from tail
            return tail.value - head.value;
        }
    }

}