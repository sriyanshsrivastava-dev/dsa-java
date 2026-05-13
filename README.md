#  DSA Java — Structured Learning Repository

   **A long-term, educational Java repository for deeply understanding Data Structures, Algorithms, and Software Design Patterns built with clarity, maintainability, and continuous learning at its core.**

---

## What Is This Repository?

This repository is a structured, educational Java project dedicated to building a thorough understanding of:

- **Data Structures & Algorithms (DSA)** — From foundational concepts to advanced topics
- **Software Design Patterns** — Clean, real-world implementations in Java
- **Software Engineering Best Practices** — Testing, documentation, and maintainable code

It is not a collection of quick-solve snippets. Every implementation here is written with intention focusing on why things work, not just that they work.

**Who is this for?**

- Students beginning their DSA journey
- Developers looking to strengthen their fundamentals
- Anyone who values understanding over memorization
- Open-source contributors who care about clean, educational code

This repository is continuously evolving. New topics, refinements, and improvements are added regularly as the project grows.

---

##  Features

- **Java-First** — All implementations written in clean, standard Java 17+
- **Readable Code** — Written to be understood, not just executed
- **Maven Project Structure** — Industry-standard build and project organization
- **Unit Testing** — Every implementation is validated with tests
- **Beginner-Friendly Approach** — Concepts explained through comments and documentation
- **Design Pattern Implementations** — Real patterns, explained with real examples
- **Long-Term Maintainability** — Modular packages designed to scale cleanly
- **Open-Source Collaboration** — Contributions, improvements, and discussions are always welcome
---

##  Technologies Used

| Technology     | Purpose                          |
|----------------|----------------------------------|
| Java 17+       | Core implementation language     |
| Maven          | Build automation & dependency management |
| JUnit 5        | Unit testing framework           |
| Git & GitHub   | Version control & collaboration  |
| IntelliJ IDEA  | Recommended IDE *(optional)*     |

---

##  Project Philosophy

> *"Understanding is more valuable than solving."*

This repository is built around a simple but important belief: **Deep understanding matters more than fast solutions.**

Here's what that means in practice:

- **Internal logic over surface-level solutions** — Implementations explain how and why things work, not just what they do
- **Readability is a feature** — Code is written so that a beginner can follow the thought process, not just the output
- **Comments and documentation** — Meaningful comments are encouraged throughout, not treated as optional extras
- **Edge cases are taken seriously** — Implementations consider boundary conditions, not just the happy path
- **Testing is part of learning** — Unit tests aren't just for validation, they're a tool for building confidence in your understanding
- **Refinement over time** — Implementations may be revisited and improved as understanding deepens

This is a long-term learning project. Quality and clarity will always be prioritized over quantity.

---

##  Repository Structure

This project follows a standard **Maven directory layout**, keeping implementation code and test code cleanly separated.

```
dsa-java/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── dsa/                               # Data Structures & Algorithms
│   │       │   └── linkedlist/                    → Linked List implementations
│   │       │       ├── DoublyLinkedList.java       → Core doubly linked list logic
│   │       │       ├── DoublyLinkedListMain.java   → Demo/runner for doubly linked list
│   │       │       ├── SinglyLinkedList.java       → Core singly linked list logic
│   │       │       └── SinglyLinkedListMain.java   → Demo/runner for singly linked list
│   │       │
│   │       └── designpattern/                     # Software Design Patterns
│   │           └── builderpattern/                → Builder Pattern implementations
│   │               ├── Student.java               → Builder pattern for a Student object
│   │               ├── TestClass.java             → Manual test/demo runner
│   │               └── UserAccount.java           → Builder pattern for a UserAccount object
│   │
│   └── test/
│       └── java/
│           ├── dsa/
│           │   └── linkedlist/                    → Tests for Linked List implementations
│           │       ├── DoublyLinkedListTest.java
│           │       └── SinglyLinkedListTest.java
│           │
│           └── designpattern/
│               └── builderpattern/                → Tests for Builder Pattern implementations
│                   └── UserAccountTest.java
│
├── pom.xml                                        # Maven configuration
├── CONTRIBUTING.md                                # Contribution guidelines
├── LICENSE                                        # License information
└── README.md
```

**Why this structure?**

- `src/main/java` keeps all implementation source code organized by concept
- `src/test/java` mirrors the main package structure so every class has a corresponding test
- Modular sub-packages (`linkedlist`, `builderpattern`, etc.) make it easy to navigate and scale
- New topics can be added as new packages without disrupting existing code

---

##  Implemented Topics


### Data Structures

- **Linked List**
  - `SinglyLinkedList` — A one-way chain: each node points only to the next node 
  - `DoublyLinkedList` — A two-way chain: each node points to both the next and the previous node

### Design Patterns

- **Builder Pattern**
  - The **Builder Pattern** helps you construct complex objects step by step instead of passing ten arguments to a constructor, you build the object piece by piece, only including what you need.
  
  - `Student` —  Builder pattern for constructing a Student object — demonstrated via `TestClass.java`
  - `UserAccount` — Builder pattern for constructing a UserAccount with optional fields — covered by `UserAccountTest.java`
> More topics are being actively added. See the [Roadmap](#future-roadmap) below.

---

##  Testing

Every implementation in this repository is paired with a corresponding unit test under `src/test/java`.

Tests serve two purposes here:
1. **Validation** — Ensuring implementations behave correctly across normal and edge-case inputs
2. **Learning** — Tests document expected behavior and serve as living examples of how each structure works

Tests are written using **JUnit 5** and follow the same package structure as the main source, making it easy to locate the test for any given implementation.

To run all tests:

```bash
mvn test
```

---

## Setup & Running the Project

### Prerequisites

Before you begin, make sure you have the following installed:
 
- **Java 17 or higher** — The programming language this project is written in
- **Maven 3.6 or higher** — A build tool that manages dependencies and runs the project
- **Git** — For cloning the repository to your local machine
**Not sure if you have them installed?** Run these commands in your terminal:
 
```bash
java -version
mvn -version
git --version
```
 
If any of these aren't installed, you can download them here:
- Java: https://adoptium.net
- Maven: https://maven.apache.org/download.cgi
- Git: https://git-scm.com/downloads
---

### Step 1 — Clone the Repository
 
This downloads the project to your computer:
 
```bash
git clone https://github.com/sriyanshsrivastava-dev/dsa-java.git
cd dsa-java
```
 
### Step 2 — Build the Project
 
This compiles the code and sets everything up. Maven will automatically download any required dependencies:
 
```bash
mvn clean install
```
 
### Step 3 — Run All Tests
 
This runs every unit test in the project to confirm everything is working:
 
```bash
mvn test
```
 
### Step 4 — Run a Specific Demo
 
Each data structure or design pattern includes a `*Main.java` file for running demonstrations directly.
 
**Example — run the Singly Linked List demo:**
 
```bash
mvn exec:java "-Dexec.mainClass=dsa.linkedlist.SinglyLinkedListMain" -q
```
 
**Example — run the Doubly Linked List demo:**
 
```bash
mvn exec:java "-Dexec.mainClass=dsa.linkedlist.DoublyLinkedListMain" -q
```
 
**Example — run the Builder Pattern demo:**
 
```bash
mvn exec:java "-Dexec.mainClass=designpattern.builderpattern.TestClass" -q
```

> Replace the class path with the appropriate package and class name for other implementations.

---

##  Contributing

Contributions are welcome and encouraged — every bit helps make this a better learning resource for everyone.
 
**First time contributing to open source?** That's completely fine! A pull request is simply a way of saying "here's a change I'd like to suggest." GitHub walks you through the process step by step.
 
Whether you're fixing a bug, improving documentation, adding explanations, writing tests, or implementing a new topic — your input matters here.
 
Please read [CONTRIBUTING.md](CONTRIBUTING.md) before submitting a pull request. Key guidelines include:
 
- Follow the existing Maven project structure
- Write clean, readable code with meaningful comments
- Include JUnit tests for every new implementation
- Use conventional commit messages (`feat:`, `fix:`, `docs:`, etc.)
- Submit PRs to the `develop` branch, not directly to `main`
All contributions — big or small — are valued.

---

## Future Roadmap

The following topics are planned for future implementation. This list reflects the long-term direction of the project:

**Data Structures**
-  Stack
-  Queue
-  Binary Tree
-  Binary Search Tree
-  Graph
-  Heap / Priority Queue
-  Hash Map / Hash Table

**Algorithms**
-  Recursion fundamentals
-  Sorting algorithms (Bubble, Selection, Insertion, Merge, Quick)
-  Searching algorithms (Binary Search, BFS, DFS)
-  Dynamic Programming
-  Greedy Algorithms

**Design Patterns**
-  Strategy Pattern
-  Singleton Pattern
-  Factory Pattern
-  Observer Pattern
-  Decorator Pattern

This roadmap will evolve as the project grows. Community suggestions are welcome via [Issues](https://github.com/sriyanshsrivastava-dev/dsa-java/issues).

---

##  A Note on This Repository

This is an **actively maintained and evolving project**. Implementations and documentation may be refined over time as understanding deepens and best practices improve. Some early implementations may be revisited and improved that's intentional. The goal is long-term quality, not short-term completeness.

If you notice something that could be improved a clearer explanation, a missing edge case, a better approach please open an issue or submit a pull request. This project grows best as a collaborative learning effort.

---

##  License

This project is licensed under the terms described in the [LICENSE](./LICENSE) file. Please review it before using or contributing to this repository.

---

<div align="center">

*Built with a focus on learning deeply, not just solving quickly.*

**[ View GitHub Pages Site](https://sriyanshsrivastava-dev.github.io/dsa-java/)** &nbsp;|&nbsp; **[ Report an Issue](https://github.com/sriyanshsrivastava-dev/dsa-java/issues)** &nbsp;|&nbsp; **[ Contribute](./CONTRIBUTING.md)**

</div>
