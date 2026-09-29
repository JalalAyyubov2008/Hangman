import java.util.Scanner;

public class HangmanRunner {
    private final Scanner scanner = new Scanner(System.in);
    private HangmanStage hangmanStage;
    private HangmanChecker hangmanChecker;

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
                if (hangmanChecker.checkIfFinalAttempt()) break;
                
                hangmanChecker.openLetter(letter);
                if (hangmanChecker.checkIfCompleted()) break;
                hangmanStage.printAttempts();
                hangmanStage.printWordStage();
                hangmanStage.showMistakes();
            }
            if (!reset()) return;
        }
    }

    public boolean reset() {
        String word = HangmanStartLeave.start();
        if (word == null) {
            System.out.println("Could not retrieve a word");
            return false;
        }
        this.hangmanStage = new HangmanStage(word);
        this.hangmanChecker = new HangmanChecker(word, hangmanStage);
        return true;
    }
}
