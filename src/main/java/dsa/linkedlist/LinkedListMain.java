package dsa.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        System.out.println("Start Linked List Data Structure and Algorithms.");
        LinkListCustom linklist = new LinkListCustom();
        LinkListCustom linklist2 = new LinkListCustom();
        linklist.addFront(10);
        linklist.addFront(20);
        linklist.addFront(50);
        System.out.println(linklist.getSize());
        linklist.display();
        linklist2.display();
    }
}
