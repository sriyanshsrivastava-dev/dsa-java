package dsa.linkedlist;

import java.util.NoSuchElementException;



public class DoublyLinkedList {

    // class variables
    private Node head;
    private Node tail;
    private int size;

    // Private class Node
    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
            this.next = null;
            this.prev = null;

        }

        public Node(int value, Node nextNode, Node prevNode){
            this.value = value;
            this.next = nextNode;
            this.prev = prevNode;
        }
    }

    // constructors

    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    // accessor
    public boolean isEmpty(){
        if (head == null && tail == null){
            return true;
        }
        return false;
    }

    public int getHead(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Linked list is empty, Head is null.");
        }
        return this.head.value;
    }

    public int getTail(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Linked list is empty, Tail is null.");
        }
        return this.tail.value;
    }

    // operations

    // get size
    public int getSize(){
        return this.size;
    }

    // Insert at Front
    public void insertFront(int value){

        Node node = new Node(value);

        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
        size++;
    }

    // Insert at Back
    public void insertBack(int value){

        if(head == null && tail == null){
            this.insertFront(value);
            return;
        }

        Node node = new Node(value);

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    private Node getNodeAt(int index){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + "index: " + index + ", size: " + size );
        }

        Node current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    // Insert at any Index
    public void insertAtIndex(int value, int index){

        if(index == 0){
            insertFront(value);
            return;
        }

        if (index == size){
            insertBack(value);
            return;
        }

        Node nextNode = getNodeAt(index);
        Node prevNode = nextNode.prev;

        Node newNode = new Node(value);

        prevNode.next = newNode;
        newNode.prev = prevNode;

        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;
    }


    // get value at index
    public int getAtIndex(int index){
        return getNodeAt(index).value;
    }

    // contains value
    public boolean contains(int value){
        while (head != null){
            if (head.value == value){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // find value
    public int find(int value){

        Node current = head;

        for(int i = 0; i < size; i++){
            if (current.value == value){
                return i;
            }
            current = current.next;
        }
        return -1;
    }



    // display the linklist
    public void display(){

        if(head == null){
            System.out.println("Empty List");
            return;
        }

        Node tempNode = head;

        while(tempNode != null){
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.next;
        }
        System.out.println("END");
    }

}
