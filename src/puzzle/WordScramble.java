package puzzle;

import java.util.Random;
import java.util.Scanner;

public class WordScramble {

    public static void play(Scanner scanner) {

        Random random = new Random();

        String[] words = {
                "apple",
                "computer",
                "java",
                "school",
                "puzzle"
        };

        String word = words[random.nextInt(words.length)];

        char[] letters = word.toCharArray();

        // Simple scrambling
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);

            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }

        String scrambledWord = new String(letters);

        System.out.println("\n===== WORD SCRAMBLE =====");
        System.out.println("Unscramble this word:");
        System.out.println(scrambledWord);

        System.out.print("Your answer: ");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase(word)) {
            System.out.println("Correct! ");
        } else {
            System.out.println("Wrong!");
            System.out.println("The correct word was: " + word);
        }
    }
}