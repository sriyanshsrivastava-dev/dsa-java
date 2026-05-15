/*
 * Note: The comments below assume the reader has already reviewed CustomStack.java. It is recommended to read over CustomStack.java first before reading this code.
 */

package dsa.stack;

public class CustomStackMain {
    public static void main(String[] args) {
    	//For the sake of this example, we will have 2 stacks: evenStack and oddStack
    	//evenStack will hold all even numbers from 1-20 including 0
    	//oddStack will hold all odd numbers from 1-20

    	//Create each stack
    	CustomStack evenStack = new CustomStack();
    	CustomStack oddStack = new CustomStack();

    	//Show that both Stacks are empty
    	System.out.println(evenStack.peek());
    	System.out.println(oddStack.peek());

    	//Create a loop from 0 inclusive to 20 inclusive that adds each number to its corresponding stack
    	for (Integer i = 0; i <= 20; i++) {
    	
    		//If even, put in evenStack. Else if odd, put in oddStack.
    		if (i % 2 == 0) {
    			System.out.println("Pushed " + i + " into evenStack.");
    			evenStack.push(i);
    		}
    		else { 
    			System.out.println("Pushed " + i + " into oddStack.");
    			oddStack.push(i);
    		}
    	}
    	
    	System.out.println("**********************************************************************");
    	System.out.println("No more values to push. Check for top values, then begin popping.");
    	System.out.println("**********************************************************************");

    	//Make sure our evenStack's top value is 20 while oddStack's top value is 19
    	System.out.println("evenStack's Top: " + evenStack.peek());
    	System.out.println("oddStack's Top: " + oddStack.peek());

    		
    	//Count down all the even numbers from evenStack
    	while (!evenStack.isEmpty()) {
    		System.out.println("Popped " + evenStack.pop() + " from evenStack.");
    	}
    	
    	System.out.println(evenStack.peek());
    	
    	System.out.println("**********************************************************************");
    	System.out.println("No more values from evenStack. Let's try popping from oddStack.");
    	System.out.println("**********************************************************************");

    	//Then count down all the odd numbers from oddStack
    	while(!oddStack.isEmpty()) {
    		System.out.println("Popped " + oddStack.pop() + " from oddStack.");
    	}
    	
    	//Now that our Stacks are empty, demonstrate one more time that we removed everything.
    	System.out.println(oddStack.peek());

    	System.out.println("**********************************************************************");
    	System.out.println("Great job, you just reached the end of the Stack lesson!");
    	System.out.println("**********************************************************************");
    }
}
