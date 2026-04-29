package dsa.linkedlist;

public class SinglyLinkedListMain {
    public static void main(String[] args) {

//  Creating SinglyLinklist object

        SinglyLinkedList list = new SinglyLinkedList();

        // inserting at Front
        list.insertFront(20);

        // inserting at Back
        list.insertBack(50);

        // inserting at Index 1,2
        list.insertAtIndex(40,1);
        list.insertAtIndex(80,2);

        try{
            list.insertAtIndex(100,10); // might give error because list is of size 4 and 0 based indexing.
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bounds: "+ e.getMessage());
        }

        // Displaying List
        list.display();


        // getting size of linkedlist
        int size = list.getSize();
        System.out.println("Size: " + size);
        System.out.println(); // for gap in line while printing the list.

        // finding any value -> returns index if not in index returns -1
        int indexOf50 = list.find(50);
        int indexOf100 = list.find(100); // returns -1

        System.out.println("Index of 50 in list is -> "+indexOf50);
        System.out.println("Index of 100 in list is -> "+indexOf100);

        // getting value at any index.
        System.out.println("Value at index 1 -> "+ list.getByIndex(1));
        System.out.println("Value at index 4 -> "+ list.getByIndex(3));

        try{
            list.getByIndex(4); // might give error because list is of size 4 and 0 based indexing.
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bounds: "+ e.getMessage());
        }

        // deleting value from front of list
        System.out.println("Before deleting front: ");
        list.display();
        list.deleteFront();
        System.out.println("After deleting front: ");
        list.display();

        // deleting value from back of list
        System.out.println("Before deleting back: ");
        list.display();
        list.deleteBack();
        System.out.println("After deleting back: ");
        list.display();

        // delete value at particular index

        System.out.println("Before deleting index 1: ");
        list.display();
        list.deleteAtIndex(1);
        System.out.println("After deleting index 1: ");
        list.display();

        // deleting from invalid index will give IndexOutOfBoundException make sure to use try-catch block
        try{
            list.deleteAtIndex(5);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bound please enter valid index.");
        }

        // print Difference between head value and tail value.

        int difference = list.headTailDifference();
        System.out.println("Head and tail difference: " + difference);

    }
}
