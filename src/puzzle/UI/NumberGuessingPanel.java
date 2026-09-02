package puzzle.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGuessingPanel extends JPanel {

    private MainFrame frame;

    private int targetNumber;
    private int attempts;

    private JLabel messageLabel;
    private JLabel attemptsLabel;
    private JTextField inputField;
    private JButton guessButton;

    public NumberGuessingPanel(MainFrame frame) {

        this.frame = frame;

        startNewGame();

        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 35));

        // =========================
        // TITLE
        // =========================

        JLabel title = new JLabel("NUMBER GUESSING");

        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(title, BorderLayout.NORTH);

        // =========================
        // CENTER PANEL
        // =========================

        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(
                new BoxLayout(centerPanel, BoxLayout.Y_AXIS)
        );

        centerPanel.setBackground(new Color(25, 25, 35));

        // Instruction

        JLabel instruction = new JLabel(
                "Guess a number between 1 and 100"
        );

        instruction.setForeground(Color.WHITE);
        instruction.setFont(
                new Font("Arial", Font.PLAIN, 20)
        );

        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalStrut(60));
        centerPanel.add(instruction);

        centerPanel.add(Box.createVerticalStrut(25));

        // =========================
        // INPUT
        // =========================

        inputField = new JTextField();

        inputField.setMaximumSize(
                new Dimension(200, 40)
        );

        inputField.setHorizontalAlignment(
                JTextField.CENTER
        );

        inputField.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        inputField.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(inputField);

        centerPanel.add(Box.createVerticalStrut(15));

        // =========================
        // GUESS BUTTON
        // =========================

        guessButton = new JButton("GUESS");

        guessButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(guessButton);

        centerPanel.add(Box.createVerticalStrut(20));

        // =========================
        // MESSAGE
        // =========================

        messageLabel = new JLabel("Good luck!");

        messageLabel.setForeground(Color.WHITE);
        messageLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        messageLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(messageLabel);

        centerPanel.add(Box.createVerticalStrut(10));

        // =========================
        // ATTEMPTS
        // =========================

        attemptsLabel = new JLabel("Attempts: 0");

        attemptsLabel.setForeground(Color.LIGHT_GRAY);
        attemptsLabel.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        attemptsLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(attemptsLabel);

        add(centerPanel, BorderLayout.CENTER);

        // =========================
        // BUTTON ACTION
        // =========================

        guessButton.addActionListener(e -> checkGuess());

        // Press ENTER instead of clicking GUESS

        inputField.addActionListener(e -> checkGuess());

        // =========================
        // BACK BUTTON
        // =========================

        JButton backButton = new JButton("← Back");

        backButton.addActionListener(e -> {
            frame.showMenu();
        });

        JPanel bottomPanel = new JPanel();

        bottomPanel.setBackground(
                new Color(25, 25, 35)
        );

        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);

        // Automatically focus input

        inputField.requestFocusInWindow();
    }

    // =================================
    // START NEW GAME
    // =================================

    private void startNewGame() {

        targetNumber =
                new Random().nextInt(100) + 1;

        attempts = 0;
    }

    // =================================
    // CHECK GUESS
    // =================================

    private void checkGuess() {

        String text = inputField.getText().trim();

        // Empty input

        if (text.isEmpty()) {

            messageLabel.setText(
                    "Please enter a number!"
            );

            inputField.requestFocusInWindow();

            return;
        }

        int guess;

        // Convert text to number

        try {

            guess = Integer.parseInt(text);

        } catch (NumberFormatException e) {

            messageLabel.setText(
                    "Please enter a valid number!"
            );

            inputField.selectAll();
            inputField.requestFocusInWindow();

            return;
        }

        // Check range

        if (guess < 1 || guess > 100) {

            messageLabel.setText(
                    "Number must be between 1 and 100!"
            );

            inputField.selectAll();
            inputField.requestFocusInWindow();

            return;
        }

        // Count attempt

        attempts++;

        attemptsLabel.setText(
                "Attempts: " + attempts
        );

        // =========================
        // CHECK ANSWER
        // =========================

        if (guess < targetNumber) {

            messageLabel.setText("⬆ Too low!");

        } else if (guess > targetNumber) {

            messageLabel.setText("⬇ Too high!");

        } else {

            messageLabel.setText(
                    "🎉 Correct! You won!"
            );

            // Stop further guesses

            inputField.setEnabled(false);
            guessButton.setEnabled(false);

            return;
        }

        // Clear input for next guess

        inputField.setText("");

        // Put cursor back in input

        inputField.requestFocusInWindow();
    }
}