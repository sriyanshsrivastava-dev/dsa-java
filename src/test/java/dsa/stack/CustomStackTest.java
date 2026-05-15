package dsa.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Tested using the Mutator-Accessor Strategy.
 * 
 * Mutators: push, pop
 * Accessors: peek, isEmpty, getSize
 */

public class CustomStackTest {
	@Test
	void testPush() {
		//This Stack is empty to test for valid responses from peek, isEmpty, & getSize
		CustomStack emptyStack = new CustomStack();

		//6 will be in the top of normalStack
		Integer sampleArray[] = {1, 3, 5, 2, 4, 6};
		CustomStack normalStack = new CustomStack(sampleArray);

		//Verify emptyStack is empty & normalStack is not empty
		assertEquals(true, emptyStack.isEmpty());
		assertEquals(false, normalStack.isEmpty());
		

		//Check our sizes
		assertEquals(0, emptyStack.getSize());
		assertEquals(6, normalStack.getSize());

		//See what is at the top of our stack. Since emptyStack is empty, we should be returning null
		assertEquals(null, emptyStack.peek());
		assertEquals(6, normalStack.peek());

		
		//Now let's push another integer into both Stacks. Let's push 0.
		emptyStack.push(0);
		normalStack.push(0);

		//Verify that neither Stack is empty
		assertEquals(false, emptyStack.isEmpty());
		assertEquals(false, normalStack.isEmpty());

		//Verify that each Stack's size is its original size + 1
		assertEquals(1, emptyStack.getSize());
		assertEquals(7, normalStack.getSize());

		//Verify that each Stack returns 0 when peeking. We could've also done 1 assertEquals call by making its arguments the 2 peek calls, but I felt this was more readable.
		assertEquals(0, emptyStack.peek());
		assertEquals(0, normalStack.peek());
	}
	
	@Test
	void testPop() {
		//This time we will introduce 3 Stacks: emptyStack, normalStack, and oneValueStack
		CustomStack emptyStack = new CustomStack();

		//Set up arrays for our remaining 2 Stacks
		Integer oneValueArray[] = {1};
		Integer sampleArray[] = {1, 3, 5, 2, 4, 6};

		//Set up our remaining 2 Stacks
		CustomStack oneValueStack = new CustomStack(oneValueArray);
		CustomStack normalStack = new CustomStack(sampleArray);

		//Verify for emptiness
		assertEquals(true, emptyStack.isEmpty());
		assertEquals(false, oneValueStack.isEmpty());
		assertEquals(false, normalStack.isEmpty());

		//Check our sizes
		assertEquals(0, emptyStack.getSize());
		assertEquals(1, oneValueStack.getSize());
		assertEquals(6, normalStack.getSize());

		//Peek all 3 Stacks. Remember that null will be returned by peek if the Stack is empty
		assertEquals(null, emptyStack.peek());
		assertEquals(1, oneValueStack.peek());
		assertEquals(6, normalStack.peek());

		//Since we know what's at the top of our Stack, we can assert those same numbers when we pop them out.
		//To save a few lines, we could've used our assertEquals comparisons to run a peek then a pop & compare results. I felt the method below was easier to follow.
		assertEquals(null, emptyStack.pop());
		assertEquals(1, oneValueStack.pop());
		assertEquals(6, normalStack.pop());

		
		//Since we just popped some values out, we need to check if our changes were actually made. First we check for emptiness
		assertEquals(true, emptyStack.isEmpty());
		assertEquals(true, oneValueStack.isEmpty());
		assertEquals(false, normalStack.isEmpty());


		//Then we identify our new sizes
		assertEquals(0, emptyStack.getSize());
		assertEquals(0, oneValueStack.getSize());
		assertEquals(5, normalStack.getSize());

		//Lastly, we check for the new peeked value. Since emptyStack and oneValueStack are confirmed to have no values, they should both return null
		//normalStack meanwhile should return 4 since it was the second to last value added to the Stack
		assertEquals(null, emptyStack.peek());
		assertEquals(null, oneValueStack.peek());
		assertEquals(4, normalStack.peek());
	}
}
