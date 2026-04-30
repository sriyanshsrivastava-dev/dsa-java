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
