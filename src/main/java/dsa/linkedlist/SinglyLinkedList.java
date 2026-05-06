/**
 * A Singly Linked List is a linear data structure in which each node contains:
 *  - A value (data- int, String, float)
 *  - A reference (next) to the next node in the list.
 * 
 *      We can compare a Single Linked List with a train for better understanding. 
 *      - The engine represents the head node.
 *      - Each compartment (node) is connected to the next one
 *      - The last compartment points to null (end of train)
 *
 * The list is accessed through the head node, and elements are linked sequentially.
 *
 * This implementation maintains:
 * - head: reference to the first node
 * - tail: reference to the last node (for efficient insert at end)
 * - size: number of elements in the list
 *
 * Supported operations are:
 * - Insertion (front, back, specific index)
 * - Deletion (front, back, specific index)
 * - Traversal (visiting each node) and searching
 */

package dsa.linkedlist;

public class SinglyLinkedList {

    // Variables and internal Classes

    private Node head; //first node
    private Node tail;  // helps in O(1) insertion at the end. [O(1)- (constant time complexity- best)]
    private int size;

    // accessing value at head or tail- O(1)

    public int getHead(){
        return head.value;
    }

    public int getTail(){
        return tail.value;
    }

    /**
     Node -single element in linked list
     "this.value"- 'this' keyword refers to the current object and is used to access instance variables or resolve naming conflicts
     */

    private class Node{

        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
        
    }

    // Constructors

    /*
    default constructor- same name as the class and no parameters
    creates empty list
    */
    public SinglyLinkedList(){
        size = 0;
    }

    //construct linked list from array- insert elements at the end
    public SinglyLinkedList(int[] array){
        for(int value:array){
            insertBack(value);
        }
    }


    // Get LinkedList size
    public int getSize(){
        return this.size;
    }


    /* 
        Insert element at the front of the list- O(1)
        Edge case- for empty list- head and tail point to new node 
    */ 
    public void insertFront(int value){

        Node node = new Node(value);

        if(head == null){  // empty list
            head = node;
            tail = node;
            size++;
            return;
        }

        //link new node to current node and update head
        node.next = head;
        head = node;
        size++;
    }


    // Insert at the end of the linked list
    public void insertBack(int value){
        Node node = new Node(value);

        if(head == null){ //empty list (edge case)
            insertFront(value);
            return;
        }

        tail.next = node;
        size++;
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

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if(index == 0){
            insertFront(value);
            return;
        }

        if(index == size){
            insertBack(value);
            return;
        }

        Node temp = head;

        //traverse to the node before the Nth index -> update pointers-> insert
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }

        Node node = new Node(value);

        node.next = temp.next;
        temp.next = node;
        size++;

    }


    /*
        Searching for given value in the list.
        Value found-> return index. Else -1
        Time complexity-> O(n)- loop runs from 0 to size_linkedlist (n times)
    */
    public int find(int value){
        Node temp = head;

        for(int index = 0; index < this.size; index++){
            if(temp.value==value){
                return index;
            }
            temp = temp.next;
        }
        return -1;
    }


    // Get the node at given index
    private Node getNodeAtIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0){ //head at the start of the linked list
            return head;
        }

        Node temp = head;

        //traverse to required index
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp;
    }


    // return value at the given index
    public int getByIndex(int index){
        return this.getNodeAtIndex(index).value;
    }


    // Delete first element- O(1)
    public void deleteFront(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        head = head.next;
        size--;

        //check if the list was a single element list
        if(head == null){
            tail = null;
        }
    }


    // Delete Last element/node- O(1)
    public void deleteBack(){

        if(head == null){
            System.out.println("Empty List");
            return;
        }

        if(head == tail){ //single element linked list
            deleteFront();
            return;
        }

        Node temp = head;

        //traverse to second last node
        while(temp.next != tail){
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
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

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            head = head.next;
            size--;

            if(head == null){
                tail = null;
            }

            return;
        }

        Node prevNode = getNodeAtIndex(index-1);

        if(index == size - 1){
            tail = prevNode;
        }

        //remove node by skipping it
        prevNode.next = prevNode.next.next;
        size--;
    }


    // Print Elements of Linklist- O(n)
    public void display(){

        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }


    // head tail difference- O(1)
    public int headTailDifference(){

        if(head == null){ //empty linked list
            return -1;
        }

        if(head.value > tail.value){
            return  head.value - tail.value;
        } else {
            return tail.value - head.value;
        }
    }

}
