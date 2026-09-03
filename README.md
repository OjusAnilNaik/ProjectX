# 🎮 PuzzleFlow

> A Java Swing application featuring five interactive mini-games in one desktop application.

**Puzzle Master** is a Java-based desktop game collection built using **Java Swing**. It brings together five simple puzzle and casual games under a single graphical interface.

The project is designed to demonstrate Java fundamentals, object-oriented programming, GUI development, event handling, randomization, and basic game logic.

---

## ✨ Features

Puzzle Master currently includes **five games**:

### 🎯 1. Number Guessing

Try to guess a randomly generated number between **1 and 100**.

* Generates a random number for every game
* Provides **Too High** / **Too Low** hints
* Tracks the number of attempts
* Displays a success message when the number is guessed

### ✊ 2. Rock Paper Scissors

Play the classic Rock Paper Scissors game against the computer.

* Choose Rock, Paper, or Scissors
* Computer makes a randomized choice
* Automatically determines the winner
* Simple and interactive GUI

### 🔤 3. Word Scramble

Unscramble a randomly selected word.

* Generates a word
* Scrambles its characters
* Allows the player to enter a guess
* Checks the answer and provides feedback

### 🧮 4. Math Puzzle

Test your arithmetic skills with automatically generated math problems.

* Randomly generated questions
* Interactive answer input
* Automatic answer verification
* Immediate feedback

### 🧠 5. Memory Game

Test your memory by remembering a sequence and reproducing it correctly.

* Displays a sequence
* Challenges the player to remember it
* Accepts the player's response
* Checks whether the sequence was reproduced correctly

---

## 🖥️ Graphical User Interface

Unlike the original console implementation, the current version uses **Java Swing** for its user interface.

The application starts through `Main.java`, which launches the Swing `MainFrame`. The main frame provides navigation between the menu and each individual game panel.

The UI is organized into separate panels for each game:

```text
MainFrame
│
├── MenuPanel
├── NumberGuessingPanel
├── RockPaperScissorsPanel
├── WordScramblePanel
├── MathPuzzlePanel
└── MemoryGamePanel
```

The main application window is configured as a fixed-size **900 × 600** Swing window.

---

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Java AWT**
* **Object-Oriented Programming**
* **Event-driven programming**
* **Random number generation**
* **Arrays & Strings**
* **Methods & Classes**

No external libraries or frameworks are required.

---

## 📁 Project Structure

```text
ProjectX/
│
├── src/
│   └── puzzle/
│       │
│       ├── Main.java
│       ├── GameMenu.java
│       ├── MathPuzzle.java
│       ├── MemoryGame.java
│       ├── NumberGuessing.java
│       ├── RockPaperScissors.java
│       ├── WordScramble.java
│       │
│       └── UI/
│           ├── MainFrame.java
│           ├── MenuPanel.java
│           ├── MathPuzzlePanel.java
│           ├── MemoryGamePanel.java
│           ├── NumberGuessingPanel.java
│           ├── RockPaperScissorsPanel.java
│           └── WordScramblePanel.java
│
└── README.md
```

The repository currently contains separate game-logic classes as well as dedicated Swing UI components for each game.

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

* **Java JDK 8 or later**
* A Java IDE such as:

  * IntelliJ IDEA
  * Eclipse
  * VS Code
  * NetBeans

You can verify your Java installation with:

```bash
java -version
javac -version
```

---

## ▶️ Running the Project

### Option 1 — Using an IDE

1. Clone the repository:

```bash
git clone https://github.com/OjusAnilNaik/ProjectX.git
```

2. Open the project in your preferred Java IDE.

3. Mark `src` as the source directory if your IDE requires it.

4. Locate:

```text
src/puzzle/Main.java
```

5. Run `Main.java`.

The application will open the **Puzzle Master** graphical interface.

`Main.java` uses `SwingUtilities.invokeLater()` to initialize the GUI on Swing's event-dispatch thread.

---

### Option 2 — Using the Terminal

From the project root:

#### Compile

```bash
javac -d out src/puzzle/*.java src/puzzle/UI/*.java
```

#### Run

```bash
java -cp out puzzle.Main
```

---

## 🧩 Application Flow

```text
                    ┌─────────────────┐
                    │   Puzzle Master  │
                    │     Main Menu    │
                    └────────┬────────┘
                             │
          ┌──────────────────┼──────────────────┐
          │                  │                  │
          ▼                  ▼                  ▼
   Number Guessing    Rock Paper Scissors   Word Scramble
          │                  │                  │
          └──────────────────┼──────────────────┘
                             │
                    ┌────────┴────────┐
                    ▼                 ▼
               Math Puzzle       Memory Game
```

The `MainFrame` handles switching between the different game panels, allowing the application to behave as a single cohesive desktop application rather than five separate programs.

---

## 📚 Concepts Demonstrated

This project is useful for practicing several core Java concepts:

### Java Fundamentals

* Variables and data types
* Conditional statements
* Loops
* Methods
* Arrays
* Strings
* Random number generation

### Object-Oriented Programming

* Classes and objects
* Encapsulation
* Separation of responsibilities
* Reusable game logic

### GUI Development

* Java Swing
* `JFrame`
* Panels
* Buttons
* Labels
* Text fields
* Event listeners
* Layout management
* GUI navigation

### Application Architecture

The project separates **game logic** from **GUI components**, making the individual games easier to understand and modify.

---

## 🎯 Project Goals

The main goals of Puzzle Master are to:

* Practice Java programming fundamentals
* Learn desktop GUI development with Swing
* Understand event-driven programming
* Implement simple game mechanics
* Practice organizing a Java project into multiple classes
* Build a complete interactive application rather than isolated programs

---

## 🔮 Future Improvements

Possible improvements for future versions include:

* 🏆 Global scoring system
* 👤 Player profiles
* 📊 Statistics and game history
* 🎚️ Difficulty levels
* ❤️ Lives / attempt limits
* 🔄 Replay functionality
* 🏅 High-score system
* 🔊 Sound effects and background music
* 🎨 Improved animations and visual design
* 💾 Persistent score storage
* ➕ Additional mini-games

---

## 📌 Project Status

**Current Status:** Active development

The project currently contains the core five games along with a Java Swing-based graphical interface.

The repository structure and implementation may continue to change as new features and improvements are added.

---

## 👨‍💻 Author

**Ojus Anil Naik**

GitHub: [@OjusAnilNaik](https://github.com/OjusAnilNaik)

---

## 📄 License

This project is intended primarily for **educational and learning purposes**.

---

⭐ If you found this project interesting, consider giving the repository a star!

**Repository:** https://github.com/OjusAnilNaik/ProjectX
