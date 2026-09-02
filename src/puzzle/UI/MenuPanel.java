package puzzle.UI;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private MainFrame frame;

    public MenuPanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 35));

        // =========================
        // TITLE
        // =========================

        JLabel title = new JLabel("PUZZLE MASTER");

        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        // =========================
        // SUBTITLE
        // =========================

        JLabel subtitle = new JLabel("Challenge Your Mind!");

        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);

        // =========================
        // HEADER
        // =========================

        JPanel header = new JPanel();

        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(new Color(25, 25, 35));

        header.add(Box.createVerticalStrut(30));
        header.add(title);
        header.add(Box.createVerticalStrut(10));
        header.add(subtitle);
        header.add(Box.createVerticalStrut(20));

        add(header, BorderLayout.NORTH);

        // =========================
        // GAME BUTTONS
        // =========================

        JPanel gamesPanel = new JPanel();

        gamesPanel.setLayout(new GridLayout(5, 1, 10, 10));
        gamesPanel.setBackground(new Color(25, 25, 35));

        JButton numberButton =
                new JButton("Number Guessing");

        JButton rpsButton =
                new JButton("Rock Paper Scissors");

        JButton wordButton =
                new JButton("Word Scramble");

        JButton mathButton =
                new JButton("Math Puzzle");

        JButton memoryButton =
                new JButton("Memory Game");

        gamesPanel.add(numberButton);
        gamesPanel.add(rpsButton);
        gamesPanel.add(wordButton);
        gamesPanel.add(mathButton);
        gamesPanel.add(memoryButton);

        // =========================
        // CENTER PANEL
        // =========================

        JPanel center = new JPanel();

        center.setBackground(new Color(25, 25, 35));
        center.add(gamesPanel);

        add(center, BorderLayout.CENTER);

        // =========================
        // BUTTON ACTIONS
        // =========================

        // Number Guessing
        numberButton.addActionListener(e -> {
            frame.showNumberGuessing();
        });

        // Rock Paper Scissors
        rpsButton.addActionListener(e -> {
            frame.showRockPaperScissors();
        });

        // Word Scramble
        wordButton.addActionListener(e -> {
            frame.showWordScramble();
        });

        // Math Puzzle
        mathButton.addActionListener(e -> {
            frame.showMathPuzzle();
        });

        // Memory Game
        memoryButton.addActionListener(e -> {
            frame.showMemoryGame();
        });

        // =========================
        // EXIT BUTTON
        // =========================

        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        JPanel bottom = new JPanel();

        bottom.setBackground(new Color(25, 25, 35));
        bottom.add(exitButton);

        add(bottom, BorderLayout.SOUTH);
    }
}