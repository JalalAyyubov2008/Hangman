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
            HangmanRenderer hangmanRenderer = new HangmanRenderer();

            System.out.println("The guess word: " + hangmanStage.showWordStage());

            int attempts = 6;
            while (true) {
                // Checking the letters
                System.out.println("-----------------------------------");
                System.out.println("Your remained attempts: " + attempts);
                System.out.println("-----------------------------------");
                String letter = scanner.next().toLowerCase();
                System.out.println();

                if (letter.equals("2")) {
                    HangmanStartLeave.leave();
                    return;
                }
                if (!hangmanChecker.checkIfAppropriate(letter)) {
                    System.out.println("Enter an allowed letter (а-я, А-Я)");
                    continue;
                }

                boolean isUsed = hangmanChecker.checkIfUsed(letter);
                if (isUsed) continue;

                if (!randomWord.contains(letter) && !hangmanStage.getMistakes().contains(letter)) {
                    attempts--;
                    System.out.println("===============================================");
                    hangmanRenderer.renderStage(attempts);
                    System.out.println("======================================\n");

                }
                if (attempts == 0) {
                    System.out.println("##################################");
                    System.out.println("You have used up all your attempts");
                    System.out.println("##################################\n");
                    System.out.println("*******************************");
                    System.out.println("THE WORD - " + randomWord);
                    System.out.println("*******************************");
                    break;
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
