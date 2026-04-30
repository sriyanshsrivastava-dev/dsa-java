package dsa.linkedlist;

import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DoublyLinkedListTest {
    // unit test goes here

    @Test
    void testEmptyDoublyLinkedList() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertEquals(true, list.isEmpty());
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
}
