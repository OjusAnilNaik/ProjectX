package puzzle;

import java.util.Scanner;

public class GameMenu {

    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;

        do {
            System.out.println("\n============================");
            System.out.println("       PUZZLE MASTER");
            System.out.println("============================");
            System.out.println("1. Number Guessing");
            System.out.println("2. Rock Paper Scissors");
            System.out.println("3. Word Scramble");
            System.out.println("4. Math Puzzle");
            System.out.println("5. Memory Game");
            System.out.println("6. Exit");
            System.out.println("============================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    NumberGuessing.play(scanner);
                    break;

                case 2:
                    RockPaperScissors.play(scanner);
                    break;

                case 3:
                    WordScramble.play(scanner);
                    break;

                case 4:
                    MathPuzzle.play(scanner);
                    break;

                case 5:
                    MemoryGame.play(scanner);
                    break;

                case 6:
                    System.out.println("Thanks for playing!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}