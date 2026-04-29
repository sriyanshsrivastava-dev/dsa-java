package dsa.linkedlist;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SinglyLinkedListTest {

    @Test
    void testInsertfront(){

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);

        assertEquals(3, list.getSize());
        assertEquals(3, list.getByIndex(0));
        assertEquals(2, list.getByIndex(1));

    }

    @Test
    void testInsertBack(){

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(1);
        list.insertBack(25);
        list.insertBack(19);

        assertEquals(3, list.getSize());
        assertEquals(1, list.getByIndex(0));
        assertEquals(19, list.getByIndex(2));

    }

    @Test
    void testInsertAtIndex(){

        int[] array = {1,2,3,4,5};

        SinglyLinkedList list = new SinglyLinkedList(array);

        list.insertAtIndex(10,1);
        list.insertAtIndex(0,0);
        list.display();

        assertEquals(10, list.getByIndex(2));
        assertEquals(0, list.getByIndex(0));

    }

    @Test
    void testInsertInvalidIndex(){

        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.insertAtIndex(1, 2)
                );

    }

    @Test
    void testDeleteFront() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);
        list.insertBack(20);

        list.deleteFront();

        assertEquals(1, list.getSize());
        assertEquals(20, list.getByIndex(0));
    }

    @Test
    void testDeleteBack() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);
        list.insertBack(20);

        list.deleteBack();

        assertEquals(1, list.getSize());
        assertEquals(10, list.getByIndex(0));
    }

    @Test
    void testDeleteAtIndex() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);
        list.insertBack(20);
        list.insertBack(30);

        list.deleteAtIndex(1);

        assertEquals(2, list.getSize());
        assertEquals(30, list.getByIndex(1));
    }


    @Test
    void testDeleteAtInvalidIndex(){
        SinglyLinkedList list = new SinglyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAtIndex(2));
    }

    @Test
    void testFind() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);
        list.insertBack(20);

        assertEquals(1, list.find(20));
        assertEquals(-1, list.find(100));
    }

    @Test
    void testGetByIndex() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);

        assertEquals(10, list.getByIndex(0));
    }

    @Test
    void testSingleElementDelete() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);
        list.deleteFront();

        assertEquals(0, list.getSize());
    }

    @Test
    void testHeadTailAfterDelete() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);
        list.deleteFront();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getByIndex(0);
        });
    }

    @Test
    void testHeadTailDifference(){

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertBack(10);
        list.insertBack(20);
        list.insertBack(30);

        assertEquals(20, list.headTailDifference());
        assertEquals(list.getByIndex(1), list.headTailDifference());
    }
}
