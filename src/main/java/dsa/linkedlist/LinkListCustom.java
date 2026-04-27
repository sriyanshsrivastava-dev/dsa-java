package dsa.linkedlist;

public class LinkListCustom {

    // Variables and internal Classes

    private Node head;
    private Node tail;  // we track tail to make linklist of O(1).
    private int size;


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

    public LinkListCustom(){
        size = 0;
    }

    
    // Get LinkedList size
    public int getSize(){
        return this.size;
    }


    // Insert Front
    public void addFront(int value){

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
    // Insert at Nth position
    // Delete Front
    // Delete Last
    // Delete Nth position
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

}
