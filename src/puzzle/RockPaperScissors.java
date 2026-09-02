package puzzle;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void play(Scanner scanner) {

        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("\n===== ROCK PAPER SCISSORS =====");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");

        System.out.print("Choose: ");
        int playerChoice = scanner.nextInt();

        int computerChoice = random.nextInt(3) + 1;

        System.out.println("Computer chose: " + choices[computerChoice - 1]);

        if (playerChoice == computerChoice) {
            System.out.println("It's a draw!");
        } else if (
                (playerChoice == 1 && computerChoice == 3) ||
                (playerChoice == 2 && computerChoice == 1) ||
                (playerChoice == 3 && computerChoice == 2)
        ) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}