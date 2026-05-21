# Stack Data Structure

> A complete beginner-friendly guide to understanding Stack in Data Structures and Algorithms.

<br>

## Table of Contents

- Introduction
- What is a Stack?
- LIFO Principle
- Real-Life Examples
- Stack Terminology
- Core Operations
- Stack Visualization
- Internal Working
- Stack Implementations
    - Array Based Stack
    - Linked List Based Stack
- Time Complexity
- Space Complexity
- Overflow and Underflow
- Advantages
- Disadvantages
- Applications of Stack
- Stack vs Queue
- Dry Run Example
- Interview Notes
- Summary

---

# Introduction

Stack is one of the most fundamental and widely used data structures in computer science.

It is simple in design but extremely powerful in practical applications.

Stacks are used internally in:
- programming languages
- operating systems
- web browsers
- compilers
- recursion handling
- expression evaluation
- undo/redo systems

Understanding stack properly is important because many advanced algorithms and systems rely on it internally.



## What is a Stack?

A **Stack** is a linear data structure that stores elements in a specific order.

The order followed by stack is:

## LIFO — Last In First Out

This means:
- the element inserted last will be removed first.

Insertion and deletion both happen only from one side of the structure called:

## TOP

You can imagine stack like a vertical pile of objects.

The newest object always stays on top.


# LIFO Principle

The most important property of stack is:

> Last In First Out

Let us understand this with an example.

Suppose we insert:

```text
push(10)
push(20)
push(30)
```

The stack becomes:

```text
TOP → 30
        20
        10
```

Now if we remove one element:

```text
pop()
```

Removed element:

```text
30
```

Why?

Because `30` was inserted last.

---

# Real-Life Examples

## Stack of Plates

A stack of plates behaves exactly like stack data structure.

- New plate is placed on top
- Top plate is removed first

```text
TOP → Plate 3
        Plate 2
        Plate 1
```



## Browser Back Button

When you visit websites:

```text
Google → YouTube → GitHub
```

Pressing the back button returns:
1. GitHub
2. YouTube
3. Google

Latest page visited is returned first.



## Undo Operation

Text editors use stacks for:
- undo
- redo

Latest action is reversed first.



## Function Calls

Programming languages internally use stacks for function execution.

Example:

```text
main()
   └── login()
          └── validate()
```

`validate()` completes first because it was called last.

---

# Stack Terminology

### TOP

The topmost position of stack.

All insertions and deletions happen from TOP.



### PUSH

Insertion operation in stack.



### POP

Deletion operation in stack.



### PEEK / TOP

Returns top element without removing it.



### OVERFLOW

Occurs when insertion is attempted in a full stack.



### UNDERFLOW

Occurs when deletion is attempted from an empty stack.

---

# Core Operations

## 1. push()

Adds a new element at the top.

### Example

```text
push(10)
push(20)
```

Stack:

```text
TOP → 20
        10
```



## 2. pop()

Removes the top element.

### Before

```text
TOP → 30
        20
        10
```

### After pop()

```text
Removed = 30

TOP → 20
        10
```



## 3. peek()

Returns top element without removing it.

### Example

```text
peek() → 20
```

Stack remains unchanged.



## 4. isEmpty()

Checks whether stack contains elements.

### Returns

```text
true  → stack is empty
false → stack contains elements
```



## 5. size()

Returns total number of elements present in stack.

---

# Stack Visualization

Suppose we insert:

```text
10, 20, 30, 40
```

Visualization:

```text
            TOP
             ↓

          +------+
          |  40  |
          +------+
          |  30  |
          +------+
          |  20  |
          +------+
          |  10  |
          +------+
```

Now removing one element:

```text
pop()
```

Updated stack:

```text
            TOP
             ↓

          +------+
          |  30  |
          +------+
          |  20  |
          +------+
          |  10  |
          +------+
```

---

# Internal Working of Stack

Stack operations happen only at one end.

This makes operations extremely fast.

No traversal is required.



## Push Operation Internally

### Steps

1. Move TOP forward
2. Insert new element

Example:

```text
top++
stack[top] = value
```



## Pop Operation Internally

### Steps

1. Read top element
2. Remove it
3. Move TOP backward

Example:

```text
value = stack[top]
top--
```

---

# Stack Implementations

Stack is mainly implemented using:

1. Array
2. Linked List

Both implementations provide similar functionality but differ internally.



## Array Based Stack

In this implementation:
- elements are stored inside an array
- a variable called `top` tracks current top position



### Structure

```java
int[] stack;
int top;
```



### Initialization

```java
top = -1;
```

Why `-1`?

Because initially no element exists in stack.



### Push Logic

```java
top++;
stack[top] = value;
```



### Pop Logic

```java
int value = stack[top];
top--;
```



### Advantages of Array Stack

- Simple implementation
- Fast access
- Better cache performance
- Easy to understand



### Disadvantages of Array Stack

- Fixed size
- Overflow problem possible
- Resizing may be required



## Linked List Based Stack

In linked list implementation:
- stack elements are stored as nodes
- insertion/deletion happens at head

This avoids fixed-size limitation.



### Node Structure

```java
class Node {
    int value;
    Node next;
}
```



### Push Logic

```java
newNode.next = head;
head = newNode;
```



### Pop Logic

```java
head = head.next;
```



### Advantages of Linked List Stack

- Dynamic size
- No fixed capacity
- Efficient insertion/deletion



### Disadvantages of Linked List Stack

- Extra memory for pointers
- Slightly slower than arrays
- More complex implementation

---

# Time Complexity Analysis

| Operation | Complexity |
|-----------|-------------|
| push() | O(1) |
| pop() | O(1) |
| peek() | O(1) |
| isEmpty() | O(1) |
| size() | O(1) |



### Why are operations O(1)?

Because all operations happen only at TOP.

No traversal is needed.

---

# Space Complexity

| Implementation | Complexity |
|---------------|-------------|
| Array Stack | O(n) |
| Linked List Stack | O(n) |

Where:
- `n` = number of elements

---

# Stack Overflow

Overflow occurs when:
- stack becomes full
- another insertion is attempted

Example:

Suppose stack capacity is 3.

```text
TOP → 30
        20
        10
```

Now:

```text
push(40)
```

This causes:
#### Stack Overflow

---

# Stack Underflow

Underflow occurs when deletion is attempted on an empty stack.

Example:

```text
pop()
```

on empty stack causes:

#### Stack Overflow

---

# Advantages of Stack
### Simple Structure

Easy to implement and understand.


### Fast Operations

Push and pop work in constant time.


### Useful in Recursion

Programming languages use stack internally for recursive calls.


### Supports Backtracking

Used in:
- DFS traversal
- maze solving
- Sudoku
- undo systems

### Memory Management

Function calls are managed using stack memory.

---

# Disadvantages of Stack

### Limited Access

Only top element can be accessed directly.



### Overflow Problem

Occurs in fixed-size array implementation.



### Searching is Inefficient

Random access is not supported.

--- 


# Applications of Stack

Stack is used extensively in computer science.


### Function Call Management

Every function call is stored in stack memory.

Example:

```text
main()
   └── A()
         └── B()
```

Execution returns:
1. B
2. A
3. main



### Expression Evaluation

Used in:
- postfix evaluation
- prefix evaluation
- infix conversion



### Parenthesis Matching

Used for checking balanced expressions:

```text
()
{}
[]
```


### Depth First Search (DFS)

DFS internally uses stack.


### Undo / Redo Systems

Editors maintain history using stacks.


### Browser Navigation

Back button functionality uses stack.


### Backtracking Algorithms

Used in:
- maze solving
- Sudoku
- N-Queens problem

---

# Stack vs Queue

| Feature | Stack | Queue |
|---------|--------|--------|
| Principle | LIFO | FIFO |
| Insertion | Same End | Rear |
| Deletion | Same End | Front |
| Main Pointer | Top | Front / Rear |

---

# Dry Run Example

Operations:

```text
push(10)
push(20)
push(30)
pop()
peek()
```



### Step 1

```text
push(10)
```

Stack:

```text
TOP → 10
```



### Step 2

```text
push(20)
```

Stack:

```text
TOP → 20
        10
```



### Step 3

```text
push(30)
```

Stack:

```text
TOP → 30
        20
        10
```


### Step 4

```text
pop()
```

Removed:

```text
30
```

Stack becomes:

```text
TOP → 20
        10
```


### Step 5

```text
peek()
```

Returns:

```text
20
```

Stack remains unchanged.

---

# Interview Notes

## Important Points to Remember

### Stack follows:

```text
LIFO
```



### Major operations:

- push()
- pop()
- peek()



### Time complexity of major operations:

```text
O(1)
```



### Stack can be implemented using:

- Array
- Linked List



### Common interview topics:

- balanced parentheses
- expression conversion
- recursion
- DFS traversal
- monotonic stack problems
---


# Summary

Stack is one of the most important data structures in programming.

It follows:

# Last In First Out (LIFO)

The most recently inserted element is removed first.



## Main Features

- insertion and deletion happen only at TOP
- operations are extremely fast
- simple but highly powerful
- widely used in real-world systems



## Core Operations

| Operation | Purpose |
|-----------|----------|
| push() | Insert element |
| pop() | Remove top element |
| peek() | View top element |
| isEmpty() | Check emptiness |
| size() | Count elements |



## Most Important Concept

```text
LAST IN
FIRST OUT
```



Understanding stack properly helps in mastering:
- recursion
- DFS
- compiler design
- expression parsing
- memory management
- advanced algorithms

Stack forms the foundation for many important computer science concepts and problem-solving techniques.