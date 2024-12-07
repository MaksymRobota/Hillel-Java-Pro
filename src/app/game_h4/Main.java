package app.game_h4;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println(findSymbolOccurrence("some text", 'o'));
        System.out.println(findWordPosition("Watermelon", "melon"));
        System.out.println(findWordPosition("Green", "Red"));
        System.out.println(stringReverse("Evil rats no melon"));
        System.out.println(isPalindrome("ERE"));
        System.out.println(isPalindrome("Allo"));

        startGuessingGame();
    }

    public static int findSymbolOccurrence(String text, char symbol) {
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (ch == symbol) {
                count++;
            }
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static boolean isPalindrome(String text) {
        String reversed = stringReverse(text);
        return text.equals(reversed);
    }

    public static void startGuessingGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Choose from list: " + String.join(", ", words));

        boolean guessed = false;
        while (!guessed) {
            System.out.print("Your word: ");
            String userGuess = scanner.nextLine().toLowerCase().strip();

            if (userGuess.equals(secretWord)) {
                System.out.println("Congratulations! You guessed the word!");
                guessed = true;
            } else {
                System.out.println("Wrong. Here's a hint: ");
                System.out.println(generateHint(secretWord, userGuess));
            }
        }
    }

    private static String generateHint(String secretWord, String userGuess) {
        StringBuilder hint = new StringBuilder();
        int maxLength = 15;
        for (int i = 0; i < maxLength; i++) {
            if (i < secretWord.length() && i < userGuess.length() && secretWord.charAt(i) == userGuess.charAt(i)) {
                hint.append(secretWord.charAt(i));
            } else {
                hint.append('#');
            }
        }
        return hint.toString();
    }
}