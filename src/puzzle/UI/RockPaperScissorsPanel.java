package puzzle.UI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsPanel extends JPanel {

    private MainFrame frame;

    private JLabel resultLabel;
    private JLabel scoreLabel;

    private int playerScore = 0;
    private int computerScore = 0;

    private Random random = new Random();

    public RockPaperScissorsPanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 35));

        // Title
        JLabel title = new JLabel("ROCK PAPER SCISSORS");

        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(title, BorderLayout.NORTH);

        // Center
        JPanel centerPanel = new JPanel();

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(25, 25, 35));

        JLabel instruction = new JLabel("Choose your move!");

        instruction.setFont(new Font("Arial", Font.PLAIN, 22));
        instruction.setForeground(Color.WHITE);
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalStrut(60));
        centerPanel.add(instruction);
        centerPanel.add(Box.createVerticalStrut(30));

        // Buttons
        JPanel buttonsPanel = new JPanel();

        buttonsPanel.setBackground(new Color(25, 25, 35));

        JButton rockButton = new JButton("ROCK");
        JButton paperButton = new JButton("PAPER");
        JButton scissorsButton = new JButton("SCISSORS");

        buttonsPanel.add(rockButton);
        buttonsPanel.add(paperButton);
        buttonsPanel.add(scissorsButton);

        centerPanel.add(buttonsPanel);
        centerPanel.add(Box.createVerticalStrut(30));

        // Result
        resultLabel = new JLabel("Make your choice!");

        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(resultLabel);
        centerPanel.add(Box.createVerticalStrut(20));

        // Score
        scoreLabel = new JLabel("You: 0    Computer: 0");

        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        scoreLabel.setForeground(Color.LIGHT_GRAY);
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(scoreLabel);

        add(centerPanel, BorderLayout.CENTER);

        // Button actions
        rockButton.addActionListener(e -> playGame("Rock"));

        paperButton.addActionListener(e -> playGame("Paper"));

        scissorsButton.addActionListener(e -> playGame("Scissors"));

        // Back button
        JButton backButton = new JButton("← Back");

        backButton.addActionListener(e -> {
            frame.showMenu();
        });

        JPanel bottomPanel = new JPanel();

        bottomPanel.setBackground(new Color(25, 25, 35));
        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void playGame(String playerChoice) {

        String[] choices = {
                "Rock",
                "Paper",
                "Scissors"
        };

        String computerChoice =
                choices[random.nextInt(3)];

        if (playerChoice.equals(computerChoice)) {

            resultLabel.setText(
                    "Computer chose " + computerChoice + " — Draw!"
            );

        } else if (
                (playerChoice.equals("Rock") &&
                        computerChoice.equals("Scissors")) ||

                (playerChoice.equals("Paper") &&
                        computerChoice.equals("Rock")) ||

                (playerChoice.equals("Scissors") &&
                        computerChoice.equals("Paper"))
        ) {

            playerScore++;

            resultLabel.setText(
                    "Computer chose " + computerChoice + " — You Win!"
            );

        } else {

            computerScore++;

            resultLabel.setText(
                    "Computer chose " + computerChoice + " — Computer Wins!"
            );
        }

        scoreLabel.setText(
                "You: " + playerScore +
                "    Computer: " + computerScore
        );
    }
}