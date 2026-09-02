package puzzle.UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGamePanel extends JPanel {

    private MainFrame frame;

    private JButton[] cards = new JButton[16];

    private String[] symbols = {
            "A", "A",
            "B", "B",
            "C", "C",
            "D", "D",
            "E", "E",
            "F", "F",
            "G", "G",
            "H", "H"
    };

    private int firstCard = -1;
    private int secondCard = -1;

    private int matchedPairs = 0;
    private int moves = 0;

    private JLabel movesLabel;
    private JLabel messageLabel;

    private boolean checking = false;

    public MemoryGamePanel(MainFrame frame) {

        this.frame = frame;

        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 35));

        // Title
        JLabel title =
                new JLabel("MEMORY GAME");

        title.setFont(
                new Font("Arial", Font.BOLD, 32)
        );

        title.setForeground(Color.WHITE);

        title.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        add(title, BorderLayout.NORTH);

        // Card panel
        JPanel cardPanel =
                new JPanel();

        cardPanel.setLayout(
                new GridLayout(4, 4, 10, 10)
        );

        cardPanel.setBackground(
                new Color(25, 25, 35)
        );

        ArrayList<String> shuffledSymbols =
                new ArrayList<>();

        Collections.addAll(
                shuffledSymbols,
                symbols
        );

        Collections.shuffle(
                shuffledSymbols
        );

        for (int i = 0; i < 16; i++) {

            int index = i;

            cards[i] =
                    new JButton("?");

            cards[i].setFont(
                    new Font(
                            "Arial",
                            Font.BOLD,
                            24
                    )
            );

            cardPanel.add(cards[i]);

            cards[i].addActionListener(e -> {
                selectCard(index);
            });
        }

        add(
                cardPanel,
                BorderLayout.CENTER
        );

        // Bottom information
        JPanel bottomPanel =
                new JPanel();

        bottomPanel.setBackground(
                new Color(25, 25, 35)
        );

        movesLabel =
                new JLabel("Moves: 0");

        movesLabel.setForeground(
                Color.LIGHT_GRAY
        );

        movesLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        16
                )
        );

        messageLabel =
                new JLabel("Find all matching pairs!");

        messageLabel.setForeground(
                Color.WHITE
        );

        messageLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        JButton backButton =
                new JButton("← Back");

        backButton.addActionListener(e -> {
            frame.showMenu();
        });

        bottomPanel.add(movesLabel);
        bottomPanel.add(messageLabel);
        bottomPanel.add(backButton);

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // Store shuffled symbols
        for (int i = 0; i < 16; i++) {

            cards[i].putClientProperty(
                    "symbol",
                    shuffledSymbols.get(i)
            );
        }
    }

    private void selectCard(int index) {

        if (checking) {
            return;
        }

        if (cards[index].getText()
                .equals("?") == false) {

            return;
        }

        cards[index].setText(
                (String) cards[index]
                        .getClientProperty("symbol")
        );

        if (firstCard == -1) {

            firstCard = index;

            return;
        }

        secondCard = index;

        moves++;

        movesLabel.setText(
                "Moves: " + moves
        );

        checkPair();
    }

    private void checkPair() {

        checking = true;

        String firstSymbol =
                (String) cards[firstCard]
                        .getClientProperty("symbol");

        String secondSymbol =
                (String) cards[secondCard]
                        .getClientProperty("symbol");

        if (firstSymbol.equals(secondSymbol)) {

            matchedPairs++;

            cards[firstCard].setEnabled(false);
            cards[secondCard].setEnabled(false);

            messageLabel.setText(
                    "Match! 🎉"
            );

            resetSelection();

            if (matchedPairs == 8) {

                messageLabel.setText(
                        "🎉 You completed the game!"
                );
            }

        } else {

            Timer timer =
                    new Timer(700, e -> {

                        cards[firstCard].setText("?");
                        cards[secondCard].setText("?");

                        resetSelection();
                    });

            timer.setRepeats(false);
            timer.start();
        }
    }

    private void resetSelection() {

        firstCard = -1;
        secondCard = -1;

        checking = false;
    }
}