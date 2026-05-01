package dsa.linkedlist;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;


public class DoublyLinkedListTest {
    // unit test goes here

    @Test
    void testEmptyDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    void testHeadTailPointSameOnSingleNode(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertBack(50);
        assertEquals(list.getHead(), list.getTail());
    }

    @Test
    void testAccessingHeadTailOnEmptyList(){
        DoublyLinkedList list = new DoublyLinkedList();
        assertThrows(NoSuchElementException.class, list::getHead);
        assertThrows(NoSuchElementException.class, list::getTail);

    }

    @Test
    void testInsertFront(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFront(5);
        list.insertFront(10);

        assertEquals(2, list.getSize());
        assertEquals(5, list.getTail());
        assertEquals(10, list.getHead());

    }

    @Test
    void testInsertBack(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertBack(5);
        list.insertBack(10);

        assertEquals(2, list.getSize());
        assertEquals(10, list.getTail());
        assertEquals(5, list.getHead());

    }

    @Test
    void testInsertAtIndex(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtIndex(5,0);
        list.insertBack(15);
        list.insertBack(100);
        list.insertAtIndex(25,2);

        assertEquals(4, list.getSize());
        assertEquals(5, list.getAtIndex(0));
        assertEquals(15, list.getAtIndex(1));
        assertEquals(25, list.getAtIndex(2));

        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAtIndex(5,10));
    }

    @Test
    void testContains(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFront(5);
        list.insertFront(10);
        list.insertFront(100);

        assertTrue(list.contains(100));
        assertFalse(list.contains(20));
    }

    @Test
    void testFind(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFront(5);
        list.insertFront(10);
        list.insertFront(100);

        list.display();
        System.out.println(list.getSize());

        assertEquals(2, list.find(5));
    }
}
