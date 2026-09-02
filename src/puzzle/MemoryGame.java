package puzzle;

import java.util.Scanner;

public class MemoryGame {

    public static void play(Scanner scanner) {

        String[] cards = {
                "A", "B", "C", "D"
        };

        System.out.println("\n===== MEMORY GAME =====");

        System.out.println("Remember these cards:");

        for (String card : cards) {
            System.out.print(card + " ");
        }

        System.out.println();

        System.out.println("\nPress Enter when you are ready...");
        scanner.nextLine();
        scanner.nextLine();

        // Clear the screen approximately
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("What were the cards?");
        System.out.println("1. A B C D");
        System.out.println("2. A C B D");
        System.out.println("3. D C B A");

        System.out.print("Choose the correct answer: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Correct! ");
        } else {
            System.out.println("Wrong!");
        }
    }
}