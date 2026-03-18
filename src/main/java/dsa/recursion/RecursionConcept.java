package dsa.recursion;

// What is Recursion?

/*
* Any function which calls itself is called recursive. A recursive method solves a problem by
* calling a copy of itself to work on a smaller problem. this is called the recursion step.
* The recursion step can result in many more such recursive calls.
*/

// Why Recursion ?

/*
* Recursive code is generally shorter and easier to write than iterative code.
* Recursion is the most useful tasks that can ge defined in terms of similar subtasks.
* For example, short, search, and traversal problems often have simple recursive solutions.
*/

// Base Case & Recursive case

/*
* At some point, function encounters a subtask that it can perform without calling itself.
* This case where function does not recur, is called the base case.
*
* Where the function calls itself to perform a subtask, is referred to as the Recursive case.
*
*/

public class RecursionConcept {
    // Recursive Call Example
    // Calculate factorial of a positive integer

    public static int fact(int n){
        if(n==1){                    // Base Case
            return 1;
        }

        else if (n==0) {            // Base Case
            return 1;
        }

        else{
            return n*fact(n-1);     // Recursive Call, recursive case Fact calling itself.
        }
    }

}
