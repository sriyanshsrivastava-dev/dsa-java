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

-  **Structured DSA Implementations** — Organized by topic
-  **Java-First** — All implementations in idiomatic Java 17+
-  **Clean, Readable Code** — Written to be understood, not just executed
-  **Maven Project Structure** — Industry-standard build and project organization
-  **Unit Testing** — Every implementation is validated
-  **Beginner-Friendly Approach** — Concepts explained through comments and documentation
-  **Design Pattern Implementations** — Real patterns, explained with real examples
-  **Long-Term Maintainability** — Modular packages designed to scale cleanly
-  **Open-Source Collaboration** — Contributions, improvements, and discussions welcome

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

- **Internal logic over surface-level solutions** — Implementations explain *how* and *why* things work, not just *what* they do
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
│   │       ├── dsa/                    # Data Structures & Algorithms
│   │       │   ├── linkedlist/
│   │       │   ├── stack/
│   │       │   ├── queue/
│   │       │   ├── tree/
│   │       │   └── graph/
│   │       │
│   │       └── designpattern/          # Software Design Patterns
│   │           ├── builderpattern/
│   │           ├── strategypattern/
│   │           └── singletonpattern/
│   │
│   └── test/
│       └── java/
│           ├── dsa/                    # Tests for DSA implementations
│           └── designpattern/          # Tests for Design Pattern implementations
│
├── pom.xml                             # Maven configuration
├── CONTRIBUTING.md                     # Contribution guidelines
├── LICENSE                             # License information
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
  - `SinglyLinkedList` — Linear structure with single directional node linkage
  - `DoublyLinkedList` — Bidirectional node linkage with head and tail references

### Design Patterns

- **Builder Pattern**
  - `Student` — Builder pattern applied to construct a complex student object
  - `UserAccount` — Builder pattern for constructing a user account with optional fields

> More topics are being actively added. See the [Roadmap](#future-roadmap) below.

---

##  Testing

Every implementation in this repository is paired with a corresponding unit test under `src/test/java`.

Tests serve two purposes here:
1. **Validation** — ensuring implementations behave correctly across normal and edge-case inputs
2. **Learning** — tests document expected behavior and serve as living examples of how each structure works

Tests are written using **JUnit 5** and follow the same package structure as the main source, making it easy to locate the test for any given implementation.

To run all tests:

```bash
mvn test
```

---

## Setup & Running the Project

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Git

### Clone the Repository

```bash
git clone https://github.com/sriyanshsrivastava-dev/dsa-java.git
cd dsa-java
```

### Build the Project

```bash
mvn clean install
```

### Run All Tests

```bash
mvn test
```

### Run a Specific Implementation (Demo/Main Class)

Each data structure or design pattern includes a `*Main.java` or `TestClass.java` for running demonstrations directly.

Example — run the Singly Linked List demo:

```bash
mvn exec:java "-Dexec.mainClass=dsa.linkedlist.SinglyLinkedListMain" -q
```

Example — run the Doubly Linked List demo:

```bash
mvn exec:java "-Dexec.mainClass=dsa.linkedlist.DoublyLinkedListMain" -q
```

> Replace the class path with the appropriate package and class name for other implementations.

---

##  Contributing

Contributions are welcome and encouraged! Whether you're fixing a bug, improving documentation, adding explanations, writing tests, or implementing a new topic — your contributions help make this a better learning resource for everyone.

Please read the [CONTRIBUTING.md](./CONTRIBUTING.md) before submitting a pull request. Key guidelines include:

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

This is an **actively maintained and evolving project**. Implementations and documentation may be refined over time as understanding deepens and best practices improve. Some early implementations may be revisited and improved — that's intentional. The goal is long-term quality, not short-term completeness.

If you notice something that could be improved — a clearer explanation, a missing edge case, a better approach — please open an issue or submit a pull request. This project grows best as a collaborative learning effort.

---

##  License

This project is licensed under the terms described in the [LICENSE](./LICENSE) file. Please review it before using or contributing to this repository.

---

<div align="center">

*Built with a focus on learning deeply, not just solving quickly.*

**[ View GitHub Pages Site](https://sriyanshsrivastava-dev.github.io/dsa-java/)** &nbsp;|&nbsp; **[ Report an Issue](https://github.com/sriyanshsrivastava-dev/dsa-java/issues)** &nbsp;|&nbsp; **[ Contribute](./CONTRIBUTING.md)**

</div>
