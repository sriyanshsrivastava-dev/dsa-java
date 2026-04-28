package dsa.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
//        System.out.println("Linklist 1");
//        LinkListCustom linklist1 = new LinkListCustom();
//        linklist1.insertFront(10);
//        linklist1.insertFront(20);
//        linklist1.insertFront(50);
//        linklist1.display();
//
//        System.out.println("Linklist 2");
//        LinkListCustom linklist2 = new LinkListCustom();
//        linklist2.insertBack(25);
//        linklist2.insertBack(60);
//        linklist2.display();
//
//
//        System.out.println("Linklist 3");
        int[] list = {1,5,7,10,50,20,44,50,57};
//        LinkListCustom linklist3 = new LinkListCustom();
//
//        for(int value: list){
//            linklist3.insertBack(value);
//        }
//
//        linklist3.display();
//        System.out.println("Difference between head and tail node. " + linklist3.headTailDifference());


        System.out.println("Linklist 4");
        LinkListCustom linklist4 = new LinkListCustom(list);
//        linklist4.insert(80,9);
        linklist4.display();
//        System.out.println("Difference between head and tail node. " + linklist4.headTailDifference());
        System.out.println("Size before removal -> "+ linklist4.getSize());
//        linklist4.deleteFront();
        linklist4.deleteBack();
        linklist4.deleteBack();
        linklist4.display();
//        linklist4.insert(50,4);
        linklist4.insertAtIndex(2,3);
        linklist4.insertAtIndex(555,6);
        linklist4.display();
        System.out.println(linklist4.find(555));
        System.out.println("Value present at index 6 -> " + linklist4.getByIndex(6));
        System.out.println("Value present at index 8 -> " + linklist4.getByIndex(8));
        System.out.println("Size before removal -> "+ linklist4.getSize());

    }
}
