import java.util.ArrayList;
import java.util.List;

public class HangmanStage {
    private StringBuilder wordStage;
    private final List<String> mistakes;
    private final List<Character> usedLetters;
    private int attempts;
    private final HangmanRenderer hangmanRenderer;

    public HangmanStage(String word) {
        this.wordStage = new StringBuilder("_".repeat(word.length()));
        this.usedLetters = new ArrayList<>();
        this.mistakes = new ArrayList<>();
        this.attempts = 6;
        this.hangmanRenderer = new HangmanRenderer();
    }

    public void decreaseAttempts() {
        attempts--;
    }

    public void printAttempts() {
        hangmanRenderer.renderStage(getAttempts());
        System.out.println("\n-----------------------------------");
    }

    public int getAttempts() {
        return attempts;
    }

    public StringBuilder showWordStage() {
        return this.wordStage;
    }

    public void setWordStage(StringBuilder wordStage) {
        this.wordStage = wordStage;
    }

    public void showMistakes() {
        System.out.print("Mistakes: ");
        getMistakes().forEach(m -> System.out.print(m + " "));
        System.out.println("\n-----------------------------------");
    }

    public void useLetter(String letter) {
        getUsedLetters().add(letter.charAt(0));
    }

    public List<Character> getUsedLetters() {
        return usedLetters;
    }

    public List<String> getMistakes() {
        return mistakes;
    }
}

