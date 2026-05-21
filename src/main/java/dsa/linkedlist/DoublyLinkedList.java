package dsa.linkedlist;

import java.util.NoSuchElementException;

/**
 * A Doubly Linked List implementation.
 *
 * A Doubly Linked List is a linear data structure where each node contains:
 *      - Data (value)
 *      - Reference to next node
 *      - Reference to previous node
 *
 *
 * Difference from Singly Linked List:
 *     Singly Linked List → only next pointer (forward traversal)
 *     Doubly Linked List → next + prev (bidirectional traversal)
 *
 *
 * Invariants:
 *     head == null ⇔ tail == null
 *     head.prev == null
 *     tail.next == null
 *     size >= 0
 *
 */
public class DoublyLinkedList {

    // Invariant: head == null ⇔ tail == null
    private Node head;
    private Node tail;
    private int size;

    /**
     * Internal node class representing each element.
     */
    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Initializes an empty Doubly Linked List.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Checks if the list is empty (i.e. if head and tail is null)
     *
     * @return true if empty, false otherwise
     *
     * Time Complexity: O(1)
     */
    public boolean isEmpty() {
        if (head == null && tail == null){
            return true;
        }
        return false;
    }

    /**
     * Returns value at head.
     *
     * @return value of head node
     * @throws NoSuchElementException if list is empty
     *
     * Time Complexity: O(1)
     */
    public int getHead(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Linked list is empty, Head is null.");
        }
        return this.head.value;
    }

    /**
     * Returns value at tail.
     *
     * @return value of tail node
     * @throws NoSuchElementException if list is empty
     *
     * Time Complexity: O(1)
     */
    public int getTail(){
        if (this.isEmpty()){
            throw new NoSuchElementException("Linked list is empty, Tail is null.");
        }
        return this.tail.value;
    }

    /**
     * Returns size of list.
     *
     * @return number of elements
     *
     * Time Complexity: O(1)
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Inserts a value at the front.
     *
     * @param value value to insert
     *
     * Time Complexity: O(1)
     *
     * Edge Cases:
     * - Empty list → head and tail both point to new node
     */
    public void insertFront(int value) {
        Node node = new Node(value);

        if(head == null){
            head = node;
            tail = node;
            size++;
            return;
        }

        // Link new node with current head
        node.next = head;
        head.prev = node;

        // Update head
        head = node;
        size++;
    }

    /**
     * Inserts a value at the end.
     *
     * @param value value to insert
     *
     * Time Complexity: O(1)
     */
    public void insertBack(int value) {
        if(head == null && tail == null){
            this.insertFront(value);
            return;
        }

        Node node = new Node(value);

        // Attach after tail
        tail.next = node;
        node.prev = tail;

        // Update tail
        tail = node;
        size++;
    }

    /**
     * Returns node at a given index.
     *
     * @param index position (0-based)
     * @return node at index
     *
     * Time Complexity: O(n) → optimized to O(n/2)
     *
     * Edge Cases:
     * - Invalid index → throws exception
     */
    private Node getNodeAt(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds: " + "index: " + index + ", size: " + size );
        }

        Node current;

        // Optimize traversal direction
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    /**
     * Inserts value at given index.
     *
     * @param value value to insert
     * @param index position (0-based)
     *
     * Time Complexity: O(n)
     *
     * Edge Cases:
     * - index == 0 → insertFront
     * - index == size → insertBack
     */
    public void insertAtIndex(int value, int index) {
        if (index == 0) {
            insertFront(value);
            return;
        }

        if (index == size) {
            insertBack(value);
            return;
        }

        Node nextNode = getNodeAt(index);
        Node prevNode = nextNode.prev;

        Node newNode = new Node(value);

        // Link prev → newNode
        prevNode.next = newNode;
        newNode.prev = prevNode;

        // Link newNode → nextNode
        newNode.next = nextNode;
        nextNode.prev = newNode;

        size++;
    }

    /**
     * Returns value at index.
     *
     * @param index position
     * @return value at index
     *
     * Time Complexity: O(n)
     */
    public int getAtIndex(int index) {
        return getNodeAt(index).value;
    }

    /**
     * Checks if value exists in list.
     *
     * @param value value to search
     * @return true if found, false otherwise
     *
     * Time Complexity: O(n)
     */
    public boolean contains(int value){
        while (head != null){
            if (head.value == value){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Finds index of value.
     *
     * @param value value to search
     * @return index if found, -1 otherwise
     *
     * Time Complexity: O(n)
     */
    public int find(int value) {
        Node current = head;

        for (int i = 0; i < size; i++) {
            if (current.value == value) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    /**
     * Deletes element from front.
     *
     * Time Complexity: O(1)
     *
     * Edge Cases:
     * - Empty list → exception
     * - Single node → list becomes empty
     */
    public void deleteFront() {
        if (isEmpty()){
            throw new NoSuchElementException("Linked list is null.");
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        // Move head forward
        head = head.next;

        // Remove backward link
        head.prev = null;

        size--;
    }

    /**
     * Deletes element from end.
     *
     * Time Complexity: O(1)
     */
    public void deleteBack() {
        if (isEmpty()){
            throw new NoSuchElementException("Linked list is null.");
        }

        if (head == tail) {
            head = tail = null;
        } else {
            // Move tail backward
            tail = tail.prev;

            // Remove forward link
            tail.next = null;
        }

        size--;
    }

    /**
     * Deletes element at given index.
     *
     * @param index position (0-based)
     *
     * Time Complexity: O(n)
     */
    public void deleteAtIndex(int index) {
        if(isEmpty()){
            throw new NoSuchElementException("Linked list is null.");
        }

        if (index == 0) {
            deleteFront();
            return;
        }

        if (index == size - 1) {
            deleteBack();
            return;
        }

        Node current = getNodeAt(index);
        Node prev = current.prev;
        Node next = current.next;

        // Bridge prev and next
        prev.next = next;
        next.prev = prev;

        size--;
    }

    /**
     * Displays list from head to tail.
     *
     * Format: value <-> value <-> END
     *
     * Time Complexity: O(n)
     */
    public void display() {
        if(head == null){
            System.out.println("Empty List");
            return;
        }

        Node tempNode = head;

        while(tempNode != null){
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.next;
        }
        System.out.println("END");
    }
}