package dsa.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        System.out.println("Linklist 1");
        LinkListCustom linklist1 = new LinkListCustom();
        linklist1.insertFront(10);
        linklist1.insertFront(20);
        linklist1.insertFront(50);
        linklist1.display();

        System.out.println("Linklist 2");
        LinkListCustom linklist2 = new LinkListCustom();
        linklist2.insertBack(25);
        linklist2.insertBack(60);
        linklist2.display();


        System.out.println("Linklist 3");
        int[] list = {1,5,7,10,50,20,44,50,57};
        LinkListCustom linklist3 = new LinkListCustom();

        for(int value: list){
            linklist3.insertBack(value);
        }

        linklist3.display();
        System.out.println("Difference between head and tail node. " + linklist3.headTailDifference());


        System.out.println("Linklist 4");
        LinkListCustom linklist4 = new LinkListCustom(list);
        linklist4.insert(80,9);
        linklist4.display();
        System.out.println("Difference between head and tail node. " + linklist4.headTailDifference());

    }
}
