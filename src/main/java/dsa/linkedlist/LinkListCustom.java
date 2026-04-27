package dsa.linkedlist;

public class LinkListCustom {

    // Variables and internal Classes

    private int head;
    private int tail;  // we track tail to make linklist of O(1).
    private int size;


    private class Node{

        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
        
    }
    // Constructors

    public LinkListCustom(){
        head = 0;
        size = 0;
    }

    // Get LinkedList size
    public int getSize(){
        return this.size;
    }


    // Insert Front
    // Insert Last
    // Insert at Nth position
    // Delete Front
    // Delete Last
    // Delete Nth position
    // Print Linklist

}
