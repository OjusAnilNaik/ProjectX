package puzzle;

import java.util.Random;
import java.util.Scanner;

public class MathPuzzle {

    public static void play(Scanner scanner) {

        Random random = new Random();

        int num1 = random.nextInt(20) + 1;
        int num2 = random.nextInt(20) + 1;

        int answer = num1 + num2;

        System.out.println("\n===== MATH PUZZLE =====");
        System.out.println("Solve this:");

        System.out.println(num1 + " + " + num2 + " = ?");

        System.out.print("Your answer: ");
        int userAnswer = scanner.nextInt();

        if (userAnswer == answer) {
            System.out.println("Correct! ");
        } else {
            System.out.println("Wrong!");
            System.out.println("Correct answer: " + answer);
        }
    }
}