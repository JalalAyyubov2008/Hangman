import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            // Choosing an option
            HangmanOptions hangmanOptions = new HangmanOptions();
            Scanner scanner = new Scanner(System.in);

            String randomWord = hangmanOptions.chooseOption();
            if (randomWord == null) return;

            HangmanChecker hangmanChecker = new HangmanChecker(randomWord);
            HangmanStage hangmanStage = new HangmanStage(randomWord);

            while (true) {
                // Checking the letters
                System.out.println("Allowed letter: а-я, А-Я. Input a letter: ");
                String letter = scanner.next().toLowerCase();
                System.out.println();

                if (letter.equals("2")) {
                    HangmanStartLeave.leave();
                    return;
                }
                if (!hangmanChecker.checkIfAppropriate(letter)) {
                    System.out.println("Enter a correct letter/");
                    continue;
                }

                StringBuilder processedWord = hangmanChecker.checkLetter(letter);
                System.out.println("The guess word: " + processedWord);

                // Checking if completed
                boolean isCompleted = hangmanStage.checkIfCompleted(processedWord);
                if (isCompleted) {
                    System.out.println("Congratulations! You have successfully guessed the word");
                    System.out.println("Would you like to play again?");
                    break;
                }
            }
        }
    }
}
