package dsa.linkedlist;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        System.out.println("Doubly Linked List");

        DoublyLinkedList doublyLinkList = new DoublyLinkedList();
        doublyLinkList.display();

        doublyLinkList.insertFront(10);
        doublyLinkList.insertBack(50);
        doublyLinkList.insertBack(100);
        doublyLinkList.insertBack(200);
        doublyLinkList.insertBack(500);
        System.out.println(doublyLinkList.isEmpty());
//        System.out.println(doublyLinkList.getHead());
        System.out.println("Head is: "+ doublyLinkList.getHead());
        System.out.println("Tail is: "+ doublyLinkList.getTail());
        doublyLinkList.display();
        System.out.println("Size: " + doublyLinkList.getSize());
        doublyLinkList.insertAtIndex(5,0);
        doublyLinkList.insertAtIndex(400,4);
        doublyLinkList.insertAtIndex(700,7);
//        doublyLinkList.insertAtIndex(700,55);
        doublyLinkList.display();
        System.out.println("Size: " + doublyLinkList.getSize());

        DoublyLinkedList dll = new DoublyLinkedList();
        try{
            dll.insertAtIndex(10,3);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
//        dll.insertAtIndex(10,3);
        dll.display();
    }
}
