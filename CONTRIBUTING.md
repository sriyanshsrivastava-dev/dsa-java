# Contributing to Java DSA Implementation

Thank you for your interest in contributing! This document explains **how to contribute professionally** to the project.

---

## Fork & Clone

1. Fork the repository  
2. Clone your fork:

```bash
git clone https://github.com/<your-username>/java-dsa-implementation.git
cd java-dsa-implementation
````

3. Set upstream remote to sync later:

```bash
git remote add upstream https://github.com/sriyanshsrivastava-dev/dsa-java.git
```

---

## Branching Strategy

* **Main**: Stable, production-ready code
* **Develop**: Latest development code
* **Feature Branches**: Work on individual features/issues

Naming convention:

```
feature/<feature-name>
fix/<bug-description>
```

**Example:**

```
feature/linkedlist-implementation
fix/stack-overflow-bug
```

---

## Commit Messages

Use **conventional commits**:

```
feat: new feature or module
fix: bug fix
chore: maintenance or refactor
docs: documentation changes
test: adding/updating tests
```

**Example:**

```
feat: implement singly linked list with basic operations
fix: correct stack push logic
docs: update README with setup instructions
```

---

## Pull Request Workflow

1. Sync your fork:

```bash
git fetch upstream
git checkout develop
git merge upstream/develop
```

2. Create a feature branch:

```bash
git checkout -b feature/<your-feature-name>
```

3. Commit frequently with descriptive messages
4. Push to your fork:

```bash
git push origin feature/<your-feature-name>
```

5. Open a **Pull Request** to `develop` branch of the main repo
6. Request review from maintainers (or another account if solo)
7. After approval, merge PR into `develop`

> Do **not push directly to develop or main**.

---

## Coding Standards

* Java 17+
* Proper **naming conventions** for classes, methods, and variables
* Include **Javadoc style comments** for all methods
* Follow **Maven project structure** (`src/main/java`, `src/test/java`)
* Write **unit tests** for each implementation

---

## Issues & Bug Reporting

* Report issues under the **Issues** tab
* Include **description, steps to reproduce, expected behavior, actual behavior**
* Optionally include code snippets or screenshots

---

## Thank You

Thank you for contributing! Your contributions make this project better for everyone.
