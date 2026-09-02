package puzzle.UI;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Puzzle Master");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        showMenu();
    }

    // Show main menu
    public void showMenu() {
        setContentPane(new MenuPanel(this));
        revalidate();
        repaint();
    }

    // Number Guessing
    public void showNumberGuessing() {
        setContentPane(new NumberGuessingPanel(this));
        revalidate();
        repaint();
    }

    // Rock Paper Scissors
    public void showRockPaperScissors() {
        setContentPane(new RockPaperScissorsPanel(this));
        revalidate();
        repaint();
    }

    // Word Scramble
    public void showWordScramble() {
        setContentPane(new WordScramblePanel(this));
        revalidate();
        repaint();
    }

    // Math Puzzle
    public void showMathPuzzle() {
        setContentPane(new MathPuzzlePanel(this));
        revalidate();
        repaint();
    }

    // Memory Game
    public void showMemoryGame() {
        setContentPane(new MemoryGamePanel(this));
        revalidate();
        repaint();
    }
}