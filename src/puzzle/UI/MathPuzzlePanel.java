package puzzle.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MathPuzzlePanel extends JPanel {

    private MainFrame frame;

    private JLabel questionLabel;
    private JLabel messageLabel;
    private JLabel scoreLabel;

    private JTextField inputField;

    private int correctAnswer;
    private int score = 0;

    private Random random = new Random();

    public MathPuzzlePanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 35));

        // Title
        JLabel title =
                new JLabel("MATH PUZZLE");

        title.setFont(
                new Font("Arial", Font.BOLD, 32)
        );

        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        add(title, BorderLayout.NORTH);

        // Center
        JPanel centerPanel =
                new JPanel();

        centerPanel.setLayout(
                new BoxLayout(
                        centerPanel,
                        BoxLayout.Y_AXIS
                )
        );

        centerPanel.setBackground(
                new Color(25, 25, 35)
        );

        JLabel instruction =
                new JLabel(
                        "Solve the math problem!"
                );

        instruction.setFont(
                new Font("Arial", Font.PLAIN, 20)
        );

        instruction.setForeground(Color.WHITE);
        instruction.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(
                Box.createVerticalStrut(50)
        );

        centerPanel.add(instruction);

        centerPanel.add(
                Box.createVerticalStrut(30)
        );

        // Question
        questionLabel =
                new JLabel();

        questionLabel.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        questionLabel.setForeground(
                Color.WHITE
        );

        questionLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(questionLabel);

        centerPanel.add(
                Box.createVerticalStrut(25)
        );

        // Input
        inputField =
                new JTextField();

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

        centerPanel.add(
                Box.createVerticalStrut(15)
        );

        // Button
        JButton submitButton =
                new JButton("SUBMIT");

        submitButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(submitButton);

        centerPanel.add(
                Box.createVerticalStrut(20)
        );

        // Message
        messageLabel =
                new JLabel("Good luck!");

        messageLabel.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        messageLabel.setForeground(
                Color.WHITE
        );

        messageLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(messageLabel);

        centerPanel.add(
                Box.createVerticalStrut(15)
        );

        // Score
        scoreLabel =
                new JLabel("Score: 0");

        scoreLabel.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        scoreLabel.setForeground(
                Color.LIGHT_GRAY
        );

        scoreLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        centerPanel.add(scoreLabel);

        add(
                centerPanel,
                BorderLayout.CENTER
        );

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

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        generateQuestion();
    }

    private void generateQuestion() {

        int number1 =
                random.nextInt(20) + 1;

        int number2 =
                random.nextInt(20) + 1;

        int operation =
                random.nextInt(3);

        if (operation == 0) {

            correctAnswer =
                    number1 + number2;

            questionLabel.setText(
                    number1 + " + " + number2 + " = ?"
            );

        } else if (operation == 1) {

            // Keep answer positive
            if (number1 < number2) {

                int temp = number1;

                number1 = number2;
                number2 = temp;
            }

            correctAnswer =
                    number1 - number2;

            questionLabel.setText(
                    number1 + " - " + number2 + " = ?"
            );

        } else {

            int smallNumber =
                    random.nextInt(10) + 1;

            int secondNumber =
                    random.nextInt(10) + 1;

            correctAnswer =
                    smallNumber * secondNumber;

            questionLabel.setText(
                    smallNumber +
                    " × " +
                    secondNumber +
                    " = ?"
            );
        }

        inputField.setText("");
        inputField.requestFocusInWindow();
    }

    private void checkAnswer() {

        String text =
                inputField.getText().trim();

        if (text.isEmpty()) {

            messageLabel.setText(
                    "Enter an answer!"
            );

            return;
        }

        int answer;

        try {

            answer =
                    Integer.parseInt(text);

        } catch (NumberFormatException e) {

            messageLabel.setText(
                    "Enter a valid number!"
            );

            inputField.selectAll();

            return;
        }

        if (answer == correctAnswer) {

            score++;

            messageLabel.setText(
                    "Correct! 🎉"
            );

            scoreLabel.setText(
                    "Score: " + score
            );

            generateQuestion();

        } else {

            messageLabel.setText(
                    "Wrong! Try again."
            );

            inputField.selectAll();
        }
    }
}