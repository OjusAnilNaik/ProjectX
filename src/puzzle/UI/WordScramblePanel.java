package puzzle.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WordScramblePanel extends JPanel {

    private MainFrame frame;

    private String currentWord;
    private int score = 0;

    private JLabel scrambledLabel;
    private JLabel messageLabel;
    private JLabel scoreLabel;

    private JTextField inputField;

    private String[] words = {
            "JAVA",
            "PUZZLE",
            "COMPUTER",
            "PROGRAM",
            "GAMING",
            "KEYBOARD",
            "SOFTWARE",
            "DEVELOPER"
    };

    private Random random = new Random();

    public WordScramblePanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 35));

        // Title
        JLabel title = new JLabel("WORD SCRAMBLE");

        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(title, BorderLayout.NORTH);

        // Center
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(25, 25, 35));

        JLabel instruction =
                new JLabel("Unscramble the word!");

        instruction.setFont(
                new Font("Arial", Font.PLAIN, 20)
        );

        instruction.setForeground(Color.WHITE);
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalStrut(50));
        centerPanel.add(instruction);
        centerPanel.add(Box.createVerticalStrut(30));

        // Scrambled word
        scrambledLabel = new JLabel();

        scrambledLabel.setFont(
                new Font("Arial", Font.BOLD, 32)
        );

        scrambledLabel.setForeground(Color.WHITE);
        scrambledLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(scrambledLabel);

        centerPanel.add(Box.createVerticalStrut(30));

        // Input
        inputField = new JTextField();

        inputField.setMaximumSize(
                new Dimension(250, 40)
        );

        inputField.setHorizontalAlignment(
                JTextField.CENTER
        );

        inputField.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        inputField.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(inputField);

        centerPanel.add(Box.createVerticalStrut(15));

        // Submit
        JButton submitButton =
                new JButton("SUBMIT");

        submitButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(submitButton);

        centerPanel.add(Box.createVerticalStrut(20));

        // Message
        messageLabel =
                new JLabel("Good luck!");

        messageLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        messageLabel.setForeground(Color.WHITE);
        messageLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(messageLabel);

        centerPanel.add(Box.createVerticalStrut(15));

        // Score
        scoreLabel =
                new JLabel("Score: 0");

        scoreLabel.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        scoreLabel.setForeground(Color.LIGHT_GRAY);
        scoreLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(scoreLabel);

        add(centerPanel, BorderLayout.CENTER);

        // Actions
        submitButton.addActionListener(
                e -> checkAnswer()
        );

        inputField.addActionListener(
                e -> checkAnswer()
        );

        // Back
        JButton backButton =
                new JButton("← Back");

        backButton.addActionListener(e -> {
            frame.showMenu();
        });

        JPanel bottomPanel =
                new JPanel();

        bottomPanel.setBackground(
                new Color(25, 25, 35)
        );

        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);

        startNewWord();
    }

    private void startNewWord() {

        currentWord =
                words[random.nextInt(words.length)];

        String scrambled =
                scrambleWord(currentWord);

        scrambledLabel.setText(scrambled);

        inputField.setText("");

        inputField.requestFocusInWindow();
    }

    private String scrambleWord(String word) {

        char[] letters =
                word.toCharArray();

        for (int i = 0; i < letters.length; i++) {

            int j =
                    random.nextInt(letters.length);

            char temp = letters[i];

            letters[i] = letters[j];

            letters[j] = temp;
        }

        return new String(letters);
    }

    private void checkAnswer() {

        String answer =
                inputField.getText()
                        .trim()
                        .toUpperCase();

        if (answer.isEmpty()) {

            messageLabel.setText(
                    "Enter an answer!"
            );

            return;
        }

        if (answer.equals(currentWord)) {

            score++;

            messageLabel.setText(
                    "Correct! 🎉"
            );

            scoreLabel.setText(
                    "Score: " + score
            );

            startNewWord();

        } else {

            messageLabel.setText(
                    "Wrong! Try again."
            );

            inputField.selectAll();
            inputField.requestFocusInWindow();
        }
    }
}