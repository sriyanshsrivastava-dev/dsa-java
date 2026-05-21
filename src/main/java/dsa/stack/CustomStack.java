/*
	Inspired by akshy-yy's documentation on Linked Lists.

	STACK

	What is a Stack?
	- A Stack is a linear data structure that follows a special rule: all elements must be added or removed from one end of the structure called the "top".
	- This ordering rule is referred to as "LIFO" or "Last-In, First-Out". 
	- A good way to remember it: inserted elements are the "Last" to go "In" the Stack, but a deleted element is the "First" to go "Out" of the Stack.

	How do we implement Stacks?
	- Stacks can be implemented using either an array or a Linked List. In this lesson, we will use a Linked List.

	A Real World Analogy
	- Imagine we had a stack of very fragile plates.
	- To add 1 more plate, our safest way would be to carefully position that new plate on the top of our plate stack.
	- Now imagine it's dinnertime and we'd like to set those plates onto our table from the big plate stack. 
	- The safest way would be to remove 1 plate at a time from the top of our stack.
	- Just like the "LIFO" rule, our last plate placed on the stack will always be the first plate removed.

	Key Terms & Operations
	These terms are used consistently when working with Stacks. Our Stack class will use these 3 operations.
	- Push: Add a new element to the top of the Stack. This represents the "Last-In" part of our LIFO order.
	- Pop: Remove and deallocate the top element from the Stack. This is the "First-Out" part of our LIFO order.
	- Peek (sometimes called Top): Return the top element from the Stack without pushing or popping anything new.

 	**FAQs**
 	Why use Linked Lists for Stacks?
	- Elements are stored noncontiguously. They do not have to be positioned next to each other in memory.
	- Linked Lists allocate memory dynamically. This allows our Stack to grow or shrink at runtime unlike arrays.
	
	Why use Stacks if Linked Lists can do the same thing?
	- Simplicity: We have only 1 element that handles insertion and removal. This is easier to keep track of than a Linked List.
	- Speed: If a Stack is implemented properly, it will have guaranteed O(1) insertion, removal, and peek operations.
	- Recursion: In Java, functions are organized by LIFO order through a "call stack" including functions called recursively. Recursion can be replicated using iterative loops by simulating each "call" using Stack elements.
	- Searching: Many search algorithms like Depth-First Search use Stacks when its LIFO rule comes in handy.

	Do we use a Singly or Doubly Linked List?
	- Singly Linked Lists are sufficient. We only need to keep track of the top element which can be represented by the list's head.
	- Doubly Linked Lists add additional memory overhead and do not contribute much to the standard Stack operations.
	
	Why did you not import SinglyLinkedList?
	- Had we imported SinglyLinkedList, all work would be done through member function calls. This would have defeated the purpose of implementing a Stack from scratch.
	- I also wanted to make this lesson more hands-on. Learning what to implement offers a deeper look at what data and functions we truly need for a data structure.

*/

package dsa.stack;

//To be consistent with SinglyLinkedList, this Stack will only hold integers. However, other data types could have been used instead.
public class CustomStack {
	//The top of our Stack. This member represents the "end" of the Stack where all push, pop, and peek operations are applied.
	private Node top;

	//Like a LinkedList, it's good to keep track of our total Nodes available.
	private int size;


	//Our first function is peek. Notice we do not return the Node itself, but rather the value stored in the Node.
	//As a failsafe, we return null when the Stack is empty so the program can continue operating. Some programmers prefer to throw an Exception instead of returning null.
	public Integer peek() {
		if (isEmpty()) {
			System.out.println("This Stack is empty. null will be returned as a failsafe for this program.");
			return null;
		}

		//If it is not empty, return the value in our Stack's top.
		else {
			return top.value;
		}
	}
	
	//This is a helper function I created to make reading the other functions easier.
	//We must test if the Stack is empty before we can peek or pop. This is so we can avoid accessing null values.
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}

		else {
			return false;
		}
	}
	
	//Implement Node as a Nested Inner Class just like SinglyLinkedList
	private class Node {
		//Stores 1 Node's value
		//We will use Java's Integer class instead of int, this will allow our peek and pop functions to return null when the Stack is empty.
		private Integer value;

		//Stores 1 Node's reference to the next Node in our Stack
		//If next is assigned the value null, this means we have reached the end of our Stack. No more values exist beyond this Node.
		private Node next;

		//This is a Non-Default Constructor. In this Constructor, we use "this.value" to signify our parameter will be stored into the Node's "value" member
		//By default, our "next" Node will point to null to signify it is not referencing anything just yet.
		public Node (Integer passedValue) {
			this.value = passedValue;
			this.next = null;
		}

		//A second Non-Default Constructor. Here, we assign the value and next Node inside a Node's corresponding members.
		public Node (Integer passedValue, Node nextNode) {
			this.value = passedValue;
			this.next = nextNode;
		}

	}
	
	//This is our Default Constructor. Here we will assume our Stack is empty, so we make top set to null. No values were inserted yet.
	//We also set our size to 0 to signify no Nodes are added yet.
	public CustomStack() {
		top = null;
		size = 0;
	}

		
	//Our Non-Default Constructor. Here, we assign each value from our passed array into our Stack in the array's original order.
	//The logic to this is very identical to the Non-Default Constructor found in SinglyLinkedList except we call "push" instead of "insertBack"
	public CustomStack(Integer[] passedArray) {
		for (Integer value: passedArray) {
			push(value);
		}

		//At the end of this Constructor, the final value in passedArray will be in our Stack's top.
	}

		
	//This helper function allows us to check our Stack's size
	public int getSize() {
		return size;
	}
	
	//Because we only have one entry point and exit point, we only need one insertion function: push
	public void push (Integer passedValue) {
		//Assign the passed value into a newly allocated Node
		Node node = new Node (passedValue);
			
		//If the Stack is empty, immediately assign that Node as the top. Increment the size because a new Node was added, then return early.
		if (top == null) {
			top = node;
			size++;
			return;
		}

		//This should only happen if the Stack is not empty. Because we are about to set a new top element, our new Node's next value should always point towards our current top.
		//By the end of our push, we should have our top hold the new Node's address. 
		//Our old top element, which we just set to node.next, should still be accessible using top.next 
		node.next = top;

		//Be sure that "top" refers to the correct Node. Move the top "upward" because our new Node becomes our new top now
		top = node;

		//Now that we connected Nodes, increment the size.
		size++;
		return;
	}
	
	//Because we only have one entry point and exit point, we only need one removal function: pop
	//Although this is not mandatory, we can allow our pop function to return the value we just popped out of the stack. Some programmers prefer to not return anything at all.
	//As you can tell, I prefer returning it. It makes debugging easier. For empty Stacks, we return null much like we did for peek()
	public Integer pop () {
		//Our deletion cannot happen if our Stack is empty
		if (isEmpty()) {
			System.out.println("The Stack is empty. When the Stack is empty, this is called Stack Underflow. We cannot pop any more values.");
			return null;
		}

		//The steps below should only happen if our Stack is not empty

		//Create a copy of our top value. This will be the value that we pop and return at the end of the function.
		int poppedValue = top.value;

		//The previous first node automatically loses connection to the Stack.
		//When a Node loses connection, Java uses a special "Garbage Collector" to delete disconnected Nodes from memory. Memory that used to be occupied by Nodes can be reused for later.
		top = top.next;

		//Now that we disconnected Nodes, decrement the size.
		size--;
		return poppedValue;
	}
}
