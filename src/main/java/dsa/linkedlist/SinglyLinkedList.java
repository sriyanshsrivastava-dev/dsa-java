package dsa.linkedlist;

public class SinglyLinkedList {

    // Variables and internal Classes

    private Node head;
    private Node tail;  // we track tail to make linklist of O(1).
    private int size;

    // head and tail accessor

    public int getHead(){
        return head.value;
    }

    public int getTail(){
        return tail.value;
    }


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

    public SinglyLinkedList(){
        size = 0;
    }


    public SinglyLinkedList(int[] array){
        for(int value:array){
            insertBack(value);
        }
    }


    // Get LinkedList size
    public int getSize(){
        return this.size;
    }


    // Insert Front
    public void insertFront(int value){

        Node node = new Node(value);

        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }

        node.next = head;
        head = node;
        size++;
    }


    // Insert Last
    public void insertBack(int value){
        Node node = new Node(value);

        if(head == null){
            insertFront(value);
            return;
        }

        tail.next = node;
        size++;
        tail = tail.next;

    }


    // Insert at Nth Index
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

        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }

        Node node = new Node(value);

        node.next = temp.next;
        temp.next = node;
        size++;

    }


    // Find
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


    // GetNodeAtIndex
    private Node getNodeAtIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0){
            return head;
        }

        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp;
    }


    // getByIndex
    public int getByIndex(int index){
        return this.getNodeAtIndex(index).value;
    }

    // Delete Front
    public void deleteFront(){
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        head = head.next;
        size--;

        if(head == null){
            tail = null;
        }
    }


    // Delete Last
    public void deleteBack(){

        if(head == null){
            System.out.println("Empty List");
            return;
        }

        if(head == tail){
            deleteFront();
            return;
        }

        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
        size--;
    }


    // Delete at Nth Index
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
        prevNode.next = prevNode.next.next;
        size--;
    }


    // Print Linklist
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


    // head tail difference
    public int headTailDifference(){

        if(head == null){
            return -1;
        }

        if(head.value > tail.value){
            return  head.value - tail.value;
        } else {
            return tail.value - head.value;
        }
    }

}
