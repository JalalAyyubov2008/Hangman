import java.util.Scanner;

public class HangmanRunner {
    private final Scanner scanner = new Scanner(System.in);
    private final HangmanStage hangmanStage;
    private final HangmanChecker hangmanChecker;

    public HangmanRunner(HangmanStage hangmanStage, HangmanChecker hangmanChecker) {
        this.hangmanStage = hangmanStage;
        this.hangmanChecker = hangmanChecker;
    }

    public void run() {
        while (true) {
            hangmanStage.printAttempts();
            hangmanStage.showMistakes();
            hangmanStage.printWordStage();

            while (true) {
                String letter = scanner.next().trim().toLowerCase();
                if (letter.equals("2")) return;
                if (!hangmanChecker.checkIfAppropriate(letter)) continue;
                if (hangmanChecker.addIfNotUsed(letter)) continue;
                if (hangmanChecker.addIfMistake(letter)) hangmanStage.decreaseAttempts();
                if (hangmanChecker.checkIfFinalAttempt()) return;

                hangmanChecker.openLetter(letter);

                hangmanStage.printAttempts();
                hangmanStage.printWordStage();
                hangmanStage.showMistakes();

                if (hangmanChecker.checkIfCompleted()) {
                    System.out.println("You have successfully guessed the word");
                    System.out.println("Would you like to play again?");
                    break;
                }
            }
        }
    }
}
