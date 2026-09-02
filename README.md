# 🎮 Puzzle Master

Puzzle Master is a beginner-level Java console application that contains five simple mini-games. The project is designed to practice basic Java programming concepts such as variables, loops, conditions, arrays, methods, user input, and random numbers.

## 🎯 Games

The project currently contains five games:

1. **Number Guessing** 🎯
   - The computer selects a random number between 1 and 100.
   - The player tries to guess the number.
   - The game gives hints such as "Too high" or "Too low".

2. **Rock Paper Scissors** ✊
   - The player chooses Rock, Paper, or Scissors.
   - The computer randomly selects its choice.
   - The winner is determined using the standard rules.

3. **Word Scramble** 🔤
   - The game selects a random word.
   - The letters are scrambled.
   - The player must guess the original word.

4. **Math Puzzle** 🧮
   - The game generates a random mathematical question.
   - The player enters the answer.
   - The game checks whether the answer is correct.

5. **Memory Game** 🧠
   - The player is shown a sequence of cards.
   - The cards are hidden.
   - The player must remember the original order.

## 🛠️ Technologies Used

- **Java**
- Java `Scanner`
- Java `Random`
- Arrays
- Loops
- Conditional statements
- Methods
- Basic Object-Oriented Programming

## 📁 Project Structure

```text
PuzzleGame/
│
├── src/
│   └── puzzle/
│       ├── Main.java
│       ├── GameMenu.java
│       ├── NumberGuessing.java
│       ├── RockPaperScissors.java
│       ├── WordScramble.java
│       ├── MathPuzzle.java
│       └── MemoryGame.java
│
└── README.md
```

## ▶️ How to Run

### 1. Clone or download the project

Download the project to your computer.

### 2. Open the project

Open the project using a Java IDE such as:

- IntelliJ IDEA
- Eclipse
- VS Code
- NetBeans

### 3. Run `Main.java`

Bash the command in terminal: java main.java

The application will display the main menu:

```text
============================
       PUZZLE MASTER
============================
1. Number Guessing
2. Rock Paper Scissors
3. Word Scramble
4. Math Puzzle
5. Memory Game
6. Exit
============================

Enter your choice:
```

Enter a number from `1` to `6` to select an option.

## 📚 Learning Objectives

This project was created to practice the following Java concepts:

- Variables and data types
- `if`, `else if`, and `else`
- `switch` statements
- `for` and `while` loops
- Arrays
- Strings
- Methods
- User input using `Scanner`
- Random number generation using `Random`
- Basic classes and objects
- Program structure

## 🚀 Future Improvements

The project can be expanded with:

- 👤 Player names
- 🏆 Overall scoring system
- ❤️ Lives/attempt limits
- 🎚️ Difficulty levels
- 🔄 Replay option for each game
- 🏅 High-score/leaderboard system
- 🎨 GUI using Java Swing or JavaFX
- 💾 Saving scores to a file
- ➕ More puzzle games
- 🧠 Improved Memory Game with a proper card board

## 👨‍💻 Project Status

**Current version:** `v1.0`

The current version focuses on implementing the five basic games using beginner-level Java concepts.

## 📄 License

This project is created for educational and learning purposes.

```

You can keep this as **v1.0**. Don't pad the README with features you haven't implemented yet—that makes a beginner project look dishonest. As we add the score system, difficulty, GUI, etc., we can update the README version-by-version.
```
