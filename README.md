# Java DSA Implementation

A comprehensive collection of **Data Structures and Algorithms (DSA) implemented in Java**.  
This repository is designed for learning, reference, and hands-on practice of DSA concepts with **well-documented code, professional structure, and examples**.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Branching & Workflow](#branching--workflow)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

This project contains:

- **Core DSA implementations**: Arrays, Linked Lists, Stacks, Queues, Trees, Graphs, Hashing, Heaps, etc.  
- **Algorithm implementations**: Sorting, Searching, Dynamic Programming, Graph algorithms.  
- **Professional documentation**: Each class and method includes detailed comments and explanations.  
- **Clean branching workflow**: `feature → develop → main` structure to maintain stable main branch.

---

## Features

- Clear, modular, and optimized Java implementations
- Examples for each DSA concept
- Proper commit and branch management for professional workflow
- Easy for beginners to explore and learn DSA

---

## Installation

Clone the repository:

```bash
git clone https://github.com/sriyanshsrivastava-dev/java-dsa-implementation.git
cd java-dsa-implementation
````

Build with Maven:

```bash
mvn clean install
```

---

## Usage

* Explore individual modules in `src/main/java`
* Run tests for each module in `src/test/java` using Maven:

```bash
mvn test
```

* Add your own implementation in **feature branches** and submit PRs to develop.

---

## Branching & Workflow

* **Main**: Stable, production-ready code
* **Develop**: Latest development code
* **Feature branches**: Implement a specific module or issue (`feature/<module-name>`)

Workflow:

1. Create a feature branch from `develop`
2. Make changes, commit frequently with descriptive messages
3. Push feature branch → create PR to `develop`
4. After review and testing, merge PR into `develop`
5. Stable develop merges to `main` periodically

---

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---