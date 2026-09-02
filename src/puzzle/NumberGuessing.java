package puzzle;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    public static void play(Scanner scanner) {

        Random random = new Random();

        int number = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("\n===== NUMBER GUESSING =====");
        System.out.println("I have selected a number between 1 and 100.");

        while (guess != number) {

            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < number) {
                System.out.println("Too low!");
            } else if (guess > number) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct!");
                System.out.println("You got it in " + attempts + " attempts.");
            }
        }
    }
}