package dsa.linkedlist;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        System.out.println("Doubly Linked List");

        DoublyLinkedList doublyLinkList = new DoublyLinkedList();
        doublyLinkList.display();

//        doublyLinkList.insertFront(10);
        doublyLinkList.insertBack(50);
        doublyLinkList.insertBack(100);
        System.out.println(doublyLinkList.isEmpty());
//        System.out.println(doublyLinkList.getHead());
        System.out.println("Head is: "+ doublyLinkList.getHead());
        System.out.println("Tail is: "+ doublyLinkList.getTail());
        doublyLinkList.display();
        System.out.println("Size: " + doublyLinkList.getSize());
    }
}
